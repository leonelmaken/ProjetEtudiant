package com.mono.pjdepartement.entity.app;

import jakarta.persistence.*;

@Entity(name = "Publication")
@Table(name = "Publication")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPub;

    @Column(length = 100)
    private String title;

    @Column
    private String description;

    @Column
    private String image;

    @Column
    private String type;
    
    public Publication() {
        super();
    }

    public Publication(Long idPub, String title, String description, String image) {
        this.idPub = idPub;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public void setIdPub(Long idPub) {
        this.idPub = idPub;
    }

    public Long getIdPub() {
        return idPub;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
        
    public String getType() {
    return type;
    }
        
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "idPub=" + idPub +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
