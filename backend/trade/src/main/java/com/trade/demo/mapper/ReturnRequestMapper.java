package com.trade.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trade.demo.entity.ReturnRequest;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ReturnRequestMapper extends BaseMapper<ReturnRequest> {
    @Update("UPDATE return_request SET status = #{status}, reviewerName = #{reviewerName}, reviewTime = NOW() WHERE requestId = #{requestId}")
    void updateReturnRequestStatus(@Param("requestId") int requestId, @Param("status") String status, @Param("reviewerName") String reviewerName);

    @Update("UPDATE sales_list_goods SET isReturned = 'Yes' WHERE goodsId = #{goodsId}")
    void markGoodsAsReturned(@Param("goodsId") int goodsId);

    @Update("UPDATE warehouse_goods SET goodsQuantity = goodsQuantity - 1 WHERE goodsId = #{goodsId}")
    void decreaseWarehouseGoodsQuantity(@Param("goodsId") int goodsId);
}
