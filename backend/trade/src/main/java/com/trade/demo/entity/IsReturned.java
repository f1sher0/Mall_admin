package com.trade.demo.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IsReturned {
    YES("Yes"),
    NO("No");

    @EnumValue
    @JsonValue
    private final String value;

    IsReturned(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
