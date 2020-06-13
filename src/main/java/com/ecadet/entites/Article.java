/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecadet.entites;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edward Cadet
 */

@XmlRootElement
public class Article {
    private int articleId;
    private String titre;
    private String auteur;
    private String date_parution;
    private String texte;

    public Article(int articleId, String titre, String auteur, String date_parution, String texte) {
        this.articleId = articleId;
        this.titre = titre;
        this.auteur = auteur;
        this.date_parution = date_parution;
        this.texte = texte;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDate_parution() {
        return date_parution;
    }

    public void setDate_parution(String date_parution) {
        this.date_parution = date_parution;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    @Override
    public String toString() {
        return "Article{" + "articleId=" + articleId + ", titre=" + titre + ", auteur=" + auteur + ", date_parution=" + date_parution + ", texte=" + texte + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.articleId;
        hash = 59 * hash + Objects.hashCode(this.titre);
        hash = 59 * hash + Objects.hashCode(this.date_parution);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.date_parution, other.date_parution)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
