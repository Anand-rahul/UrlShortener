package com.roadmap.urlShortener.repository;

import com.roadmap.urlShortener.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, String> {
}
