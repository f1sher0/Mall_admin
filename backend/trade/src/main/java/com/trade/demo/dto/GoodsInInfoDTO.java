package com.trade.demo.dto;

import java.util.Date;

import com.trade.demo.entity.IsReturned;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInInfoDTO {
    private Date goodsInTime;
    private String supplierName;
    private String supplierDesc;
    private String supplierAddress;
    private String email ;
    private int goodsInId;
    private int goodsId;
    private IsReturned isReturned;
    private int warehouseId;
    private String warehouseName;
    private String warehouseAddress;
    private int onShelf;
    private double purchasePrice;
    private double sellingPrice;
 }
