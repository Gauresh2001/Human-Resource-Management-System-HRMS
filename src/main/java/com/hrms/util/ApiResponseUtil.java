package com.hrms.util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hrms.dto.response.ApiResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseUtil {
	
	
	  private String message;

	    private Object data;

	    private boolean success;

}
