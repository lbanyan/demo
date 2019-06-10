package com.seeapp.demo.component.configuration;

import com.github.mydog.db.MysqlClient;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 数据库配置
 *
 * @author zhuhui
 */
@Configuration
@MapperScan(basePackages = "com.seeapp.demo.mapper")
public class MysqlConfiguration {

    @Value("${entity.packagesToScan}")
    private String entityPackagesToScan;
    @Value("${hibernate.showSql}")
    private String hibernateShowSql;
    @Value("${hibernate.formatSql}")
    private String hibernateFormatSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;
    @Value("${datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @ConfigurationProperties(prefix = "datasource")
    @Bean
    public DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder.create().type(dataSourceType).build();
        return dataSource;
    }

    @Bean(destroyMethod = "destroy")
    public LocalSessionFactoryBean hibernateSessionFactory(DataSource dataSource) throws Exception {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(entityPackagesToScan);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourcePatternResolver.getResources("classpath*:**/*.hbm.xml");
        sessionFactory.setMappingLocations(resources);
        sessionFactory.setNamingStrategy(new ImprovedNamingStrategy());
        Properties prop = new Properties();
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        prop.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        prop.setProperty("hibernate.show_sql", hibernateShowSql);
        prop.setProperty("hibernate.format_sql", hibernateFormatSql);
        prop.setProperty("hibernate.current_session_context_class",
                "org.springframework.orm.hibernate4.SpringSessionContext");
        sessionFactory.setHibernateProperties(prop);
        return sessionFactory;
    }

    @Bean
    public SqlSessionFactoryBean mybatisSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourcePatternResolver.getResources("classpath*:mapper/**/*.xml");
        sessionFactory.setMapperLocations(resources);
        sessionFactory.setTypeAliasesPackage(entityPackagesToScan);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactory.setConfiguration(configuration);
        //添加分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        pageInterceptor.setProperties(properties);
        sessionFactory.setPlugins(new Interceptor[]{pageInterceptor});
        return sessionFactory;
    }

    @Bean
    public SqlSessionTemplate mybatisTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
    }

    @Bean
    public MysqlClient mysqlClient(HibernateTemplate hibernateTemplate, SqlSessionTemplate mybatisTemplate) {
        MysqlClient mysqlClient = new MysqlClient(hibernateTemplate, mybatisTemplate);
        return mysqlClient;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory hibernateSessionFactory) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(
                hibernateSessionFactory);
        return hibernateTransactionManager;
    }
}
