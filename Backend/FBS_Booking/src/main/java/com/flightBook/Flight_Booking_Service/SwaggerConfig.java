package com.flightBook.Flight_Booking_Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
//	@Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.flightBook.Flight_Booking_Service"))
//             .build();
//   }
//	
//	private ApiKey apiKey() {
//		return new ApiKey("JWT", "Authorization", "header");
//		}
//
//		private SecurityContext securityContext() {
//		return SecurityContext.builder().securityReferences(defaultAuth()).build();
//		}
//
//		private List<SecurityReference> defaultAuth() {
//		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//		authorizationScopes[0] = authorizationScope;
//		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//		}
//
////    private ApiInfo metaData() {
////        return new ApiInfoBuilder()
////                .title("Train Service - Spring Boot Swagger Configuration")
////                .description("\"Swagger configuration for application \"")
////                .version("1.1.0")
////                .license("Apache 2.0")
////                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
////                .build();
////    }
//    //for Swagger api doc generation
//   //http://localhost:8082/v2/api-docs
//    //http://localhost:8082/swagger-ui.html


}
