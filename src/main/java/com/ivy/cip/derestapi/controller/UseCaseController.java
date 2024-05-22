package com.ivy.cip.derestapi.controller;


import com.ivy.cip.derestapi.collection.UseCaseAndTopics;
import com.ivy.cip.derestapi.service.UseCaseAndAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class UseCaseController {

    @Autowired
    private UseCaseAndAttrService useCaseAndAttrService;

    @GetMapping("/save/usecases")
    public List<UseCaseAndTopics> save(){
         return useCaseAndAttrService.save();
    }

}
