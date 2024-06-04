package com.trade.demo.dto;

import java.util.Date;

import com.trade.demo.entity.IsReturned;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsOutInfoDTO {
    private Date salesTime;
    private String purchaserName;
    private String purchaserDesc;
    private String purchaserAddress;
    private String email ;
    private int salesId;
    private int goodsId;
    private String  goodsName;
    private IsReturned isReturned;
    private int warehouseId;
    private String warehouseName;
    private String warehouseAddress;
    private int onShelf;
    private double purchasePrice;
    private double sellingPrice;

    // Getters and Setters
}
