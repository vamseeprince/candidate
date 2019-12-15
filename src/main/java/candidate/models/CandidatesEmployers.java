package candidate.models;

import java.util.List;

public class CandidatesEmployers {
	private List<Candidate> candidates;
	
	private List<Employer> employers;

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public List<Employer> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Employer> employers) {
		this.employers = employers;
	}
}
