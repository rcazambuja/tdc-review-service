package br.com.rcazambuja.review.api.v1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ReviewsSwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
              .groupName("reviews-api-v1")
              .select()
                .paths(paths())
                .build()
              .apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("reviews-api")
                .version("1.0")
                .build();
    }
    
    private Predicate<String> paths() {
        return PathSelectors.regex("/api/v1.*");
    }
}
