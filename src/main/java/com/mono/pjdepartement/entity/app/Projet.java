package com.mono.pjdepartement.entity.app;

import jakarta.persistence.*;

@Entity(name = "Projet")
@Table(name = "Projet")
public class Projet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProjet;

	@Column(length = 50)
	private String theme;

	@Column(length = 200)
	private String description;

	@Column(length = 200)
	private String status;

	public Projet() {
		 super();
	 }

	public Projet(String theme, String description, String status) {
		super();
		this.theme = theme;
		this.description = description;
		this.status = status;
	}

	public long getIdProjet() {
		return idProjet;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Projet{" +
				"idProjet=" + idProjet +
				", theme='" + theme + '\'' +
				", description='" + description + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
