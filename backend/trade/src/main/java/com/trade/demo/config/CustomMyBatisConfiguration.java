package com.trade.demo.config;

public class CustomMyBatisConfiguration extends org.apache.ibatis.session.Configuration {
    @Override
    public boolean isMapUnderscoreToCamelCase() {
        return false; // 禁用下划线转驼峰
    }
}
