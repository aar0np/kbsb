package com.apollo11.kbsb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.web.client.RestTemplateBuilder;

@RestController
public class Apollo11Controller {
	private final Apollo11Svc apollo11Svc;
	
	public Apollo11Controller() {
		this.apollo11Svc = new Apollo11Svc(new RestTemplateBuilder());
	}
	
	@GetMapping("/document/{keyword}")
	public DocumentByKeyword[] documentByKeyword(@PathVariable(value="keyword") String keyword) {
		return apollo11Svc.getDocumentByKeyword(keyword);
	}
}
