package chapter08;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = {"chapter08"}, annotationClass = Mapper.class)
@ComponentScan(basePackages = {"chapter08"})
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
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
		dataSource.setJdbcUrl("jdbc:log4jdbc:mariadb://localhost:3306/study");
		dataSource.setUsername("testuser");
		dataSource.setPassword("test1234");
		return dataSource;
	}
	// mybatis
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource()); // 데이터소스객체 주입(setter방식)
		
		// 매퍼파일(xml)있는 위치 설정
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		ssf.setMapperLocations(resolver.getResources("classpath:/mapper/**/*.xml"));
		
		return ssf.getObject();
	}
	// DAO에 주입받을 객체
//	@Bean
//	public SqlSessionTemplate sst() throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory()); // SqlSessionFactory객체 주입(생성자 방식)
//	}
}










