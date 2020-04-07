package com.mask.service.impl;

import com.github.pagehelper.PageInfo;
import com.mask.mapper.MaskMapper;
import com.mask.model.MaskModel;
import com.mask.service.MaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MaskServiceImpl implements MaskService {
    @Autowired
    private MaskMapper maskMapper;

    /**
     * 添加口罩信息
     * @param mask
     * @return
     */
    @Override
    public int addMask(MaskModel mask) {
        return 0;
    }

    /**
     * 根据 id 查询口罩信息
     * @param id
     * @return
     */
    @Override
    public MaskModel findMaskById(Integer id) {
        MaskModel maskModel = maskMapper.selectByPrimaryKey(id);
        if (maskModel == null) {
            return null;
        }else {
            return maskModel;
        }
    }

    /**
     * 查询所有并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<MaskModel> findAllMask(int pageNum, int pageSize) {
        return null;
    }

    /**
     * 更新
     * @param mask
     * @return
     */
    @Override
    public int updateMask(MaskModel mask) {
        return 0;
    }

}
