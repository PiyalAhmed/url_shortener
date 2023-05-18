package com.piyal.url_shortener.model;

import com.piyal.url_shortener.dto.UrlModelDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UrlModel {
	static AtomicLong atomicLong = new AtomicLong(0);
	@Id
	Long id;
	String shortUrl;
	String regularUrl;
	
	public UrlModel(UrlModelDto urlModelDto) {
		this.id = generateId();
		this.regularUrl = urlModelDto.getRegularUrl();
	}
	
	public static Long generateId() {
		return atomicLong.incrementAndGet();
	}
}
