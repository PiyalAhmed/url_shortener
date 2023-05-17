package com.piyal.url_shortener.controller;

import com.piyal.url_shortener.dto.UrlModelDto;
import com.piyal.url_shortener.model.UrlModel;
import com.piyal.url_shortener.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class GenericController {
    UrlService urlService;
    GenericController(UrlService urlService){
        this.urlService = urlService;
    }

    @GetMapping("/{shortUrl}")
    RedirectView redirectToActualSite(@PathVariable String shortUrl){
        return urlService.redirectToActualSite(shortUrl);
    }


    @PostMapping("/generate")
    @ResponseBody
    ResponseEntity<UrlModel> shortenUrl(@RequestBody UrlModelDto urlModelDto){
        return urlService.addUrl(urlModelDto);
    }
}
