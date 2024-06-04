package com.trade.demo.dto;

import java.util.Date;

import com.trade.demo.entity.ReturnRequest;
import lombok.*;
import org.springframework.beans.BeanUtils;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnRequestDTO {
    private Integer requestId;
    private String submitterName;
    private Date submitTime;
    private String reason;
    private Integer goodsId;
    private String status;
    private String reviewerName;
    private Date reviewTime;
    private Integer submitterId;
    private String role;
    private String goodsName; // 新增的商品名属性

    public ReturnRequestDTO convertToDTO(ReturnRequest returnRequest, String goodsName) {
        ReturnRequestDTO dto = new ReturnRequestDTO();
        BeanUtils.copyProperties(returnRequest, dto);
        dto.setGoodsName(goodsName);
        return dto;
    }

}
