package com.trade.demo.service.impl;

import com.trade.demo.dto.ReturnRequestDTO;
import com.trade.demo.entity.ReturnRequest;
import com.trade.demo.mapper.ReturnRequestMapper;
import com.trade.demo.service.GoodsService;
import com.trade.demo.service.ReturnRequestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReturnRequestServiceImpl extends ServiceImpl<ReturnRequestMapper, ReturnRequest> implements ReturnRequestService {
    @Autowired
    private GoodsService goodsService;
    @Override
    public List<ReturnRequest> getByStatus(String status) {
        return lambdaQuery().eq(ReturnRequest::getStatus, status).list();
    }

    @Override
    public  List<ReturnRequest> getBySubid_Role(Integer id, String role) {
        return lambdaQuery().eq(ReturnRequest::getRole,role).eq(ReturnRequest::getSubmitterId,id).list();
    }
    @Override
    public List<ReturnRequestDTO> getBySubid_Role2(Integer id, String role) {
        List<ReturnRequest> returnRequests =  getBySubid_Role(id, role);
        if(returnRequests==null)return null;
        return returnRequests.stream().map(returnRequest -> {
            String goodsName =   goodsService.getById(returnRequest.getGoodsId()).getGoodsName();
            return convertToDTO(returnRequest, goodsName);
        }).collect(Collectors.toList());
    }

    private ReturnRequestDTO convertToDTO(ReturnRequest returnRequest, String goodsName) {
        ReturnRequestDTO dto = new ReturnRequestDTO();
        BeanUtils.copyProperties(returnRequest, dto);
        dto.setGoodsName(goodsName);
        return dto;
    }
}
