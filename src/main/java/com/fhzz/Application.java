package com.fhzz;



import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Description: 主程序入口
 * @author 于起超
 * @date 2016年10月24日 下午7:30:54
 * @vision v1.0
 */ 
@SpringBootApplication
@ServletComponentScan
public class Application {

	private static Logger logger = Logger.getLogger(Application.class);

	/**
	 * Main Start
	 */
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		logger.info("============= SpringBoot Start Success =============");
	}

}
