package com.mono.pjdepartement.service.implement;

import com.mono.pjdepartement.entity.app.Offre;
import com.mono.pjdepartement.entity.repository.OffreRepository;
import com.mono.pjdepartement.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreServiceImpl implements OffreService {

    @Autowired
    OffreRepository offreRepository;

    @Override
    public List<Offre> getAll() {
        return offreRepository.findAll();
    }

    @Override
    public Offre getOffre(Long id) {
        if (offreRepository.findById(id).isPresent())
            return offreRepository.findById(id).get();
        else return null;
    }

    @Override
    public String delete(Long id) {
        offreRepository.deleteById(id);
        return "l'offre a été supprimée";
    }

    @Override
    public List<Offre> getByPeriode(String periode) {
        return offreRepository.findByPeriode(periode);
    }

    @Override
    public List<Offre> getByCompetences(String competences) {
        return offreRepository.findByCompetences(competences);
    }

    @Override
    public List<Offre> getByDescription(String description) {
        return offreRepository.findByDescription(description);
    }

    @Override
    public List<Offre> getByPoste(String poste) {
        return offreRepository.findByPoste(poste);
    }
}