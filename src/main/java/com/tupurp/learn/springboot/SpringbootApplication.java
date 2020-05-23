package com.tupurp.learn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @SpringBootApplication 来标注一个主程序类，说明这是一个spring boot 应用
 *
 * 1:@SpringBootConfiguration=标注在某个类上，表示这是一个springboot的配置类
 * 		1.1：@Configuration：配置类上使用这个注解
 * 			1.1.1：	@Component：配置类也是容器种的一个组件
 *
 * 2：@EnableAutoConfiguration=开启自动配置（springboot帮我们自动默认配置）
 * 		2.1：@AutoConfigurationPackage：自动配置包
 * 			2.2.1：@Import({Registrar.class}) spring底层组件，导入AutoConfigurationPackage.Registrar类
 * 				将主配置类（@SpringBootApplication标注的类）的所在包下里面的所有组件扫描到Spring容器
 *
 *      2.2：@Import({AutoConfigurationImportSelector.class})：导入该组件，该组件将所有需要导入的组件以全类名的方式放回，导入
 *      的组件会被添加到Spring容器中，这些组件大都是自动配置类（xxxAutoConfiguration）
 *      org.springframework.core.io.support.SpringFactoriesLoader
 *      从spring-boot-autoconfigure/META-INF/spring.factories 中的值作为自动配置类导入
 * )
 * */
/**
 * springboot并不会读取xml的bean配置，如果需要使用，需要在springboot启动类加上@ImportResource注解并指定配置文件位置
 * 但不推荐使用此方法，springboot推荐使用注解的方式
 * */
//@ImportResource(locations = "classpath:demo/beans.xml")
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
