package com.mycompany.repository;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.model.Speaker;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
	public List<Speaker> findAll() {
		List<Speaker> speakers = new ArrayList<>();
		Speaker speaker = new Speaker();
		speaker.setFirstName("Manisha");
		speaker.setLastName("Nisha");
		speakers.add(speaker);
		return speakers;

	}

}
