package com.erp.demo.controller;

import com.erp.demo.domain.HiringInfo;
import com.erp.demo.service.HiringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hiring")
public class HiringController {
    @Autowired
    private HiringService hiringService;

    @PostMapping
    public List<HiringInfo> getJoineeDetails(@RequestBody HiringInfo hiringInfo){
        if(null == hiringInfo){
            return null;
        }
        else{
        }
    }

}
