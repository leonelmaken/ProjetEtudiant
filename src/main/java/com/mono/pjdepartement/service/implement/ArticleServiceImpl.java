package com.mono.pjdepartement.service.implement;

import com.mono.pjdepartement.entity.app.Article;
import com.mono.pjdepartement.entity.repository.ArticleRepository;
import com.mono.pjdepartement.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	/*
	 * 1 - Si un champ obligatoire est vide, on renvoie un message de champ obligatoire vide.
	 * 2 - Sinon on crée l'article et on affiche le message de réussite
	 * 3 - On capture une quelconque exception et on l'affiche
	 */
	@Override
	public ResponseEntity<String> createArticle(Article article) {
		try {
            if (article.getTheme() == null) { // 1
                return new ResponseEntity<>(
                        "Vous devez entrer un thème",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (article.getDescription() == null) { // 1
                return new ResponseEntity<>(
                        "Vous devez entrer une description",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (article.getLink() == null) { // 1
                return new ResponseEntity<>(
                        "Vous devez entrer un lien",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }

            else if (article.getNameAuteur() == null) { // 1
                return new ResponseEntity<>(
                        "Vous devez entrer un nom",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }

			Article atcl = articleRepository.save(article); // 2
            return new ResponseEntity<>(
                    "Vous avez enregistré un nouveau article avec succès " + atcl,
                    HttpStatus.OK);
        }catch(Exception e) { // 3
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
        }

	}

	/*
	 * 1 - Si un champ obligatoire est mis à jour, on conserve la mise à jour.
	 * 2 - On sauvegarde toutes les modifications. Et on retourne un message de réussite.
	 */
	@Override
	public ResponseEntity<String> updateArticle(Article article, Long id) {
		Optional<Article> use = articleRepository.findById(id);
        if(use.isEmpty()) {
            return new ResponseEntity<>(
                    "article not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        }
        if (article.getTheme() != null || !use.get().getTheme().equals(article.getTheme())) { // 1
            use.get().setTheme(article.getTheme());
        }
        if (article.getDescription() != null || !use.get().getDescription().equals(article.getDescription())) { // 1
            use.get().setDescription(article.getDescription());
        }

        articleRepository.saveAndFlush(use.get()); // 2
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
	}

	@Override
	public List<Article> getAll() {
		return articleRepository.findAll(Sort.by("nom").ascending());
	}

	@Override
	public Article getArticle(Long id) {
		if(articleRepository.findById(id).isPresent())
			return articleRepository.findById(id).get();
		else return null;
	}

	@Override
	public String deleteArticle(Long id) {
		articleRepository.deleteById(id);
		return "l'article a été supprimé";
	}

	@Override
	public List<Article> findByTheme(String theme) {
		return articleRepository.findByTheme(theme);
	}

	@Override
	public List<Article> findByNameAuteur(String nameAuteur) {
		return articleRepository.findByNameAuteur(nameAuteur);
	}

	@Override
	public List<Article> findByDescription(String description) {
		return articleRepository.findByDescription(description);
	}

}
