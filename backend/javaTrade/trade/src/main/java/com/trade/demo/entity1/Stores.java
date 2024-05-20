package com.trade.demo.entity1;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Stores对象", description = "存储着库房信息")
public class Stores implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "销售单号")
    private String saleNo;

    @ApiModelProperty(value = "管理人员ID")
    private Integer manageId;

    @ApiModelProperty(value = "出入库记录ID")
    private Integer outInId;

    @ApiModelProperty(value = "库存ID")
    private Integer storageId;
}