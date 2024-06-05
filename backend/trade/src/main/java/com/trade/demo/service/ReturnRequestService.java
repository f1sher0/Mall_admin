package com.trade.demo.service;

import com.trade.demo.dto.ReturnRequestDTO;
import com.trade.demo.entity.ReturnRequest;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ReturnRequestService extends IService<ReturnRequest> {
    List<ReturnRequest> getByStatus(String status);

    List<ReturnRequest> getBySubid_Role(Integer id, String role);
   List<ReturnRequestDTO> getBySubid_Role2(Integer id, String role);
}
