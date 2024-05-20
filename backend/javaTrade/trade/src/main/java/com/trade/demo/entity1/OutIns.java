package com.trade.demo.entity1;




import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Out_ins对象", description = "记录出入库信息")
public class OutIns implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "no",type = IdType.AUTO)
    @Alias("单号")
    private String no;



    @ApiModelProperty(value = "出入库时间")
    @Alias("出入库时间")
    private Date time;
    @ApiModelProperty(value = "出入库状态")
    @Alias("出入库状态,1为入库")
    private Integer state;




    @ApiModelProperty(value = "库房")
    @Alias("库房id")
    private Integer storeId;


    @ApiModelProperty(value = "供应商id")
    @Alias("供应商id")
    private Integer supplierId;






}