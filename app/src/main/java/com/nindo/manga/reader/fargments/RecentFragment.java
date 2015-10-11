package com.nindo.manga.reader.fargments;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.nindo.manga.reader.R;
import com.nindo.manga.reader.network_request.RequestManagaDetails;
import com.nindo.manga.reader.network_request.VolleySingleton;
import com.nindo.manga.reader.adapters.RecentFragmentAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by NindoDev on 9/27/2015.
 */
public class RecentFragment extends Fragment {
    public static Resources res;
    private RequestQueue requestQueue;
    VolleySingleton volleySingleton ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //call volley singleton class to handle all the network request
         volleySingleton = VolleySingleton.getInstance(getActivity().getApplicationContext());
        requestQueue = volleySingleton.getRequestQueue();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.list_view, container, false);
        setupRecyclerView(rv);
        res = getResources();
        return rv;
    }


    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new RecentFragmentAdapter(getActivity(), RequestManagaDetails.getMangaList()));
        // Add a request (in this example, called stringRequest) to your RequestQueue.
       // volleySingleton.addToRequestQueue(stringRequest);
    }




}
