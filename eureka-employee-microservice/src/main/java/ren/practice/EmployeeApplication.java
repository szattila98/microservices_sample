package ren.practice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * A client which registers into the eureka discovery service.
 * Swagger2 is enabled so it will generate REST-API docs.
 * Add 'instance2' to active profiles to start another instance, there is an yml for it in the config-repo.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class EmployeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ren.practice"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Employee API").description("Documentation Employee API v1.0").build());
    }
}

/**
 * This controller gives back a name and a role from the respective property yml.
 */
//TODO @RefreshScope with bus-api or actuator or else
@RestController
class EmployeeController {

    @Value("${emp.empName:defaultName}")
    private String empName;
    @Value("${emp.empRole:defaultRole}")
    private String empRole;

    @GetMapping("/employee")
    public String getEmployee() {
        return "Name: " + empName + " || Role: " + empRole;
    }

}
