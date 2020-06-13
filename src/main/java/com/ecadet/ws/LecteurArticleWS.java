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

    
    // methode: AllArticles()
    @WebMethod(operationName = "GetAllArticles")
    public List<Article> getAllArticles() {
        return ArticleDAO.AllArticles();
    }
    
    // methode: getArticle
    @WebMethod(operationName = "GetArticle")
    public Article getArticle(@WebParam( name = "ArticleId" ) int ArticleId) {
        return ArticleDAO.Article(ArticleId);
    }
    
    // methode: addLike
    @WebMethod(operationName = "PutLike")
    public void putLike(@WebParam( name = "ArticleId" ) int ArticleId) {
        ArticleDAO.addLike(ArticleId);
    }
    
    // methode: getLikesDb
    @WebMethod(operationName = "GetLikes")
    public int getLikes(@WebParam( name = "ArticleId" ) int ArticleId) {
        return ArticleDAO.getLikesDb(ArticleId);
    }
    
    // methode: addDislike
    @WebMethod(operationName = "PutDislike")
    public void putDislike(@WebParam( name = "ArticleId" ) int ArticleId) {
        ArticleDAO.addDislike(ArticleId);
    }
    
    // methode: getDislikesDb
    @WebMethod(operationName = "GetDislikes")
    public int getDislikes(@WebParam( name = "ArticleId" ) int ArticleId) {
        return ArticleDAO.getDislikesDb(ArticleId);
    }
}
