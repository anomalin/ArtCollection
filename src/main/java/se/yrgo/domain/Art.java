package se.yrgo.domain;

import jakarta.persistence.*;


@Entity
public class Art {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
private String title;
private String medium;

public Art() {}

    public Art(String title, String medium) {
        this.title = title;
        this.medium = medium;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMedium() {
        return medium;
    }


    @Override
    public String toString() {
        return "Artwork: " + title + '\n' +
                "Medium: " + medium + '\n';
    }
}
