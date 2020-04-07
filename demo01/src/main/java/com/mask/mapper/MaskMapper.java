package com.mask.mapper;


import com.mask.model.MaskModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 */
@Mapper
public interface MaskMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MaskModel record);

    int insertSelective(MaskModel record);

    MaskModel selectByPrimaryKey(Integer id);

    List<MaskModel> selectStudents();

    int updateByPrimaryKeySelective(MaskModel record);

    int updateByPrimaryKey(MaskModel record);
}
