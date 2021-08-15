package com.xworkz.jdbc.webseries.tester;

import com.xworkz.jdbc.webseries.dao.WebSeriesDAO;
import com.xworkz.jdbc.webseries.dao.WebSeriesDAOimpl;

public class WebSeriesMaxEpisodes {

	public static void main(String[] args) {
		WebSeriesDAO dao = new WebSeriesDAOimpl();
		System.out.println(dao.findMaxEpisodes());

	}

}
