package spring.session.FPL.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.session.FPL.Entity.Sondage;

@Repository("SondageRepository")
public interface SondageRepository extends JpaRepository<Sondage, Integer> {

}