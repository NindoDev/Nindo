package com.nindo.manga.reader.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nindo.manga.reader.R;
import com.nindo.manga.reader.cache_bitmaps.ImageDetailActivity;
import com.nindo.manga.reader.data_model.Manga;
import com.nindo.manga.reader.manga_details.MangaDetailsActivity;
import com.nindo.manga.reader.network_request.RequestManagaDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by NindoDev on 9/27/2015.
 */
public class HomeListViewFragment extends Fragment {
    public static Resources res;

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
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(), RequestManagaDetails.getMangaList()));
    }

    private List<String> getRandomSublist(String[] array, int amount) {
        ArrayList<String> list = new ArrayList<>(amount);
        Random random = new Random();
        while (list.size() < amount) {
            list.add(array[random.nextInt(array.length)]);
        }
        return list;
    }

    public static class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();
        private int mBackground;
        public List<Manga> mValues;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public String mBoundString;
            public Bitmap mImage;
            public final View mView;
            public final ImageView mImageView;
            public final TextView mTextView;


            public ViewHolder(View view) {
                super(view);
                mView = view;
                mImageView = (ImageView) view.findViewById(R.id.avatar);
                mTextView = (TextView) view.findViewById(android.R.id.text1);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mTextView.getText();
            }
        }

//        public String getValueAt(int position) {
//            return mValues.get(position);
//        }

        public SimpleStringRecyclerViewAdapter(Context context, List<Manga> mangaItems) {
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
            mBackground = mTypedValue.resourceId;
            mValues = mangaItems;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.home_fragment_view, parent, false);
            view.setBackgroundResource(mBackground);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {

           // holder.mImage = ImageDetailActivity.decodeSampledBitmapFromResource(res, mValues.get(position).getMangaImage(), 100, 100);
           // holder.mTextView.setText(mValues.get(position).getMangaTitle());
            holder.mImageView.setImageBitmap(holder.mImage);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MangaDetailsActivity.class);
                    intent.putExtra(MangaDetailsActivity.EXTRA_NAME, position);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }
    }


}
