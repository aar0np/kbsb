package com.apollo11.kbsb;

public class DocumentByKeywordResponse {
	private int count;
	private DocumentByKeyword[] data;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public DocumentByKeyword[] getData() {
		return data;
	}
	public void setData(DocumentByKeyword[] data) {
		this.data = data;
	}
}
