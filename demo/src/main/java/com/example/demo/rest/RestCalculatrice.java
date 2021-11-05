package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculatrice.CalculatriceService;

import io.swagger.annotations.Api;


@Controller
@RequestMapping("/calculatrice")
@Api(value = "Calculatrice API")
public class RestCalculatrice {
	
	@Autowired
	CalculatriceService cal;
	

	@PostMapping(value = "/additionner", produces = { "application/json"})
	public ResponseEntity<String> add(
			@RequestParam(value = "a", required = true) int a,
			@RequestParam(value = "b", required = true) int b) {

		return new ResponseEntity<>(""+cal.additionner(a, b), HttpStatus.OK);
	}

	@PostMapping(value = "/soustraire", produces = { "application/json"})
	public ResponseEntity<String> sub(
			@RequestParam(value = "a", required = true) int a,
			@RequestParam(value = "b", required = true) int b) {


		return new ResponseEntity<>(""+cal.soustraire(a, b), HttpStatus.OK);
	}
	@PostMapping(value = "/multiplier", produces = { "application/json"})
	public ResponseEntity<String> mul(
			@RequestParam(value = "a", required = true) int a,
			@RequestParam(value = "b", required = true) int b) {

		return new ResponseEntity<>(""+cal.multiplier(a, b), HttpStatus.OK);
	}
}
