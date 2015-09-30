package com.nindo.manga.reader.data_model;

/**
 * Created by NindoDev on 9/29/2015.
 */
public class Manga {
    private int mangaId;
    private String mangaTitle;
    private int mangaImage;
    private String mangaDescription;

    public Manga(int mangaId, String mangaTitle, int mangaImage, String mangaDescription) {
        this.mangaId = mangaId;
        this.mangaTitle = mangaTitle;
        this.mangaImage = mangaImage;
        this.mangaDescription = mangaDescription;
    }

    public int getMangaId() {
        return mangaId;
    }


    public String getMangaTitle() {
        return mangaTitle;
    }


    public String getMangaDescription() {
        return mangaDescription;
    }


}
