package com.example.klaudia.marketcalculator.Controller;

import com.example.klaudia.marketcalculator.Model.Market;
import com.example.klaudia.marketcalculator.Model.Market;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Acer on 7.7.2015.
 */
public class MarketController {

//    public static Market getMarketById(int id, List<Market> list){
//
//        Iterator i = list.iterator();
//
//        while(i.hasNext()){
//            Market node = (Market)i.next();
//            if(id == node.getId()){
//                return node;
//            }
//        }
//        return new Market();
//    }

    public static List<Market> getAllMarkets(){
        ImportData data = new ImportData();
        List<Market> list = data.downloadMarkets("http://genti.bildhosting.me/bildAndroid/ReadAllMarkets.php","market");
        return list;
    }
}
