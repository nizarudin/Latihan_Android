package com.example.nizar.animelist;

import org.json.JSONObject;

import java.io.Serializable;

public class Anime implements Serializable {
    String judul, gambar, tanggal, genre;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Anime(String judul, String gambar, String tanggal, String genre){
        this.judul=judul;
        this.gambar=gambar;
        this.tanggal=tanggal;
        this.genre=genre;
    }


}

/*public class Anime {
    private String id ="id";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSrcVideo() {
        return srcVideo;
    }

    public void setSrcVideo(String srcVideo) {
        this.srcVideo = srcVideo;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGanre() {
        return ganre;
    }

    public void setGanre(String ganre) {
        this.ganre = ganre;
    }

    public String getHalaman() {
        return halaman;
    }

    public void setHalaman(String halaman) {
        this.halaman = halaman;
    }
Anime(JSONObject obj){
   try {
       String id = obj.getString("id");
       String judul = obj.getString("judul");
       String url = obj.getString("url");
       String src_video = obj.getString("src_video");
       String prev_video = obj.getString("prev_video");
       String all_video = obj.getString("all_video");
       String next_video = obj.getString("next_video");
       String gambar = obj.getString("gambar");
       String tanggal = obj.getString("tanggal");
       String genre = obj.getString("genre");
       String halaman = obj.getString("halaman");

       this.id =id;
       this.judul = judul;
       this.url = url;
       this.srcVideo = src_video;
       this.prev = prev_video;
       this.all = all_video;
       this.next = next_video;
       this.img = gambar;
       this.date = tanggal;
       this.ganre = genre;
       this.halaman = halaman;
   } catch (Exception e) {
       e.printStackTrace();
   }
}

    private String judul = "judul";
    private String url = "url";
    private String srcVideo = "srcVideo";
    private String prev = "prev";
    private String all = "all";
    private String next = "next";
    private String img = "img";
    private String date = "date";
    private String ganre = "ganre";
    private String halaman = "halaman";

}*/
