package com.trade.demo.entity;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseGoodsInfo {
    private int warehouseId;
    private String warehouseName;
    private String goodsName;
    private double sellingPrice;

    // Getters and Setters
}