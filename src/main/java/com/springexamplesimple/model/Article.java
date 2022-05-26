package com.springexamplesimple.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, fullText;
    private int allViews;

    public Article() {
    }

    public Article(String title, String fullText) {
        this.title = title;
        this.fullText = fullText;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public int getAllViews() {
        return allViews;
    }

    public void setAllViews(int allViews) {
        this.allViews = allViews;
    }
}
