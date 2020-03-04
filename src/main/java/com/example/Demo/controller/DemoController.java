package com.example.Demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demo.dto.InputDto;
import com.example.Demo.exception.ValidationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api("APIs for Add and Diff")
public class DemoController {

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> add(@RequestBody InputDto inputDto) {
		Integer x=0 ,y = 0;
		try { 
            // checking valid integer using parseInt() method 
			x = Integer.parseInt(inputDto.getX());
			y = Integer.parseInt(inputDto.getY()); 
             
        }  
        catch (NumberFormatException e) { 
            throw new ValidationException("Not valid numbers"); 
        } 
		
		Integer result = x + y;
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@PostMapping(value = "/diff", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Diff", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> diff(@RequestBody InputDto inputDto) {
		Integer x=0 ,y = 0;
		try { 
			x = Integer.parseInt(inputDto.getX());
			y = Integer.parseInt(inputDto.getY()); 
        }  
        catch (NumberFormatException e) { 
            throw new ValidationException("Not valid numbers"); 
        } 
		
		Integer result = x - y;
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

}
