package com.hackfse.fdbck.mgmt.systm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket fdBckMgmtSystm() {
		final ParameterBuilder prmtBldr = new ParameterBuilder();
		prmtBldr.name("Authorization").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        final List<Parameter> prmtrs = new ArrayList<>();
        prmtrs.add(prmtBldr.build());
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(this.apiInfo()).globalOperationParameters(prmtrs).select()
				.apis(RequestHandlerSelectors.basePackage("com.hackfse.fdbck.mgmt.systm.controller")).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Hack FSE Rest API").description("Provides dao services").license("")
				.licenseUrl("http://cognizant.com").termsOfServiceUrl("").version("1.0.0")
				.contact(new Contact("", "", "")).build();
	}
}