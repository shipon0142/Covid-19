package com.example.covid_19.scrapper;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class ScrapData {
    public interface DataCallback {
        public void getData(String data);
    }

    public static class SearchScrap extends AsyncTask<Void, Void, Void> {
        public DataCallback dataCallback;
        private String text;
        public SearchScrap(DataCallback dataCallback) {
            this.dataCallback = dataCallback;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document mainPageDocument = Jsoup.connect("https://www.worldometers.info/coronavirus/country/bangladesh/")
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36")
                        .referrer("http://www.google.com")
                        .header("authority","www.worldometers.info")
                        .header("Content-Type","text/html; charset=UTF-8")
                        .header("Connection","keep-alive")
                        //.header("accept-encoding","gzip, deflate, br")
                        //.header("accept-language","en-US,en;q=0.9")
                        .timeout(60*1000)
                        .maxBodySize(0)
                        .get();
                getAllScript(mainPageDocument);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private void getAllScript(Document mainPageDocument) {
            Elements elements=mainPageDocument.getElementsByTag("script");
            int size=0;
            size=elements.size();
            for(int i=0;i<size;i++){
                String str=elements.get(i).toString();
                if(str.contains("graph-cases-daily")){
                    int firstIndex=str.indexOf("{");
                    int lastIndex=str.indexOf(");");
                   String json=str.substring(firstIndex,lastIndex);
                   text=json;
                   Log.d("json",json);
                   String strr="";

                }
            }
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            dataCallback.getData(text);
        }
    }
}
