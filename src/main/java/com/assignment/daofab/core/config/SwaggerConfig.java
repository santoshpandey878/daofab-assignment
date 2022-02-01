package com.assignment.daofab.core.config;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Class responsible to handle swagger configuration
 *
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig implements WebMvcConfigurer {

	/**
	 * Bean to create instance for Docket
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.assignment.daofab.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	/**
	 * Method to form API Info for Swagger
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"DAOFAB Assignment REST APIs",
				"DAOFAB Assignment REST APIs",
				"API TOS",
				"Terms of service",
				new Contact("Santosh Pandey", "", "santoshpandey878@gmail.com"),
				"License of API", "API license URL", Collections.emptyList());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");

	}

	@Primary
	@Bean
	public LinkDiscoverers discoverers() {
		List<LinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
	}
}

