package com.nindo.manga.reader.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nindo.manga.reader.R;
import com.nindo.manga.reader.data_model.Manga;
import com.nindo.manga.reader.interfaces.RecyclerViewClickListenerInterface;
import com.nindo.manga.reader.network_request.GsonRequest;
import com.nindo.manga.reader.network_request.VolleySingleton;
import com.nindo.manga.reader.adapters.RecentFragmentAdapter;
import com.nindo.manga.reader.string_constants.AllConstants;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NindoDev on 9/27/2015.
 */
public class RecentFragment extends Fragment implements RecyclerViewClickListenerInterface {
    private Manga manga;
    private Gson gson;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        gson = new Gson();

        //Inflate the layout for the fragment
        View recentFragmentLayout = inflater.inflate(R.layout.list_view, container, false);
        RecyclerView recyclerView = (RecyclerView) recentFragmentLayout.findViewById(R.id.recyclerView);

        //set the layout manager before displaying data
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        RecentFragmentAdapter recentFragmentAdapter = new RecentFragmentAdapter(getActivity());
        recentFragmentAdapter.setRecyclerViewClickListener(this);
        recyclerView.setAdapter(recentFragmentAdapter);
        makeNetworkRequest();
        return recentFragmentLayout;
    }

    private void makeNetworkRequest() {
        GsonRequest<Manga> gsonRequest = new GsonRequest<Manga>(AllConstants.NASA_BASE_URL,
                Manga.class,
               null,
                createMyReqSuccessListener(),
                createMyReqErrorListener());
        // Access the RequestQueue through your singleton class.
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(gsonRequest);
    }

    @Override
    public void selectedTvShow(View v, int position) {

    }

    private Response.Listener<Manga> createMyReqSuccessListener() {
        return new Response.Listener<Manga>() {
            @Override
            public void onResponse(Manga response) {
                System.out.println("response ----> "+response.toString());
                // Do whatever you want to do with response;
                // Like response.tags.getListing_count(); etc. etc.
            }
        };
    }

    private Response.ErrorListener createMyReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Do whatever you want to do with error.getMessage();
            }
        };
    }
}
