package cl.myhotel.prueba.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@EnableWebMvc
//@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
	              .group("public-api")
	              .pathsToMatch("/api/**")
	              .build();
//		return new Docket(DocumentationType.SWAGGER_2)  
//		          .select()                                  
//		          .apis(RequestHandlerSelectors.any())              
//		          .paths(PathSelectors.any())                          
//		          .build();  
	}
	
	  @Bean
	  public OpenAPI springOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("API Prueba MyHotel")
	              .description("Api rest para consulta de información en base a archivo dump")
	              .version("v1.0.0")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	              .externalDocs(new ExternalDocumentation()
//	              .description("SpringShop Wiki Documentation")
//	              .url("https://springshop.wiki.github.org/docs")
	              );
	  }
}
