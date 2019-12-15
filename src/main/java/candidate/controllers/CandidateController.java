package candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import candidate.models.CandidatesEmployers;
import candidate.models.EmployerList;
import candidate.repositories.CandidateRepository;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CandidateRepository candidateRepo;
	
	@RequestMapping("/candidates")
	public CandidatesEmployers getCandidates(){
		CandidatesEmployers ce = new CandidatesEmployers();
		ce.setCandidates(candidateRepo.findAll());
		EmployerList el = null;
		try {
			//Can implement Eureka for service discovery.
			//Create multiple instances to be more resilient.
			el = restTemplate.getForObject("http://localhost:8080/employer/employers", EmployerList.class);
			ce.setEmployers(el.getEmployers());
		}
		catch(RestClientException e) {
			//log
		}
		
		return ce;
	}
}
