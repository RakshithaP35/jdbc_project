package com.xworkz.jdbc.webseries.tester;

import java.util.ArrayList;
import java.util.Collection;

import com.xworkz.jdbc.webseries.dao.WebSeriesDAO;
import com.xworkz.jdbc.webseries.dao.WebSeriesDAOimpl;
import com.xworkz.jdbc.webseries.dto.WebSeriesDTO;

public class WebSeriesFindAllCollectionTester {

	public static void main(String[] args) {
		Collection<WebSeriesDTO> dto = new ArrayList<WebSeriesDTO>();
		WebSeriesDAO dao = new WebSeriesDAOimpl();
		System.out.println(dao.saveAll(dto));
	}

}
