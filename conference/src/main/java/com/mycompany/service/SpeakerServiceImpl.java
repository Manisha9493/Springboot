package com.mycompany.service;

import java.util.List;

import com.mycompany.model.Speaker;
import com.mycompany.repository.HibernateSpeakerRepositoryImpl;
import com.mycompany.repository.SpeakerRepository;

public class SpeakerServiceImpl implements SpeakerService {
	private SpeakerRepository speakerRepository=new HibernateSpeakerRepositoryImpl();
	@Override
	public List<Speaker> findAll() {
		
		
		return speakerRepository.findAll();
		
	}
}
