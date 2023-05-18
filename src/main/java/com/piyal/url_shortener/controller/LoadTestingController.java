package com.piyal.url_shortener.controller;

import com.google.gson.Gson;
import com.piyal.url_shortener.dto.UrlModelDto;
import com.piyal.url_shortener.model.UrlModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;


@Controller
public class LoadTestingController {
	@GetMapping("test")
	@ResponseBody
	ResponseEntity<UrlModel> create() throws URISyntaxException, IOException, InterruptedException {
		UrlModelDto urlModelDto = new UrlModelDto("https://www.youtube.com");
		Gson gson = new Gson();
		String jsonRequest = gson.toJson(urlModelDto);
		HttpRequest postRequest = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/generate"))
				.header("Content-Type", "application/json")
				.POST(BodyPublishers.ofString(jsonRequest))
				.build();
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
		UrlModel urlModel = gson.fromJson(postResponse.body(), UrlModel.class);
		System.out.println(postResponse.body());
		return ResponseEntity.ok(urlModel);
	}
}
