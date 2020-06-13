/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecadet.daos;

import com.ecadet.entites.Article;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Edward Cadet
 */
public class ArticleDAO {
    // string pour la connexion TODO: Objet Database
    private static String ip = "192.168.1.171";
    private static String user = "root";
    private static String password = "1234";
    private static String db = "article_a15";
    
    private static String url = String.format("jdbc:mysql://%s:3306/%s", ip, db);
    
    public static List<Article> AllArticles() {
        // liste qui sera retourner contenant tous les articles
        List<Article> resAllArticles = new ArrayList<Article>();
        
        // commande qui sera executer par le statement
        String rq = "SELECT * FROM article";
        
        try{
        // instanciation de la conection
        System.out.println("Connection a MySQL...");
        Connection con = DriverManager.getConnection(url, user, password);
        
        // instanciation du statement
        Statement stmt = con.createStatement();
        
        // instanciation du ResultSets qui va contenir les resultats de la requetes 
        ResultSet rs = stmt.executeQuery(rq);
        
        /* boucle while qui va visiter le ResultSets pour pour remplir la liste 
        *  resAllArticles
        */
        while(rs.next()) {
            // prendre les infos du prochain article
            int articleId = rs.getInt("article_id");
            String titre = rs.getString("titre");
            int journalisteId = rs.getInt("auteur");
            String date_parution = rs.getString("date_parution");
            String texte = rs.getString("texte");
            
            // recherche le nom de l'auteur a partir du ID. 
            // Peut etre creer une methode getAuteur(JournalisteId);
            String auteur = "MockAuteur";
            
            // instancie l'article
            Article nextArt = new Article(articleId, titre, auteur, date_parution, texte);
            
            //rajoute le a la liste
            resAllArticles.add(nextArt);
        }
        
        
        //fermeture de la connection
        System.out.println("fermeture de la connection...");
        con.close();
            
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        } 
        return resAllArticles;
    }
    
    public static Article Article(int ArticleId) {
        return new Article();
    }
    
    // methode: addLike
    public static void addLike(int ArticleId) {
        
        // commande qui sera executer par le statement
        String rq = "UPDATE article"
                    + "SET likes = likes + 1"
                    + "WHERE user_id='?'";
        
        try{
        // instanciation de la conection
        System.out.println("Connection a MySQL...");
        Connection con = DriverManager.getConnection(url, user, password);
        
        // instanciation du statement
        PreparedStatement stmt = con.prepareStatement(rq);
        stmt.setInt(1, ArticleId);
        
        /* execution du update. Verifie le nombre de rangées affectées
        *  pour vérifier s'il y a eu une erreur
        */
        int rowAffected = stmt.executeUpdate();
        if(rowAffected == 1){
            System.out.println("Update reussi");
        } else if(rowAffected > 1) {
            System.out.println("erreur: plusieurs rows affecté");
        } else{
            System.out.println("erreur: aucun row affecté");
        }   
        

        //fermeture de la connection
        System.out.println("fermeture de la connection...");
        con.close();
            
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            
        }
    }
    
    // methode: getLikesDb
    public static int getLikesDb(int ArticleId) {
        // liste qui sera retourner contenant tous les articles
        int resLikes = 0;
        
        // commande qui sera executer par le statement
        String rq = "SELECT likes FROM article WHERE article_id=?";
        
        try{
        // instanciation de la conection
        System.out.println("Connection a MySQL...");
        Connection con = DriverManager.getConnection(url, user, password);
        
        // instanciation du statement
        PreparedStatement stmt = con.prepareStatement(rq);
        stmt.setInt(1, ArticleId);
        
        // instanciation du ResultSets qui va contenir les resultats de la requetes 
        ResultSet rs = stmt.executeQuery();
        
        // boucle while qui va visiter le ResultSets pour recuperer le resultat de la requete
        while(rs.next()) { 
            resLikes = rs.getInt("likes");
   
        }
        
        //fermeture de la connection
        System.out.println("fermeture de la connection...");
        con.close();
            
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        } 
        return resLikes;
    }
    
    // methode: addLike
    public static void addDislike(int ArticleId) {
        
        // commande qui sera executer par le statement
        String rq = "UPDATE article"
                    + "SET dislikes = dislikes + 1"
                    + "WHERE user_id='?'";
        
        try{
        // instanciation de la conection
        System.out.println("Connection a MySQL...");
        Connection con = DriverManager.getConnection(url, user, password);
        
        // instanciation du statement
        PreparedStatement stmt = con.prepareStatement(rq);
        stmt.setInt(1, ArticleId);
        
        /* execution du update. Verifie le nombre de rangées affectées
        *  pour vérifier s'il y a eu une erreur
        */
        int rowAffected = stmt.executeUpdate();
        if(rowAffected == 1){
            System.out.println("Update reussi");
        } else if(rowAffected > 1) {
            System.out.println("erreur: plusieurs rows affecté");
        } else{
            System.out.println("erreur: aucun row affecté");
        }   
        

        //fermeture de la connection
        System.out.println("fermeture de la connection...");
        con.close();
            
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            
        }
    }
    
    // methode: getLikesDb
    public static int getDislikesDb(int ArticleId) {
        // liste qui sera retourner contenant tous les articles
        int resLikes = 0;
        
        // commande qui sera executer par le statement
        String rq = "SELECT dislikes FROM article WHERE article_id=?";
        
        try{
        // instanciation de la conection
        System.out.println("Connection a MySQL...");
        Connection con = DriverManager.getConnection(url, user, password);
        
        // instanciation du statement
        PreparedStatement stmt = con.prepareStatement(rq);
        stmt.setInt(1, ArticleId);
        
        // instanciation du ResultSets qui va contenir les resultats de la requetes 
        ResultSet rs = stmt.executeQuery();
        
        // boucle while qui va visiter le ResultSets pour recuperer le resultat de la requete
        while(rs.next()) { 
            resLikes = rs.getInt("dislikes");
   
        }
        
        //fermeture de la connection
        System.out.println("fermeture de la connection...");
        con.close();
            
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        } 
        return resLikes;
    }
}
