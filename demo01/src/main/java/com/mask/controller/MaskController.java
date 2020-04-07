package com.mask.controller;

import com.github.pagehelper.PageInfo;
import com.mask.model.MaskModel;
import com.mask.service.MaskService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MaskController {

    // 使用 slf4j 作为日志框架
    private static final Logger LOGGER = LoggerFactory.getLogger(MaskController.class);
    @Autowired
    private MaskService maskService;


    @RequestMapping("/test")
    public String testList(){
        LOGGER.info("-------testList--------");
        return "data-table";

    }

    @GetMapping("/{id}")
    public MaskModel findMaskById(@PathVariable("id") Integer id){

        LOGGER.info("-------findMaskById--------");
        return maskService.findMaskById(id);
    }

    @PostMapping("/insertMask")
    public int insertMask(@RequestBody MaskModel mask){
        LOGGER.info("-------insertMask--------");
        return maskService.addMask(mask);
    }

    @PostMapping("/updateMask")
    public int updateMask(@RequestBody MaskModel mask){
        LOGGER.info("-------updateMask--------");
        return maskService.updateMask(mask);
    }

    @GetMapping("/findMaskList")
    public PageInfo<MaskModel> findMaskList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        return maskService.findAllMask(pageNum,pageSize);
    }

}