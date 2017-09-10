package au.gov.dav.interview.dao;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import au.gov.dav.interview.model.Claim;
import au.gov.dav.interview.model.Person;

public interface ClaimDao extends CrudRepository<Claim, Integer> {
	public Set<Claim> getClaimsByPerson(Person person);
}
