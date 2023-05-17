package com.piyal.url_shortener.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlModelDto {
    String shortUrl;
    String regularUrl;
    public UrlModelDto(String shortUrl, String regularUrl){
        this.shortUrl = shortUrl;
        this.regularUrl = regularUrl;
    }
}
