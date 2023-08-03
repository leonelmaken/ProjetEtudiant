package com.mono.pjdepartement.service.implement;

import java.util.List;
import java.util.Optional;

import com.mono.pjdepartement.entity.app.Stage;
import com.mono.pjdepartement.entity.repository.StageRepository;
import com.mono.pjdepartement.service.EntrepriseService;
import com.mono.pjdepartement.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StageServiceImpl implements StageService {

	@Autowired
    StageRepository stageRepository;
    @Autowired
    EntrepriseService entrepriseService;

    @Override
    public ResponseEntity<String> create(Stage stage, Long idE)  {
        try {
            if (stage.getPoste() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer un poste pour la création du stage",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (stage.getDescription() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer une description",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (stage.getCompetences() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer vos compétences",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (stage.getPeriode() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer une période pour le stage",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (idE != null) {
                stage.setEmployeur(entrepriseService.getEnterprise(idE));
            }
            stageRepository.save(stage);
            return new ResponseEntity<>(
                    "Vous avez enregistré un nouveau stage avec succès " + stageRepository.save(stage),
                    HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> update(Stage stage, Long id)  {
        Optional<Stage> use = stageRepository.findById(id);
        if(use.isEmpty()) {
            return new ResponseEntity<>(
                    "Stage not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        }
        if (stage.getPoste() != null || !use.get().getPoste().equals(stage.getPoste())) {
            use.get().setPoste(stage.getPoste());
        }
        if (stage.getDescription() != null || !use.get().getDescription().equals(stage.getDescription())) {
            use.get().setDescription(stage.getDescription());
        }
        if (stage.getEtat() != null || !use.get().getEtat().equals(stage.getEtat())) {
            use.get().setEtat(stage.getEtat());
        }
        if (stage.getCompetences() != null || !use.get().getCompetences().equals(stage.getCompetences())) {
            use.get().setCompetences(stage.getCompetences());
        }
        if (stage.getPeriode() != null || !use.get().getPeriode().equals(stage.getPeriode())) {
            use.get().setPeriode(stage.getPeriode());
        }
        stageRepository.saveAndFlush(use.get());
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
    }


    @Override
	public List<Stage> getAll() {
		return stageRepository.findAll();
	}

	@Override
	public Stage getStage(Long id) {
		if(stageRepository.findById(id).isPresent())
			return stageRepository.findById(id).get();
		else return null;
	}

    @Override
    public String delete(Long id) {
        stageRepository.deleteById(id);
        return "le stage a été supprimé";
    }

    @Override
    public List<Stage> getByPeriode(String periode) {
        return stageRepository.findByPeriode(periode);
    }

    @Override
    public List<Stage> getByCompetences(String competences) {
        return stageRepository.findByCompetences(competences);
    }

    @Override
    public List<Stage> getByDescription(String description) {
        return stageRepository.findByDescription(description);
    }

    @Override
    public List<Stage> getByPoste(String poste) {
        return stageRepository.findByPoste(poste);
    }
}
