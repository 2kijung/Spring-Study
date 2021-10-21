package com.kh.spring.common.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class ValidateResult {
	
	Map<String,Object> error;
	
	public ValidateResult() {
		error = new HashMap<String,Object>();
	}

	public void addError(Errors errors) {//getdeafaultmessage 는 추후 확장을 통해 사용할수도있는것 쓰레기값을 넣어도 괜찮다. ex)"123r124fad"
		for (FieldError fielderror : errors.getFieldErrors()) {
			error.put(fielderror.getField(), fielderror.getDefaultMessage());
		}
	}
	public Map<String, Object> getError() {
		return error;
	}

}
