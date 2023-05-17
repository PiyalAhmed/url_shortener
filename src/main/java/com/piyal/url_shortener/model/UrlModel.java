package com.piyal.url_shortener.model;

import com.piyal.url_shortener.dto.UrlModelDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UrlModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String shortUrl;
    String regularUrl;

    public UrlModel(UrlModelDto urlModelDto) {
        this.shortUrl = urlModelDto.getShortUrl();
        this.regularUrl = urlModelDto.getRegularUrl();
    }

    public UrlModel() {
    }
}
