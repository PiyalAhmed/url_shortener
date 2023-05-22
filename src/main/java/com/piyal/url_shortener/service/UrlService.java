package com.piyal.url_shortener.service;

import com.piyal.url_shortener.dto.UrlModelDto;
import com.piyal.url_shortener.helper.Base62Helper;
import com.piyal.url_shortener.model.UrlModel;
import com.piyal.url_shortener.repository.UrlRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
	UrlRepository urlRepository;
	
	UrlService(UrlRepository urlRepository) {
		this.urlRepository = urlRepository;
	}
	
	@Cacheable(value = "shortUrlCache", key = "#shortUrl")
	public String getRegularUrl(String shortUrl) {
		Long id = Base62Helper.decodeFromBase62(shortUrl);
		UrlModel urlModel = urlRepository.findById(id).orElse(null);
		System.out.println("Fetched from database.");
		if (urlModel == null) {
			return "";
		}
		return urlModel.getRegularUrl();
	}
	
	public ResponseEntity<UrlModel> addUrl(UrlModelDto urlModelDto) {
		UrlModel urlModel = new UrlModel(urlModelDto);
		urlModel.setShortUrl(Base62Helper.encodeToBase62(urlModel.getId()));
		urlRepository.save(urlModel);
		return ResponseEntity.ok(urlModel);
	}
	
	
}
