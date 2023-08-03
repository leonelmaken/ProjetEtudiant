package com.mono.pjdepartement.service.implement;

import java.util.List;
import java.util.Optional;

import com.mono.pjdepartement.entity.app.Emploi;
import com.mono.pjdepartement.entity.repository.EmploiRepository;
import com.mono.pjdepartement.service.EmploiService;
import com.mono.pjdepartement.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmploiServiceImpl implements EmploiService {
	
	@Autowired
    EmploiRepository emploiRepository;
	@Autowired
	EntrepriseService entrepriseService;

	@Override
	public ResponseEntity<String> create(Emploi emploie, Long idE) {
		try {
            if (emploie.getPoste() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer un poste",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (emploie.getDescription() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer une Description",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (emploie.getSecteur() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer un Secteur",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (emploie.getPeriode() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer un Periode",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
			else if (idE != null) {
				emploie.setEmployeur(entrepriseService.getEnterprise(idE));
			}
            emploiRepository.save(emploie);
            return new ResponseEntity<>(
                    "L'offre d'emploie a été enregistré avec succès" + emploiRepository.save(emploie),
                    HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(
					"An exception has occured: "+e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

	@Override
	public ResponseEntity<String> update(Emploi emploie, Long id) {
		Optional<Emploi> use = emploiRepository.findById(id);
        if(use.isEmpty()) {
            return new ResponseEntity<>(
                    "Student not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        }
        if (emploie.getPoste() != null || !use.get().getPoste().equals(emploie.getPoste())) {
            use.get().setPoste(emploie.getPoste());
        }
        if (emploie.getDescription() != null || !use.get().getDescription().equals(emploie.getDescription())) {
            use.get().setSecteur(emploie.getDescription());
        }
        
        emploiRepository.save(use.get());
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
	}

	@Override
	public List<Emploi> getAll() {
		return emploiRepository.findAll(Sort.by("poste").ascending());
	}

	@Override
	public Emploi getEmploi(Long id) {
		if (emploiRepository.findById(id).isPresent())
            return emploiRepository.findById(id).get();
        else return null;
	}

	@Override
	public String delete(Long id) {
		emploiRepository.deleteById(id);
        return "l'emploi a été supprimé";
	}

	@Override
	public List<Emploi> getByPeriode(String periode) {
		return emploiRepository.findByPeriode(periode);
	}

	@Override
	public List<Emploi> getByCompetences(String competences) {
		return emploiRepository.findByCompetences(competences);
	}

	@Override
	public List<Emploi> getByDescription(String description) {
		return emploiRepository.findByDescription(description);
	}

	@Override
	public List<Emploi> getByPoste(String poste) {
		return emploiRepository.findByPoste(poste);
	}

	@Override
	public List<Emploi> getBySecteur(String secteur) {
		return emploiRepository.findBySecteur(secteur);
	}

}
