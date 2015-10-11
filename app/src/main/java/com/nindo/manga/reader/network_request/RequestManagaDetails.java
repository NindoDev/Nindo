package com.nindo.manga.reader.network_request;

import com.nindo.manga.reader.R;
import com.nindo.manga.reader.data_model.Manga;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NindoDev on 9/29/2015.
 */
public class RequestManagaDetails {


    // TODO: 9/29/2015   Make network request for Manga details using API


    static List<Manga> mangaList;
    final static String[] mangaNames = {"STS-41G Mission", "Supermoon Eclipse", "Hurricane Joaquin", "Charon in Enhanced Color", "The Nile at Night", "Clear Skies Over the United States"};


    public static List<Manga> getMangaList() {
        mangaList = new ArrayList<>();
        //For simulation inject resources from drawable
//        mangaList.add(new Manga(1, mangaNames[0], R.drawable.one, "Long Description"));
//        mangaList.add(new Manga(2, mangaNames[1], R.drawable.two, "Long Description"));
//        mangaList.add(new Manga(3, mangaNames[2], R.drawable.three, "Long Description"));
//        mangaList.add(new Manga(4, mangaNames[3], R.drawable.four, "Long Description"));
//        mangaList.add(new Manga(5, mangaNames[4], R.drawable.five, "Long Description"));
//        mangaList.add(new Manga(6, mangaNames[5], R.drawable.six, "Long Description"));

        return mangaList;
    }



}
