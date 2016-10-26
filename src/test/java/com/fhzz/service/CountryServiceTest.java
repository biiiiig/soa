package com.fhzz.service;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fhzz.Application;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)// 指定spring-boot的启动类

public class CountryServiceTest {

	
	@Autowired CountryService countryService;
	
	@Test
	public void test() {
		System.out.println("============="+countryService.getAll(1, 20, null, null));
	}

}
