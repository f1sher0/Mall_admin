//
//package com.med2.demo.common;
//
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//
//public class CodeG  {
//    public static void main(String[] args) {
//        // 数据源配置
//        DataSourceConfig dataSourceConfig = new DataSourceConfig();
//        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/store_manager");
//        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
//        dataSourceConfig.setUsername("root");
//        dataSourceConfig.setPassword("198455");
//
//        // 全局配置
//        GlobalConfig globalConfig = new GlobalConfig();
//        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
//        globalConfig.setAuthor("mave2");
//        globalConfig.setOpen(false);
//
//        // 包配置
//        PackageConfig packageConfig = new PackageConfig();
//        packageConfig.setParent("com.example");
//        packageConfig.setModuleName("generateconfig");
//
//        // 策略配置
//        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig.setInclude("customers", "emps", "manages","medicines","out_ins","sales","storages","stores","suppliers"); // 需要生成代码的表名
//        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setEntityLombokModel(true);
//        strategyConfig.setRestControllerStyle(true);
//
//        // 代码生成器
//        AutoGenerator autoGenerator = new AutoGenerator();
//        autoGenerator.setDataSource(dataSourceConfig);
//        autoGenerator.setGlobalConfig(globalConfig);
//        autoGenerator.setPackageInfo(packageConfig);
//        autoGenerator.setStrategy(strategyConfig);
//        autoGenerator.execute();
//    }
//}
