package com.apollo11.kbsb;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentByKeyword {
	private String keyword;
    private String title;
    @JsonProperty("document_id")
    private UUID documentId;
    private String url;

    public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public UUID getDocumentId() {
		return documentId;
	}
	public void setDocumentId(UUID documentId) {
		this.documentId = documentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
