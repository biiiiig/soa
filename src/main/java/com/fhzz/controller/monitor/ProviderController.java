package com.fhzz.controller.monitor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fhzz.dubbo.common.domain.Provider;
import com.fhzz.dubbo.service.ProviderService;


@RestController
@RequestMapping("/dubbo")
public class ProviderController {
	@Autowired
	ProviderService provider;
	
	@RequestMapping("/get")
	public List<Provider> getProviders(){
		return provider.findByService("com.fhzz.api.SampleServer");
	}
}
