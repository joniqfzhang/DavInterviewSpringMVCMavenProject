package au.gov.dav.interview.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.gov.dav.interview.dao.PersonDao;
import au.gov.dav.interview.model.Claim;
import au.gov.dav.interview.model.Person;

@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;
	
	public List<Person> getAllPerson() {
		List<Person> personRecords = new  ArrayList<Person>();  
		personDao.findAll().forEach(personRecords::add);
		return personRecords;
	}
	
	public Set<Claim> getClaimsByPerson(int personId) {
		Set<Claim> claims = new HashSet<Claim>();
		Optional<Person> optPerson = getPerson(personId);
		
		if (optPerson.isPresent()) {
			claims = optPerson.get().getClaims();
		}
		
		return claims;		
	}
	
	public Optional<Person> getPerson(int id) {
		return Optional.of(personDao.findOne(id));
	}
	
	public void addPerson(Person personRecord) {
		personDao.save(personRecord);
	}
	
	public void delete(int id) {
		personDao.delete(id);
	}
}
