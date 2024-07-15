package com.bruno.helpdesk.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public StandardError() {
		super();
	}
	
	public StandardError(Builder builder) {
		this.timestamp = builder.timestamp;
		this.status = builder.status;
		this.error = builder.error;
		this.message = builder.message;
		this.path = builder.path;
	}
	
	public static class Builder{
		private Long timestamp;
		private Integer status;
		private String error;
		private String message;
		private String path;
		
		public Builder setTimestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}
		public Builder setStatus(Integer status) {
			this.status = status;
			return this;
		}
		public Builder setError(String error) {
			this.error = error;
			return this;
		}
		public Builder setMessage(String message) {
			this.message = message;
			return this;
		}
		public Builder setPath(String path) {
			this.path = path;
			return this;
		}
		public StandardError build() {
			return new StandardError(this);
		}
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
