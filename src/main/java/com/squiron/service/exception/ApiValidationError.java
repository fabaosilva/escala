package com.squiron.service.exception;

//@Data
//@EqualsAndHashCode(callSuper = false)
//@AllArgsConstructor
class ApiValidationError {
	private String object;
	private String field;
	private Object rejectedValue;
	private String message;

	ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}

}
