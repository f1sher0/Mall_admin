package com.med2.demo.entity;



import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Finance对象", description = "财务统计")

public class Finance implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer buyCount;//购货交易次数
    private Integer sucBuy;//成功购物(入库_)
    private Integer totalExpenses;//总共开销(买药的)

    private Integer salesCount;//销售交易次数
    private Integer sucSales ;//交易成功次数
    private Integer totalRevenue;//总共销售额
    private Integer totalProfit;//总共利润
}