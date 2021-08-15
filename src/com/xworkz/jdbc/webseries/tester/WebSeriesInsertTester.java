package com.xworkz.jdbc.webseries.tester;

import com.xworkz.jdbc.webseries.constant.Genre;
import com.xworkz.jdbc.webseries.constant.StreamedIn;
import com.xworkz.jdbc.webseries.dao.WebSeriesDAO;
import com.xworkz.jdbc.webseries.dao.WebSeriesDAOimpl;
import com.xworkz.jdbc.webseries.dto.WebSeriesDTO;

public class WebSeriesInsertTester {

	public static void main(String[] args) {
		WebSeriesDTO dto = new WebSeriesDTO("Ginny&Geourga", 10, StreamedIn.Netflix, Genre.action, 18);
		WebSeriesDTO dto1 = new WebSeriesDTO("Trinkets", 22, StreamedIn.Rave, Genre.comedy, 16);
		WebSeriesDTO dto2 = new WebSeriesDTO("Controlz", 11, StreamedIn.Hotstar, Genre.documentary, 18);
		WebSeriesDTO dto3 = new WebSeriesDTO("Gossip Girls", 20, StreamedIn.voot, Genre.loveStories, 16);

		WebSeriesDAO dao = new WebSeriesDAOimpl();
		dao.save(dto1);
		dao.save(dto2);
		dao.save(dto3);
		dao.save(dto);

	}

}
