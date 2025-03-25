package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String artist_id;
    private String name;
    @OneToMany
    @JoinColumn(name="ARTIST_FK")
    private List<Art> piecesOfArt = new ArrayList<>();

    public Artist() {}

    public Artist(String artist_id, String name) {
        this.artist_id = artist_id;
        this.name = name;
        this.piecesOfArt = piecesOfArt;
    }

    public void addArtWorkToList(Art art) {
        this.piecesOfArt.add(art);
    }

    public int getId() {
        return id;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public String getName() {
        return name;
    }

    public List<Art> getPiecesOfArt() {
        List<Art> collection = Collections.unmodifiableList(this.piecesOfArt);
        return collection;
    }

    @Override
    public String toString() {
        return "Artist: " + name + '\n' +
                "Works of Art: " + piecesOfArt + '\n';
    }
}
