package com.example.klaudia.marketcalculator.Controller;

import com.example.klaudia.marketcalculator.Model.Article;
import com.example.klaudia.marketcalculator.Model.Market;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by klaudia on 08.07.15.
 */
public class ArticleController {


//    public static Article getArticle(String id, List<Article> list){
//
//        Iterator i = list.iterator();
//
//        while(i.hasNext()){
//            Article node = (Article)i.next();
//            if(id == node.getId()){
//                return node;
//            }
//        }
//        return new Article();
//    }
//
//    public static List<Article> search(String title, List<Article> list){
//
//        Iterator i = list.iterator();
//
//        List returnList = new ArrayList<>();
//        while(i.hasNext()){
//            Article node = (Article)i.next();
//            if(node.getTitle().contains(title)){
//                returnList.add(node);
//            }
//        }
//        return returnList;
//    }
//
//    public static List<Article> getAllArticles(int market_id, List<Article> list){
//
//        Iterator i = list.iterator();
//        List returnList = new ArrayList<>();
//
//        while(i.hasNext()){
//            Article node = (Article)i.next();
//            if(market_id == node.getMarket_id()){
//                returnList.add(node);
//            }
//        }
//        return returnList;
//    }

    public static List<Article> getAllArticlesFromMarket(int market_id){
        ImportData data = new ImportData();
        List<Article> list = data.downloadArticles("http://genti.bildhosting.me/bildAndroid/ReadAllArticlesFromMarket.php/?marketId="+market_id,"article");
        return list;
    }

    public static List<Article> getArticle(String id){
        ImportData data = new ImportData();
        List<Article> list = data.downloadArticles("http://genti.bildhosting.me/bildAndroid/getArticleByMarket.php?articleId="+id,"article");
        return list;
    }
}
