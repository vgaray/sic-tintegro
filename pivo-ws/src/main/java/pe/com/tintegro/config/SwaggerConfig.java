package pe.com.tintegro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig
{
	@Bean
	public Docket api() throws Exception
	{
		return new Docket( DocumentationType.SWAGGER_2).select()
						       .apis(RequestHandlerSelectors.basePackage( "pe.com.tintegro.controller" ) )
						       .paths(PathSelectors.any())
						       .build()
						       .apiInfo(getApiInfo() );
	}

	private ApiInfo getApiInfo()
	{
		return new ApiInfo( "Pivo", 
							     "Plataforma Integral de Veterinaria", 
							     "1.0.0", 
							     null, 
							     new Contact( "Área de Desarrollo - Pivo", 
							   		         "www.pivo.com", 
							   		         "desarrollo@pivo.com" ), 
							     					null, null );
	}
}
