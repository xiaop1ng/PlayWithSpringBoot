package com.xiaoping.controller.swagger2;


import com.xiaoping.entity.Emp;
import com.xiaoping.pojo.Rs;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/emp")
public class EmpController {

    //    @Api：修饰整个类，描述Controller的作用
    //    @ApiOperation：描述一个类的一个方法，或者说一个接口
    //    @ApiParam：单个参数描述
    //    @ApiModel：用对象来接收参数
    //    @ApiProperty：用对象接收参数时，描述对象的一个字段
    //    @ApiResponse：HTTP响应其中1个描述
    //    @ApiResponses：HTTP响应整体描述
    //    @ApiIgnore：使用该注解忽略这个API
    //    @ApiError ：发生错误返回的信息
    //    @ApiParamImplicitL：一个请求参数
    //    @ApiParamsImplicit 多个请求参数

    private Map<Long, Emp> emps = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value="获取全部员工列表", notes="获取全部员工列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Rs list() {
        List<Emp> list = new ArrayList<>(emps.values());
        return Rs.ok(list);
    }

    @ApiOperation(value="移除员工", notes="移除员工")
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public Rs remove(@ApiParam(value = "员工ID") long id){
        emps.remove(id);
        return Rs.ok(id);
    }

    @ApiOperation(value="添加一个员工", notes="添加一个员工")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Rs add(@ApiParam(value = "员工ID")long id, @ApiParam(value = "员工姓名")String name){
        Emp e = new Emp(id, name);
        emps.put(id, e);
        return Rs.ok(e);
    }

    @ApiOperation(value="更新员工信息", notes="更新员工信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Rs update(@ApiParam(value = "员工ID")long id, @ApiParam(value = "员工姓名")String name){
        Emp e = emps.get(id);
        e.setName(name);
        return Rs.ok(e);
    }

}
