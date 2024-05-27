package com.trade.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket createRestApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.trade.demo"))
//                .paths(PathSelectors.any()).build();
//    }
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("演示项目API")
//                .description("外贸管理系统 made by T13  冯金科 胡洋 王嘉乐")
//                .version("1.0")
//                .build();
//    }
//}


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.trade.demo"))
                .paths(PathSelectors.any())
                .build();
             //   .globalOperationParameters(customParameters()); // 注册自定义参数
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("演示项目API")
                .description("外贸管理系统 made by T13  冯金科 胡洋 王嘉乐")
                .version("1.0")
                .build();
    }

//    private List<Parameter> customParameters() {
//        // 创建一个自定义参数，将 char 类型映射到原始的 char 数据类型
//        Parameter charParam = new ParameterBuilder()
//                .name("status") // 参数名
//                .description("审核状态") // 参数描述
//                .modelRef(new ModelRef("char")) // 明确指定数据类型为 char
//                .parameterType("char") // 参数类型
//                .required(false) // 是否必填
//                .build();
//
//        return Collections.singletonList(charParam);
//    }
}
