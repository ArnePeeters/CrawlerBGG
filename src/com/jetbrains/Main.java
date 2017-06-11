package com.jetbrains;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.html.*;

public class Main {



    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        String line;

        String urlLink = "https://boardgamegeek.com/browse/boardgame";
        HTMLEditorKit editorKit = new HTMLEditorKit();
        HTMLDocument htmlDoc = new HTMLDocument();
//        HTMLDocument.HTMLReader reader = htmlDoc.getReader(0);
        htmlDoc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
        // URL einlesen, nur in try-catch, weil aus Original, wo ausgelesene Info ausgewertet wurde
        try{
            editorKit.read(new URL(urlLink).openStream(), htmlDoc, 0);
        }catch(Exception e){
            e.getStackTrace();
        }
        for(HTMLDocument.Iterator iter = htmlDoc.getIterator(HTML.Tag.A);iter.isValid();iter.next()){

            line=(String)(iter.getAttributes().getAttribute(HTML.Attribute.NAME)); // geändert: HTML.Attribute.HREF->HTML.Attribute.NAME
            if((line!=null)&&(list.indexOf(line)==-1)){
                list.add(line);
            }
        }
        System.out.println(list);
    }
}

//public class Aufgabe {
//
//    /**
//     * @param args
//     */
//
//    //Methode füllt eine List mit Urls auf
//    public static List <String> addUrls(String urlLink){
//
//        List<String>list=new ArrayList<String>();
//        String line="";
//
//        HTMLEditorKit editorKit = new HTMLEditorKit();
//        HTMLDocument htmlDoc = new HTMLDocument();
//        htmlDoc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
//
//        try{
//            editorKit.read(new URL(urlLink).openStream(), htmlDoc, 0);
//        }catch(Exception e){
//            e.getStackTrace();
//        }
//
//        for(HTMLDocument.Iterator iter = htmlDoc.getIterator(HTML.Tag.A);iter.isValid();iter.next()){
//
//            line=(String)(iter.getAttributes().getAttribute(HTML.Attribute.HREF));
//            if((line!=null)&&(list.indexOf(line)==-1)){
//                list.add(line);
//            }
//        }
//        return list;
//    }
//
//
//
//    //Metohde füllt die Ergebnisliste mit den gefundenen Listen von Urls
//    public static List<String> addList(String url,List<String>urlList){
//        int i=0;
//        int counter=0;
//        urlList.addAll(addUrls(url));
//
//        while(urlList.size()<=10000){
//            int j=0;
//            for(String e:addUrls(urlList.get(i))){
//
//                System.out.println(counter+" : "+e);
//                urlList.add(addUrls(urlList.get(i)).get(j));
//                counter++;
//                j++;
//            }
//
//            i++;
//        }
//        return urlList;
//    }
//
//
//
//
//    public static void main(String[] args) {
//        List <String> allLinks=new ArrayList<String>();
//        addList("https://boardgamegeek.com/browse/boardgame",allLinks);
//        int i=1;
//
//        for(String e:allLinks){
//            System.out.println(i+": "+e);
//            i++;
//        }
//    }
//}