/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecadet.ws;

import com.ecadet.daos.ArticleDAO;
import com.ecadet.entites.Article;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Edward Cadet
 */
@WebService(serviceName = "LecteurArticleWS")
public class LecteurArticleWS {

    
    // methode: getAllArticles()
    @WebMethod(operationName = "GetAllArticles")
    public List<Article> getAllArticles() {
        return ArticleDAO.getAllArticles();
    }
    
    // methode: getArticle
    @WebMethod(operationName = "GetArticle")
    public Article getArticle(@WebParam( name = "ArticleId" ) int ArticleId) {
        return null;
    }
    
    // methode: putLike
    @WebMethod(operationName = "PutLike")
    public void putLike(@WebParam( name = "ArticleId" ) int ArticleId) {
        ArticleDAO.putLike(ArticleId);
    }
    
    // methode: getLikes
    @WebMethod(operationName = "GetLikes")
    public int getLikes(@WebParam( name = "ArticleId" ) int ArticleId) {
        return ArticleDAO.getLikes(ArticleId);
    }
    
    // methode: putDislike
    @WebMethod(operationName = "PutDislike")
    public void putDislike(@WebParam( name = "ArticleId" ) int ArticleId) {
        ArticleDAO.putDislike(ArticleId);
    }
    
    // methode: getDislikes
    @WebMethod(operationName = "GetDislikes")
    public int getDislikes(@WebParam( name = "ArticleId" ) int ArticleId) {
        return ArticleDAO.getDislikes(ArticleId);
    }
}
