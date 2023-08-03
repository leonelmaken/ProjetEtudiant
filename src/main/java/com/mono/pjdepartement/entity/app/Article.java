package com.mono.pjdepartement.entity.app;

import jakarta.persistence.*;


@Entity(name = "Article")
@Table(name = "Article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idArticle;

	@Column(length = 100)
	private String theme;

	@Column
	private String description;

	@Column
	private String link;

	@Column(length = 100)
	private String nameAuteur;

	public Article() {
		super();
	}

	public Article(String theme, String description, String link, String nameAuteur) {
		this.theme = theme.toUpperCase();
		this.description = description.toUpperCase();
		this.link = link;
		this.nameAuteur = nameAuteur.toUpperCase();
	}

	public long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNameAuteur() {
		return nameAuteur;
	}

	public void setNameAuteur(String nameAuteur) {
		this.nameAuteur = nameAuteur;
	}

	@Override
	public String toString() {
		return "Article{" +
				"idArticle=" + idArticle +
				", theme='" + theme + '\'' +
				", description='" + description + '\'' +
				", link='" + link + '\'' +
				", nameAuteur='" + nameAuteur + '\'' +
				'}';
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
