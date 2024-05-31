package com.trade.demo.entity;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseGoodsGroupedInfo {
    private int warehouseId;
    private String warehouseName;
    private String goodsName;
    private int quantity;

    // Getters and Setters
}