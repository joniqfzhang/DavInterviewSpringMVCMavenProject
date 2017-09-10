package au.gov.dav.interview.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.gov.dav.interview.dao.ClaimDao;
import au.gov.dav.interview.model.Claim;

@Service
public class ClaimService {
	@Autowired
	private ClaimDao claimDao;
	
	public Set<Claim> getAllClaim() {
		Set<Claim> claimRecords = new  HashSet<Claim>();  
		claimDao.findAll().forEach(claimRecords::add);
		return claimRecords;
	}	
	
	public Optional<Claim> getClaim(int id) {
		return Optional.of(claimDao.findOne(id));
	}
	
	public void addClaim(Claim claimRecord) {
		claimDao.save(claimRecord);
	}
	
	public void delete(int id) {
		claimDao.delete(id);
	}

}
