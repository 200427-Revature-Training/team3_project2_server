package com.team3.payload;


public class ApiResponse {

	private Boolean success;
	private String message;
	
	
	public ApiResponse(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}


	public Boolean getSuccess() {
		return success;
	}


	public String getMessage() {
		return message;
	}


	public void setSuccess(Boolean success) {
		this.success = success;
	}


	public void setMessage(String message) {
		this.message = message;
	}
		
}
