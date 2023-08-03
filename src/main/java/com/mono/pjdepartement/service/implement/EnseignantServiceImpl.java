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
import com.mono.pjdepartement.entity.metier.Enseignant;
import com.mono.pjdepartement.entity.repository.EnseignantRepository;
import com.mono.pjdepartement.service.EnseignantService;

@Service
public class EnseignantServiceImpl implements EnseignantService {

    @Autowired
    EnseignantRepository enseignantRepository;

    /*
     * 1 - Si un champ obligatoire est vide, on renvoie un message de champ obligatoire vide.
     * 2 - Sinon on crée  l'enseignant et on affiche le message de réussite
     * 3 - On capture une quelconque exception et on l'affiche
     */
    @Override
    public ResponseEntity<String> create(Enseignant enseignant) {
        try {
            if (enseignant.getNom() == null) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer votre nom",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (enseignant.getRoles() == null) // 1
                enseignant.setRoles("Enseignant");

            if (enseignant.getPrenom() == null) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer votre prénom",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (enseignant.getMatricule() == null) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer votre matricule",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (enseignant.getSpecialite() == null) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer votre spécialité",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (enseignant.getGrade() == null) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer votre Grade",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (enseignant.getMail() == null) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer votre mail",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (enseignant.getPassword() == null) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer votre mot de passe",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            
            if (enseignant.getNumTel() == 0L) // 1
                return new ResponseEntity<>(
                        "Vous devez entrer votre numero de telephone",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            
            Enseignant etmp = enseignantRepository.save(enseignant); // 2
            return new ResponseEntity<>(
                    "Enregistrement reussi" + etmp,
                    HttpStatus.OK);

        } catch (Exception e) { // 3
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * 1 - Si un champ obligatoire est mis à jour, on conserve la mise à jour.
     * 2 - On sauvegarde toutes les modifications. Et on renvoie un message de réussite.
     */
    @Override
    public ResponseEntity<String> update(Enseignant enseignant, Long idE) {
        Optional<Enseignant> uses = enseignantRepository.findById(idE);
        if (uses.isEmpty())
            return new ResponseEntity<>(
                    "Enterprise not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

        if (enseignant.getNom() != null || !uses.get().getNom().equals(enseignant.getNom())) // 1
            uses.get().setNom(enseignant.getNom());
        
        if (enseignant.getPrenom() != null || !uses.get().getPrenom().equals(enseignant.getPrenom())) // 1
            uses.get().setPrenom(enseignant.getPrenom());

        if (enseignant.getMatricule() != null || !uses.get().getMatricule().equals(enseignant.getMatricule())) // 1
            uses.get().setMatricule(enseignant.getMatricule());

        if (enseignant.getSpecialite() != null || !uses.get().getSpecialite().equals(enseignant.getSpecialite())) // 1
            uses.get().setSpecialite(enseignant.getSpecialite());

        if (enseignant.getGrade() != null || !uses.get().getGrade().equals(enseignant.getGrade())) // 1
            uses.get().setGrade(enseignant.getGrade());

        if (enseignant.getMail() != null || !uses.get().getMail().equals(enseignant.getMail())) // 1
            uses.get().setMail(enseignant.getMail());

        if (enseignant.getPassword() != null || !uses.get().getPassword().equals(enseignant.getPassword())) // 1
            uses.get().setPassword(enseignant.getPassword());

        if (enseignant.getPhoto() != null || !Arrays.equals(uses.get().getPhoto(), enseignant.getPhoto())) // 1
            uses.get().setPhoto(enseignant.getPhoto());

        if (enseignant.getNumTel() != 0L || !(uses.get().getNumTel().equals(enseignant.getNumTel()))) // 1
            uses.get().setNumTel(enseignant.getNumTel());

        enseignantRepository.save(enseignant); // 2
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
    }

    @Override
    public Enseignant getEnseignant(Long id) {
        if (enseignantRepository.findById(id).isPresent())
            return enseignantRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<Enseignant> getAll() {
        return enseignantRepository.findAll(Sort.by("nom").ascending());
    }

    @Override
    public String delete(Long id) {
        enseignantRepository.deleteById(id);
        return "l'enseignant a été supprimé";
    }

    @Override
    public List<Enseignant> getByNom(String nom) {
        return enseignantRepository.findByNom(nom);
    }

    @Override
    public List<Enseignant> getByPrenom(String prenom) {
        return enseignantRepository.findByPrenom(prenom);
    }

    @Override
    public Enseignant getByMatricule(String matricule) {
        return enseignantRepository.findByMatricule(matricule);
    }

    @Override
    public List<Enseignant> getBySpeciality(String specialite) {
        return enseignantRepository.findBySpecialite(specialite);
    }

    @Override
    public List<Enseignant> getByCompetences(String competences) {
        return enseignantRepository.findByCompetences(competences);
    }

    /*
     * 1 - Si l'entreprise n'a pas été trouvé, on retourne un message d'erreur.
     * 2 - On reccupère la liste des articles
     * 3 - On ajoute l'article en question
     * 4 - On set la liste d'articles de l'enseignant.
     * 5 - On save les modif et on retourne un message de réussite.
     */
    @Override
    public ResponseEntity<String> addArticle(Article article, Long id) {
        Optional<Enseignant> uses = enseignantRepository.findById(id);
        if (uses.isEmpty()) // 1
            return new ResponseEntity<>(
                    "Enseignant not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        List<Article> ens = uses.get().getArticles(); // 2
        ens.add(article); // 3
        uses.get().setArticles(ens); // 4

        enseignantRepository.save(uses.get()); // 5
        return new ResponseEntity<>(
                "Ajout reussi: " + article,
                HttpStatus.OK);
    }

    /*
     * On réccup la liste d'article d'un enseignant.
     */
    @Override
    public List<Article> getAllArticles(Long id) {
        Optional<Enseignant> uses = enseignantRepository.findById(id);
        List<Article> articleList = null;
        if (uses.isPresent())
            articleList = uses.get().getArticles();
        return articleList;
    }

    @Override
    public ResponseEntity<String> addProjet(Projet projet, Long id) {
        Optional<Enseignant> uses = enseignantRepository.findById(id);
        if (uses.isEmpty())
            return new ResponseEntity<>(
                    "Enseignant not found",
                    HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500
        List<Projet> ens = uses.get().getProjects();
        ens.add(projet);
        uses.get().setProjects(ens);

        enseignantRepository.save(uses.get());
        return new ResponseEntity<>(
                "Ajout reussi: " + projet,
                HttpStatus.OK);
    }

    @Override
    public List<Projet> getAllProjects(Long id) {
        Optional<Enseignant> uses = enseignantRepository.findById(id);
        List<Projet> projetList = null;
        if (uses.isPresent())
            projetList = uses.get().getProjects();
        return projetList;
    }

    @Override
    public ResponseEntity<String> addCompetence(Long id, String comp) {
        Optional<Enseignant> uses = enseignantRepository.findById(id);
        if (uses.isEmpty())
            return new ResponseEntity<>(
                    "Etudiant not found",
                    HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500
        String competences = uses.get().getCompetences();
        competences += "; "+comp;
        uses.get().setCompetences(competences);

        enseignantRepository.save(uses.get());
        return new ResponseEntity<>(
                "Ajout reussi: " + competences,
                HttpStatus.OK);
    }
}