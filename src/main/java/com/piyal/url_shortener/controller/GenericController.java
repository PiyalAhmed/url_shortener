package com.piyal.url_shortener.controller;

import com.piyal.url_shortener.dto.UrlModelDto;
import com.piyal.url_shortener.model.UrlModel;
import com.piyal.url_shortener.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class GenericController {
	private static final Logger logger =LoggerFactory.getLogger(GenericController.class);
	UrlService urlService;
	
	GenericController(UrlService urlService) {
		this.urlService = urlService;
	}
	
	@GetMapping("/{shortUrl}")
	RedirectView redirectToActualSite(@PathVariable String shortUrl) {
		logger.info("Retrieving regular url...");
		return urlService.redirectToActualSite(shortUrl);
	}
	
	
	@PostMapping("/generate")
	@ResponseBody
	ResponseEntity<UrlModel> urlModelResponseEntity(@RequestBody UrlModelDto urlModelDto) {
		logger.info("Generating short url...");
		return urlService.addUrl(urlModelDto);
	}
}
