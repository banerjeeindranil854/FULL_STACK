package com.hackfse.fdbck.mgmt.systm.security;

public class ApiResponse {
    private Boolean success;
    private String message;
    private String role;

    public ApiResponse(Boolean success, String message,String role) {
        this.success = success;
        this.message = message;
        this.role = role;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}