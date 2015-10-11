package com.nindo.manga.reader.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nindo.manga.reader.R;
import com.nindo.manga.reader.data_model.Manga;
import com.nindo.manga.reader.activities.MangaDetailsActivity;

import java.util.List;

/**
 * Created by NindoDev on 10/11/2015.
 */
public class RecentFragmentAdapter
        extends RecyclerView.Adapter<RecentFragmentAdapter.ViewHolder> {

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



    public RecentFragmentAdapter(Context context, List<Manga> mangaItems) {
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
