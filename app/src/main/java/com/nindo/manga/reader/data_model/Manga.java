package com.nindo.manga.reader.data_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NindoDev on 9/29/2015.
 */
public class Manga {

    private String url;

    private String mediaType;

    private String explanation;

    private List<String> concepts = new ArrayList<String>();

    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<String> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<String> concepts) {
        this.concepts = concepts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

