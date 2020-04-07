package com.mask.service;

import com.mask.model.MaskModel;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public interface MaskService {
    int addMask(MaskModel mask);

    MaskModel findMaskById(Integer id);

    PageInfo<MaskModel> findAllMask(int pageNum, int pageSize);

    int updateMask(MaskModel mask);
}
