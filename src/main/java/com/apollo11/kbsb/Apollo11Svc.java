package com.apollo11.kbsb;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class Apollo11Svc {
	private final RestTemplate restTemplate;
	private final HttpHeaders headers;
	private final HttpEntity<String> httpEntity;
	private String baseAstraUrl;
	
	@Autowired
	public Apollo11Svc(RestTemplateBuilder builder) {
        // build header
		headers = new HttpHeaders();
	    headers.set("x-cassandra-token", System.getenv("ASTRA_DB_APPLICATION_TOKEN"));
	    httpEntity = new HttpEntity<String>(headers);

	    // build Astra URL
	    StringBuilder urlBuilder = new StringBuilder("https://");
	    urlBuilder.append(System.getenv("ASTRA_DB_ID"));
	    urlBuilder.append("-");
	    urlBuilder.append(System.getenv("ASTRA_DB_REGION"));
	    urlBuilder.append(".apps.astra.datastax.com/api/rest/v2/keyspaces/");
	    urlBuilder.append(System.getenv("ASTRA_DB_KEYSPACE"));
	    baseAstraUrl = urlBuilder.toString();
	    
	    // initalize RestTemplate
		restTemplate = builder
				.rootUri(baseAstraUrl)
				.build();
	}
	
	public DocumentByKeyword[] getDocumentByKeyword(String keyword) {
		String astraUrl = "/documents_by_keyword/" + keyword;
		
		DocumentByKeywordResponse resp = restTemplate.exchange(
				astraUrl,
				HttpMethod.GET,
	    	    httpEntity,
	    	    DocumentByKeywordResponse.class
	    ).getBody();
		
		return resp.getData();
	}
}
