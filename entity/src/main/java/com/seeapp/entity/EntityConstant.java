package com.seeapp.entity;

/**
 * Entity 相关常量
 *
 * @author zhuhui
 */
public interface EntityConstant {

    interface BillType {

        String CPC = "cpc";
    }

    /**
     * 交易方类型
     */
    interface CounterpartyType {

        /**
         * kol
         */
        String KOL = "kol";

        /**
         * 供应商
         */
        String VENDOR = "vendor";
    }

    interface BillStatus {

        String NEW = "new";

        /**
         * 签发
         */
        String SIGN = "sign";

        String CONFIRM = "confirm";

        String ERROR = "error";

        /**
         * 入账
         */
        String POSTED = "posted";

        String DELETE = "delete";
    }

    interface BillConvRateIsAbnormal {

        /**
         * 是
         */
        String YES = "yes";

        /**
         * 否
         */
        String NO = "no";

        /**
         * 待定
         */
        String TO_BE_DETERMINED = "tbd";
    }

    interface PayStatus {

        /**
         * 未付
         */
        String NO_PAY = "nopay";

        /**
         * 结清
         */
        String CLEAR = "clear";

        /**
         * 部分付款
         */
        String NO_CLEAR = "noclear";
    }
}
