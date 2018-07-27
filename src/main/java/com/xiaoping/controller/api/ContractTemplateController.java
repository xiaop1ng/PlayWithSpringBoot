package com.xiaoping.controller.api;

import com.xiaoping.dao.ContractTemplateDao;
import com.xiaoping.entity.ContractTemplate;
import com.xiaoping.pojo.Rs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/contract")
public class ContractTemplateController {

    @Autowired
    private ContractTemplateDao contractTemplateDao;


    @RequestMapping("/save")
    public Rs saveContracTemplate(){
        ContractTemplate template = new ContractTemplate();
        template.setTemplateName("劳务合同");
        template.setVersion("V1.0.1");
        template.setEnable(true);
        template.setCreateTime(new Date());
        return Rs.ok(contractTemplateDao.save(template));
    }

}
