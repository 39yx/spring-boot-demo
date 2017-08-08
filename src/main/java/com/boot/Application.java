package com.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//一定要扫描mapper 不然会找不到mapper
@MapperScan(basePackages = "com.boot.mapper")
public class Application {
	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		SpringApplication application = new SpringApplication(Application.class);
		//application.setAddCommandLineProperties(false);//禁止命令行配置
		//application.setDefaultProperties(defaultProperties);//设置默认参数
		application.run(args);
	}

	/**
	 * 设置session超时时间
	 * @return
	 */
	/*@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
	       return new EmbeddedServletContainerCustomizer() {
	           @Override
	           public void customize(ConfigurableEmbeddedServletContainer container) {
	                container.setSessionTimeout(1800);//单位为S
	          }
	    };
	}*/
}
