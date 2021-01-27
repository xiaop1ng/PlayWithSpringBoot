package com.xiaoping.cmdtest.mybatisplus;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MapperGenerator {

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        globalConfig.setAuthor("generator");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(true);// 是否覆盖已有同名文件，默认是false
        globalConfig.setBaseResultMap(true);// 开启 BaseResultMap，默认是false
        globalConfig.setBaseColumnList(true);// 开启 baseColumnList，默认是false
        generator.setGlobalConfig(globalConfig);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/db_playground?characterEncoding=UTF-8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        generator.setDataSource(dataSourceConfig);


        // set freemarker engine
//        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null); //模块名
        pc.setParent("com.xiaoping.cmdtest.mybatisplus");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        generator.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("t_xmt_activity_fund");//对那一张表生成代码
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setTablePrefix("t_xmt_"); //生成实体时去掉表前缀
        strategy.setCapitalMode(true);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(false); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setRestControllerStyle(false); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        generator.setStrategy(strategy);

        // 6、执行
        generator.execute();
    }
}
