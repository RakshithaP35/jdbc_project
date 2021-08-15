package com.xworkz.jdbc.webseries.tester;

import java.util.Collection;

import com.xworkz.jdbc.webseries.dao.WebSeriesDAO;
import com.xworkz.jdbc.webseries.dao.WebSeriesDAOimpl;
import com.xworkz.jdbc.webseries.dto.WebSeriesDTO;

public class WebSeriesFindAllByPredicate {

	public static void main(String[] args) {
		WebSeriesDAO dao = new WebSeriesDAOimpl();
		Collection<WebSeriesDTO> collection = dao.findall();
		collection.forEach(dto -> System.out.println(dto));
		System.out.println(collection);

	}

}
