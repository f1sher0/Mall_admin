package com.trade.demo.entity1;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
//import java.util.Date;
import java.sql.Date;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Sales对象", description = "存储着销售信息")
public class Sales implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键,销售单号")
    @TableId(value = "no", type = IdType.AUTO)

    private String no;

    @ApiModelProperty(value = "销售状态")
    private Integer  State;



    @ApiModelProperty(value = "销售时间")
    private Date Time;

    @ApiModelProperty(value = "客户ID")
    private Integer customerId;

    @ApiModelProperty(value = "库房ID")
    private Integer storeId;
}
