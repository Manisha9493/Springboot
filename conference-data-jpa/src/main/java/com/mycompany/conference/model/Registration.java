package com.mycompany.conference.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "registration")
@NamedQueries({
	@NamedQuery(name=Registration.REGISTRATION_REPORT, query=Registration.REGISTRATION_REPORT_JPQL)
})
public class Registration {

	@NotEmpty
	private String name;
	public static final String REGISTRATION_REPORT="Registration.registrationReports";
	public static final String REGISTRATION_REPORT_JPQL="select new com.mycompany.conference.model.RegistrationReport" + "(r.name,c.name,c.description) " + "from Registration r,Course c " + "where r.id=c.registration.id";
;	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @JsonManagedReference
	@OneToMany(mappedBy = "registration", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Course> courses = new ArrayList<>();

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
