package com.seeapp.entity;

import com.github.mydog.db.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * demo表，其实是一个账单表
 *
 * @author xingping
 */
@Entity
@Table(name = "demo")
public class Demo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 入账方ID，此处即为backendId
     */
    private Integer accountId;

    /**
     * 账单编号
     */
    private String billNo;

    /**
     * 账单类型，默认为cpc <br/>
     *
     * @see EntityConstant.BillType
     */
    private String type = EntityConstant.BillType.CPC;

    /**
     * 交易方类型，默认为kol <br/>
     *
     * @see EntityConstant.CounterpartyType
     */
    private String cpType = EntityConstant.CounterpartyType.KOL;

    /**
     * 账单类型，默认为new <br/>
     *
     * @see EntityConstant.BillStatus
     */
    private String status = EntityConstant.BillStatus.NEW;

    /**
     * 错误原因
     */
    private String errmsg;

    /**
     * 账单期间
     */
    private String period;

    /**
     * 结算日期从
     */
    private Long balanceDateFrom;

    /**
     * 结算日期至
     */
    private Long balanceDateTo;

    /**
     * 点击数
     */
    private Integer clickNum;

    /**
     * 转化率 <br/>
     * <p>
     * e.g. 0.25，在这里即是25%
     */
    private Double convRate;

    /**
     * 转化率阈值
     * <p>
     * e.g. 0.25，在这里即是25%
     */
    private Double convRateThreshold;

    /**
     * 转化率是否异常 <br/>
     *
     * @see EntityConstant.BillConvRateIsAbnormal
     */
    private String convRateIsAbnormal;

    /**
     * 平均单价：元
     */
    private BigDecimal avgUnitPrice;

    /**
     * 金额，单位：元
     */
    private BigDecimal price;

    // TODO 入账、提现、核销相关字段？
    // TODO 异常说明字段？

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCpType() {
        return cpType;
    }

    public void setCpType(String cpType) {
        this.cpType = cpType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Long getBalanceDateFrom() {
        return balanceDateFrom;
    }

    public void setBalanceDateFrom(Long balanceDateFrom) {
        this.balanceDateFrom = balanceDateFrom;
    }

    public Long getBalanceDateTo() {
        return balanceDateTo;
    }

    public void setBalanceDateTo(Long balanceDateTo) {
        this.balanceDateTo = balanceDateTo;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Double getConvRate() {
        return convRate;
    }

    public void setConvRate(Double convRate) {
        this.convRate = convRate;
    }

    public Double getConvRateThreshold() {
        return convRateThreshold;
    }

    public void setConvRateThreshold(Double convRateThreshold) {
        this.convRateThreshold = convRateThreshold;
    }

    public String getConvRateIsAbnormal() {
        return convRateIsAbnormal;
    }

    public void setConvRateIsAbnormal(String convRateIsAbnormal) {
        this.convRateIsAbnormal = convRateIsAbnormal;
    }

    public BigDecimal getAvgUnitPrice() {
        return avgUnitPrice;
    }

    public void setAvgUnitPrice(BigDecimal avgUnitPrice) {
        this.avgUnitPrice = avgUnitPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
