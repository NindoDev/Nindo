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
    List<Manga> mangaList;
    final String[] mangaNames = {"Breserk", "Death Note", "Dragon Ball Z", "Hunter X Hunter", "Naruto", "One Piece"};

    public RequestManagaDetails() {
        mangaList = new ArrayList<>();
        //For simulation inject resources from drawable
        mangaList.add(new Manga(1, mangaNames[0], R.drawable.breserk, "Long Description"));
        mangaList.add(new Manga(2, mangaNames[1], R.drawable.death_note, "Long Description"));
        mangaList.add(new Manga(3, mangaNames[2], R.drawable.dragon_ball_z, "Long Description"));
        mangaList.add(new Manga(4, mangaNames[3], R.drawable.hunter_x_hunter, "Long Description"));
        mangaList.add(new Manga(5, mangaNames[4], R.drawable.naruto, "Long Description"));
        mangaList.add(new Manga(6, mangaNames[5], R.drawable.one_piece, "Long Description"));


    }


}
