package com.xiaoping.controller.api;

import com.xiaoping.dao.ContractTemplateDao;
import com.xiaoping.entity.ContractTemplate;
import com.xiaoping.pojo.Rs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/contract")
public class ContractTemplateController {

    @Autowired
    private ContractTemplateDao contractTemplateDao;


    @PostMapping("/save")
    public Rs saveContracTemplate() {
        ContractTemplate template = new ContractTemplate();
        template.setTemplateName("劳务合同");
        template.setVersion("V1.0.1");
        template.setEnable(true);
        template.setCreateTime(new Date());
        return Rs.ok(contractTemplateDao.save(template));
    }

    @GetMapping("/types")
    public Rs types() {
        return Rs.ok(contractTemplateDao.types());
    }

    @GetMapping("/list")
    public Rs list() {
        return Rs.ok(contractTemplateDao.findAll());
    }

    @PostMapping("/del")
    public Rs delete(@RequestParam long id){
        contractTemplateDao.deleteById(id);
        return Rs.ok();
    }

    @PostMapping("/upsert")
    public Rs upsert(@RequestParam(required = false) Long id,
                     @RequestParam(required = true) String templateName) {
        ContractTemplate template = new ContractTemplate();
        template.setTemplateName(templateName);
        if(id != null){
            template.setId(id);
        }
        return Rs.ok(contractTemplateDao.save(template));
    }

}
