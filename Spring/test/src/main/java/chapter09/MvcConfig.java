package chapter09;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariDataSource;

// 아래 어노테이션은 그대로 사용
@Configuration
@MapperScan(basePackages = { "chapter09" }, annotationClass = Mapper.class)
@ComponentScan(basePackages = { "chapter09" })
@EnableWebMvc
@EnableTransactionManagement
public class MvcConfig implements WebMvcConfigurer {
	// JSP 경로 (ViewResolver)
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// hikaricp
	@Bean
	@Primary
	public HikariDataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
//		dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/study");
		dataSource.setJdbcUrl("jdbc:log4jdbc:mariadb://localhost:3306/study?serverTimezone=UTC&characterEncoding=utf8");
		dataSource.setUsername("testuser");
		dataSource.setPassword("test1234");
		return dataSource;
	}

	// mybatis
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource()); // 데이터소스객체 주입(setter방식)

		// 매퍼파일(xml)있는 위치 설정
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		ssf.setMapperLocations(resolver.getResources("classpath:/mapper/**/*.xml"));

		return ssf.getObject();
	}

	// 파일 업로드를 위한 객체, 이름은 무조건 multipartResolver
	@Bean 
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(5 * 1024 * 1024);
		resolver.setDefaultEncoding("utf-8");

		return resolver;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager dtm = new DataSourceTransactionManager(dataSource());
		
		return dtm;
	}
}
