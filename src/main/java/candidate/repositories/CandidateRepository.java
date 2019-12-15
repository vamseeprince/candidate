package candidate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import candidate.models.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
