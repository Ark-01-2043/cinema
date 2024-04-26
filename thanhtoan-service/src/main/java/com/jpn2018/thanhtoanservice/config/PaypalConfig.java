package com.jpn2018.thanhtoanservice.config;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Configuration
public class PaypalConfig {

	
	private String clientId = "ASW9K_ZwSNSS4YeoqrdJ0srrdRQ5ST6TM43R42PCpxSEoZy_ensBNJJ6a8OtoIoWo3ASgMx05bWfJsqg";
	
	private String clientSecret = "EH8vTvNvSXgk5BecSzeMxc9dtgvNXWc-9EAOwQ8baINOkeZzAdTEPae6bp-_EvtXj-_NkZ0KnPPtXVHr";
	
	private String mode = "sandbox";

	@Bean
	public Map<String, String> paypalSdkConfig() {
		Map<String, String> configMap = new HashMap<>();
		configMap.put("mode", mode);
		return configMap;
	}

	@Bean
	public OAuthTokenCredential oAuthTokenCredential() {
		return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
	}

	@Bean
	public APIContext apiContext() throws PayPalRESTException {
		APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
		context.setConfigurationMap(paypalSdkConfig());
		return context;
	}

}
