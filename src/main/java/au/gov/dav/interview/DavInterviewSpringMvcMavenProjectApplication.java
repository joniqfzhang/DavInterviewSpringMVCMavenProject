package au.gov.dav.interview;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import au.gov.dav.interview.model.Claim;
import au.gov.dav.interview.model.Person;
import au.gov.dav.interview.service.PersonService;

@SpringBootApplication
public class DavInterviewSpringMvcMavenProjectApplication {
	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(DavInterviewSpringMvcMavenProjectApplication.class, args);
	}
	
	@Bean
	InitializingBean intiDataBase() {		
		return() -> {
			Person ada = new Person("Ada", "ada@gamil.com", "0412111110",null);
			personService.addPerson(ada);
			
			Set<Claim> claims1 = new HashSet<Claim>();
			Person peter1 = new Person("Peter1", "peter1@gamil.com", "0412111111",claims1);
			claims1.add(new Claim("Peter1 reason1", new BigDecimal(100), peter1));
			personService.addPerson(peter1);
			
			Set<Claim> claims2 = new HashSet<Claim>();
			Person peter2 = new Person("Peter2", "peter2@gamil.com", "0412111112",claims2);
			claims2.add(new Claim("Peter2 reason1", new BigDecimal(100), peter2));	
			claims2.add(new Claim("Peter2 reason2", new BigDecimal(200), peter2));
			personService.addPerson(peter2);
			
			Set<Claim> claims3 = new HashSet<Claim>();
			Person adam = new Person("Adam", "adam@gamil.com", "0412111113",claims3);
			claims3.add(new Claim("Adam reason1", new BigDecimal(100), adam));	
			claims3.add(new Claim("Adam reason2", new BigDecimal(200), adam));
			claims3.add(new Claim("Adam reason3", new BigDecimal(300), adam));
			personService.addPerson(adam);
			
			Set<Claim> claims4= new HashSet<Claim>();
			Person mary = new Person("Mary", "mary@gamil.com", "0412111114",claims4);
			claims4.add(new Claim("Mary reason1", new BigDecimal(100), mary));	
			claims4.add(new Claim("Mary reason2", new BigDecimal(200), mary));
			claims4.add(new Claim("Mary reason3", new BigDecimal(300), mary));
			claims4.add(new Claim("Mary reason4", new BigDecimal(400), mary));
			personService.addPerson(mary);
		};
	}
}
