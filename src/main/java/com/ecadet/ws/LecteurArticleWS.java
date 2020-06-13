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

    
    // methode: GetAllArticles()
    @WebMethod(operationName = "GetAllArticles")
    public List<Article> GetAllArticles() {
        return ArticleDAO.GetAllArticles();
    }
    
    // methode: GetArticle
    @WebMethod(operationName = "GetArticle")
    public Article GetArticle(@WebParam( name = "ArticleId" ) int ArticleId) {
        return null;
    }
    
    // methode: PutLike
    @WebMethod(operationName = "PutLike")
    public void PutLike(@WebParam( name = "ArticleId" ) int ArticleId) {
        
    }
    
    // methode: GetLikes
    @WebMethod(operationName = "GetLikes")
    public int GetLikes(@WebParam( name = "ArticleId" ) int ArticleId) {
        return 0;
    }
    
    // methode: PutDislike
    @WebMethod(operationName = "PutDislike")
    public void PutDislike(@WebParam( name = "ArticleId" ) int ArticleId) {
        
    }
    
    // methode: GetDislikes
    @WebMethod(operationName = "GetDislikes")
    public int GetDislikes(@WebParam( name = "ArticleId" ) int ArticleId) {
        return 0;
    }
}
