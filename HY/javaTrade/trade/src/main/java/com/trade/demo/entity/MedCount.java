package com.trade.demo.entity;

import cn.hutool.core.annotation.Alias;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "MedCount对象", description = "用于显示药品剩余数量")


public class MedCount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Alias("药品名字")
    private String name;
    @Alias("药品数量")

    private int count;

    public MedCount(String key, Integer value) {
        this.name=key;this.count=value;
    }

//    public MedCount(String medicineName, int count) {
//        this.name = medicineName;
//        this.count = count;
//    }
//
//    public String getMedicineName() {
//        return name;
//    }
//
//    public int getCount() {
//        return count;
//    }
}