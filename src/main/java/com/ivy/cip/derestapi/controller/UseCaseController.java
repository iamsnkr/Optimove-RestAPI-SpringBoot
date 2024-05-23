package com.ivy.cip.derestapi.controller;


import com.ivy.cip.derestapi.collection.UseCaseAndTopics;
import com.ivy.cip.derestapi.service.UseCaseAndAttrService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usecase/topics")
@Api(tags = "UseCase Controller")
public class UseCaseController {

    @Autowired
    private UseCaseAndAttrService useCaseAndAttrService;

    @GetMapping("/data")
    public List<UseCaseAndTopics> getData(){
         return useCaseAndAttrService.getUseCaseData();
    }


}
