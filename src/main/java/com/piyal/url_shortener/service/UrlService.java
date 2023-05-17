package com.piyal.url_shortener.service;

import com.piyal.url_shortener.dto.UrlModelDto;
import com.piyal.url_shortener.model.UrlModel;
import com.piyal.url_shortener.repository.UrlRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class UrlService {
    UrlRepository urlRepository;
    UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    public RedirectView redirectToActualSite(String shortUrl){
        UrlModel urlModel = urlRepository.findByShortUrl(shortUrl);
        if(urlModel == null){
            return new RedirectView();
        }
        return new RedirectView(urlModel.getRegularUrl());
    }

    public ResponseEntity<UrlModel> addUrl(UrlModelDto urlModelDto){
        UrlModel urlModel = new UrlModel(urlModelDto);
        urlRepository.save(urlModel);
        return ResponseEntity.ok(urlModel);
    }
}
