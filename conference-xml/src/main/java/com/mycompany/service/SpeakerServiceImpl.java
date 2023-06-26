package com.mycompany.service;

import java.util.List;

import com.mycompany.model.Speaker;
import com.mycompany.repository.SpeakerRepository;

public class SpeakerServiceImpl implements SpeakerService {
	//private SpeakerRepository speakerRepository=new HibernateSpeakerRepositoryImpl();
	private SpeakerRepository speakerRepository;
	
	
	
	
	public SpeakerServiceImpl() {
		System.out.println("O arg constructor");
		
	}


	public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
		System.out.println("parameterized constructor");
		this.speakerRepository = speakerRepository;
	}


	
	  public void setSpeakerRepository(SpeakerRepository speakerRepository)
	  {
	  this.speakerRepository = speakerRepository;  }
	 

	@Override
	public List<Speaker> findAll() {
		
		
		return speakerRepository.findAll();
		
	}
}
