package com.example.PFS.model;

import jakarta.persistence.*;

@Entity
public class Avis {

    private int note;

    private String commentaire;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_avis")

    private Long id;
    @ManyToOne
            (cascade =  CascadeType.ALL)
    @JoinColumn(name = "id_client")

    private Client client;
    @ManyToOne(cascade ={  CascadeType.REMOVE})
    @JoinColumn(name = "boutique_id")

    private Boutique boutique;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Boutique getBoutique() {
        return boutique;
    }

    public void setBoutique(Boutique boutique) {
        this.boutique = boutique;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}