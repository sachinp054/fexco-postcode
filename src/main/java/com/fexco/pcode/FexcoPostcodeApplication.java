package com.fexco.pcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages="com.fexco.pcode")
@EnableCaching
@EnableSwagger2
public class FexcoPostcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FexcoPostcodeApplication.class, args);
	}
	
	@Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo())
            .select()
            .paths(Predicates.not(PathSelectors.regex("/")))
            .build();
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("FEXCO-postcode api")
            .description("A wrapper api around 'https://developers.alliescomputing.com/postcoder-web-api/address-lookup/premise'"
            		+ "and ''https://developers.alliescomputing.com/postcoder-web-api/address-lookup/eircode")
            .version("1.0")
            .build();
    }
}
