package au.gov.dav.interview.dao;

import org.springframework.data.repository.CrudRepository;

import au.gov.dav.interview.model.Person;

public interface PersonDao extends CrudRepository<Person, Integer> {
	
}
