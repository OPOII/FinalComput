package com.example.demo.delegate;

import java.net.http.HttpClient;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public abstract class GenericTemplate {
	RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/";
	 
    private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() 
    {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                          = new HttpComponentsClientHttpRequestFactory();
         
        clientHttpRequestFactory.setHttpClient(httpClient());
              
        return clientHttpRequestFactory;
    }
     
    private HttpClient httpClient() 
    {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        credentialsProvider.setCredentials(AuthScope.ANY, 
                        new UsernamePasswordCredentials("admin-test","123"));
 
        HttpClient client = HttpClientBuilder
                                .create()
                                .setDefaultCredentialsProvider(credentialsProvider)
                                .build();
        return client;
    }
	
	public GenericDelegate() 
    {
        restTemplate = new RestTemplate(getClientHttpRequestFactory());
    }
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
}