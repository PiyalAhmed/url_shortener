package com.piyal.url_shortener.repository;

import com.piyal.url_shortener.model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlModel, Long> {
    UrlModel findByShortUrl(String shortUrl);
}
