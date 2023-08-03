package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.app.Offre;
import com.mono.pjdepartement.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Offre")
public class OffreController {

	final
    OffreService offreService;

    @Autowired
    public OffreController(OffreService offreService) {
        this.offreService = offreService;
    }

    @DeleteMapping(path = "/delete/{id}")
	public String deleteOffre(@PathVariable Long id){
		return offreService.delete(id);
	}

	@GetMapping(path = "/read")
	public List<Offre> readAllOffre(){
		return offreService.getAll();
	}

	@GetMapping(path = "/read/id/{id}")
	public Offre readOffre(@PathVariable Long id){
		return offreService.getOffre(id);
	}

	@GetMapping("/read/period/{period}")
	public List<Offre> getEtudiantByNom(@PathVariable String period) {
		return offreService.getByPeriode(period);
	}

	@GetMapping("/read/poste/{poste}")
	public List<Offre> getOffreByPoste(@PathVariable String poste) {
		return offreService.getByPoste(poste);
	}

	@GetMapping("/read/comp/{comp}")
	public List<Offre> getOffreByCompetences(@PathVariable String comp) {
		return offreService.getByCompetences(comp);
	}

}
