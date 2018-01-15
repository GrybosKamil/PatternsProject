package com.grybos.kamil.patternsproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

//    @Value("${rest.api.base.path}")
    @Value("/api")
    private String restApiBasePath;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("Started application....");
    }


//    @Bean
//    public WebMvcRegistrationsAdapter webMvcRegistrationsHandlerMapping() {
//        Application application = this;
//        return new WebMvcRegistrationsAdapter() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return new RequestMappingHandlerMapping() {
//
//                    @Override
//                    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
//                        Class<?> beanType = method.getDeclaringClass();
//                        RestController restApiController = beanType.getAnnotation(RestController.class);
//                        if (restApiController != null) {
//                            PatternsRequestCondition apiPattern = new PatternsRequestCondition(application.restApiBasePath)
//                                    .combine(mapping.getPatternsCondition());
//
//                            mapping = new RequestMappingInfo(mapping.getName(), apiPattern,
//                                    mapping.getMethodsCondition(), mapping.getParamsCondition(),
//                                    mapping.getHeadersCondition(), mapping.getConsumesCondition(),
//                                    mapping.getProducesCondition(), mapping.getCustomCondition());
//                        }
//
//                        super.registerHandlerMethod(handler, method, mapping);
//                    }
//                };
//            }
//        };
//    }


//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Override
//    public void run(String... strings) throws Exception {
//
//        logger.info("Creating tables");
//
//        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
//        jdbcTemplate.execute("CREATE TABLE customers(" +
//                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
//
//        // Split up the array of whole names into an array of first/last names
//        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
//                .map(name -> name.split(" "))
//                .collect(Collectors.toList());
//
//        // Use a Java 8 stream to print out each tuple of the list
//        splitUpNames.forEach(name -> logger.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
//
//        // Uses JdbcTemplate's batchUpdate operation to bulk load data
//        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
//
//        logger.info("Querying for customer records where first_name = 'Josh':");
//        jdbcTemplate.query(
//                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
//                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
//        ).forEach(customer -> logger.info(customer.toString()));
//    }
}

