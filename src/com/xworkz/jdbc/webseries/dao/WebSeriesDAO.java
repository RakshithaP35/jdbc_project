package com.xworkz.jdbc.webseries.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.jdbc.webseries.dto.WebSeriesDTO;

public interface WebSeriesDAO {
	
	int save(WebSeriesDTO dto);

	Collection<WebSeriesDTO> saveAll(Collection<WebSeriesDTO> collection);

	Collection<WebSeriesDTO> findall();

	Collection<WebSeriesDTO> findall(Predicate<WebSeriesDTO> predicate);

	int total();

	int findMaxEpisodes();

	int findMinEpisodes();

	Collection<WebSeriesDTO> findAllSortByNameDesc();

	Optional<WebSeriesDTO> findone(Predicate<WebSeriesDTO> predicate);

	

}
