package com.mycompany.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.conference.model.Course;
import com.mycompany.conference.model.Registration;
import com.mycompany.conference.model.RegistrationReport;
import com.mycompany.conference.repository.CourseRepository;
import com.mycompany.conference.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	private  RegistrationRepository registrationRepo;
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	@Transactional
	public Registration addRegistration(Registration registration)
	
	{  Registration tempRegistration;
	   System.out.println("Transaction id in service"+  registration.getId());
	   
	   if(registration.getId()==null)
	   {
		   tempRegistration=registrationRepo.save(registration);
		
		Course course=new Course();
		course.setName("intro");
		course.setDescription("Every attendee must complete the course");
		course.setRegistration(tempRegistration);
		courseRepository.Save(course);
		 return registration;
	   }else
	   {
		   tempRegistration=registrationRepo.save(registration);
	   }
	return tempRegistration;
		
	}

	@Override
	public List<Registration> findAll() {
		// TODO Auto-generated method stub
		return registrationRepo.findAll();
	}

	@Override
	public List<RegistrationReport> findAllReports() {
		// TODO Auto-generated method stub
		
		//return registrationRepo.findAllReports();
		return registrationRepo.registrationReports();
		 
	}

	
}
