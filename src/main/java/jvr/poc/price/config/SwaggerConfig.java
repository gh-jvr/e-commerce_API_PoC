package jvr.poc.price.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuration class for Swagger.
 */
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    /**
     * Main method for Swagger configuration.
     * @return Swagger's docker configuration.
     */
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("jvr.poc.price.controllers"))
          .paths(PathSelectors.any())                          
          .build().useDefaultResponseMessages(false);
    }

    /**
     * Redirections method for the Swagger UI.
     * @param registry Internal Spring registry for redirections.
     */
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/swagger-ui/");
        registry.addRedirectViewController("/swagger-ui", "/swagger-ui/");
        registry.addRedirectViewController("/api", "/swagger-ui/");
    }

}
