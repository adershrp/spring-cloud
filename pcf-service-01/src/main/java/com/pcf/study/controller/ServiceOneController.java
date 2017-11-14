/**
 * 
 */
package com.pcf.study.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcf.study.vo.Greeting;

/**
 * @author Adersh.P
 *
 */
@RestController
@RequestMapping("/api/{userId}")
public class ServiceOneController {

	private AtomicInteger count = new AtomicInteger(1);

	@GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	// @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> sayHello(@PathVariable String userId) {
		Greeting greeting = new Greeting(count.getAndIncrement(), "Hello " + userId + " !!!");
		return new ResponseEntity<Greeting>(greeting, HttpStatus.FOUND);
	}

	@GetMapping(path = "/morning", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	// @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> sayGoodMorning(@PathVariable String userId) {
		Greeting greeting = new Greeting(count.getAndIncrement(), "Good Morning " + userId + " !!!");
		return new ResponseEntity<Greeting>(greeting, HttpStatus.FOUND);
	}

}
