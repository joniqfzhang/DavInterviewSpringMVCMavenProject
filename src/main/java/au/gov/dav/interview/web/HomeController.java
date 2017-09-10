package au.gov.dav.interview.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import au.gov.dav.interview.model.Claim;
import au.gov.dav.interview.service.ClaimService;
import au.gov.dav.interview.service.PersonService;

@Controller
public class HomeController {
	@Autowired
	private ClaimService claimService;
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/claims")
	public String listClaims(Model model) {
		model.addAttribute("claims", claimService.getAllClaim());
		return "list-claims";
	}
	
	@RequestMapping("/persons")
	public String listPersons(Model model) {
		model.addAttribute("persons", personService.getAllPerson());
		return "list-persons";
	}
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public @ResponseBody String getClaimsByPerson(@PathVariable("id") int id) {
		Set<Claim> claims = personService.getClaimsByPerson(id);
		String result = "";
		for(Claim c: claims){
			result += "<li>" + c + "</li>";
			
		}
		result = "<ul>" + result + "</ul>";
		return result;
	}
}
