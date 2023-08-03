package com.mono.pjdepartement.service.implement;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mono.pjdepartement.entity.app.Article;
import com.mono.pjdepartement.entity.app.Projet;
import com.mono.pjdepartement.entity.metier.Etudiant;
import com.mono.pjdepartement.entity.repository.EtudiantRepository;
import com.mono.pjdepartement.service.EtudiantService;

@Service

public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public ResponseEntity<String> create(Etudiant etudiant) {
        try {
            if (etudiant.getNom() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer Votre nom",
                        HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500 si le nom est vide

            if (etudiant.getNumTel() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer Votre numero de téléphone",
                        HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500 si le num tel est vide

            if (etudiant.getRoles() == null)
                etudiant.setRoles("Etudiant");

            if (etudiant.getMail() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer Votre mail",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500 si le mail est vide

            if (etudiant.getPassword() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer Votre Password",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500 ainsi de suite

            if (etudiant.getMatricule() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre matricule",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (etudiant.getPrenom() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer Votre Prénom",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (etudiant.getNiveau() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre niveau",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            etudiantRepository.save(etudiant);
            return new ResponseEntity<>(
                    "Vous avez été enregistré avec succès " + etudiantRepository.save(etudiant),
                    HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<String> update(Etudiant etudiant, Long id) {
        Optional<Etudiant> use = etudiantRepository.findById(id);
        if(use.isEmpty()) return new ResponseEntity<>(
                "Student not found",
                HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

        if (etudiant.getNom() != null || !use.get().getNom().equals(etudiant.getNom()))
            use.get().setNom(etudiant.getNom());

        if (etudiant.getNumTel() != null || !use.get().getNumTel().equals(etudiant.getNumTel()))
            use.get().setNumTel(etudiant.getNumTel());

        if (etudiant.getMail() != null || !use.get().getMail().equals(etudiant.getMail()))
            use.get().setMail(etudiant.getMail());

        if (etudiant.getPassword() != null || !use.get().getPassword().equals(etudiant.getPassword()))
            use.get().setPassword(etudiant.getPassword());

        if (etudiant.getPhoto() != null || !Arrays.equals(use.get().getPhoto(), etudiant.getPhoto()))
            use.get().setPhoto(etudiant.getPhoto());

        if (etudiant.getMatricule() != null || !use.get().getMatricule().equals(etudiant.getMatricule()))
            use.get().setMatricule(etudiant.getMatricule());

        if (etudiant.getPrenom() != null || !use.get().getPrenom().equals(etudiant.getPrenom()))
            use.get().setPrenom(etudiant.getPrenom());

        if (etudiant.getNiveau() != null || !use.get().getNiveau().equals(etudiant.getNiveau()))
            use.get().setNiveau(etudiant.getMatricule());

        if (etudiant.getCompetence() != null || !use.get().getCompetence().equals(etudiant.getCompetence()))
            use.get().setCompetence(etudiant.getMatricule());

        etudiantRepository.save(etudiant);
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
    }

    @Override
    public List<Etudiant> getAll() {
        return etudiantRepository.findAll(Sort.by("nom").ascending());
    }

    @Override
    public Etudiant getEtudiant(Long id) {
        if (etudiantRepository.findById(id).isPresent())
            return etudiantRepository.findById(id).get();
        else return null;
    }

    @Override
    public String delete(Long id) {
        etudiantRepository.deleteById(id);
        return "l'etudiant a été supprimé";
    }

	@Override
	public List<Etudiant> findByNom(String nom) {
		return etudiantRepository.findByNom(nom);
	}

    @Override
    public List<Etudiant> findByPrenom(String prenom) {
        return etudiantRepository.findByPrenom(prenom);
    }

    @Override
	public Etudiant findByMatricule(String matricule) {
		return etudiantRepository.findByMatricule(matricule);
	}

    @Override
	public List<Etudiant> findByCompetence(String competence) {
		return etudiantRepository.findByCompetence(competence);
	}

    @Override
	public List<Etudiant> findByNiveau(String niveau) {
		return etudiantRepository.findByNiveau(niveau);
	}

    @Override
    public ResponseEntity<String> addArticle(Article article, Long id) {
        Optional<Etudiant> uses = etudiantRepository.findById(id);
        if (uses.isEmpty())
            return new ResponseEntity<>(
                    "Etudiant not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        List<Article> ens = uses.get().getArticles();
        ens.add(article);
        uses.get().setArticles(ens);

        etudiantRepository.save(uses.get());
        return new ResponseEntity<>(
                "Ajout reussi: " + article,
                HttpStatus.OK);
    }

    @Override
    public List<Article> getAllArticles(Long id) {
        Optional<Etudiant> uses = etudiantRepository.findById(id);
        List<Article> articleList = null;
        if (uses.isPresent())
            articleList = uses.get().getArticles();
        return articleList;
    }

    @Override
    public ResponseEntity<String> addProjet(Projet projet, Long id) {
        Optional<Etudiant> uses = etudiantRepository.findById(id);
        if (uses.isEmpty())
            return new ResponseEntity<>(
                    "Etudiant not found",
                    HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500
        List<Projet> ens = uses.get().getProjects();
        ens.add(projet);
        uses.get().setProjects(ens);

        etudiantRepository.save(uses.get());
        return new ResponseEntity<>(
                "Ajout reussi: " + projet,
                HttpStatus.OK);
    }

    @Override
    public List<Projet> getAllProjects(Long id) {
        Optional<Etudiant> uses = etudiantRepository.findById(id);
        List<Projet> projetList = null;
        if (uses.isPresent())
            projetList = uses.get().getProjects();
        return projetList;
    }

    @Override
    public ResponseEntity<String> addCompetence(Long id, String comp) {
        Optional<Etudiant> uses = etudiantRepository.findById(id);
        if (uses.isEmpty())
            return new ResponseEntity<>(
                    "Etudiant not found",
                    HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500
        String competences = uses.get().getCompetence();
        competences += "; "+comp;
        uses.get().setCompetence(competences);

        etudiantRepository.save(uses.get());
        return new ResponseEntity<>(
                "Ajout reussi: " + competences,
                HttpStatus.OK);
    }

}
