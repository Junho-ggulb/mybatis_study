package hello.itemservice;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import hello.itemservice.config.JdbcTemplateV3Config;
import hello.itemservice.config.MybatisConfig;
import hello.itemservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Import(MemoryConfig.class)
//@Import(JdbcTemplateV1Config.class)
//@Import(JdbcTemplateV2Config.class)
//@Import(JdbcTemplateV3Config.class)
@Import(MybatisConfig.class)
@SpringBootApplication(scanBasePackages="hello.itemservice.web")
public class ItemserviceStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemserviceStartApplication.class, args);
	}
	
	@Bean
	@Profile("local")
	public TestDataInit testDatainit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}
	
	/*
	 * @Bean
	 * 
	 * @Profile("test") public DataSource dataSource() { log.info("메모리 데이터베이스 초기화");
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * dataSource.setDriverClassName("org.h2.Driver");
	 * dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
	 * dataSource.setUsername("sa"); dataSource.setPassword(""); return dataSource;
	 * }
	 */

}
