package com.nindo.manga.reader.manga_details;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;

import com.nindo.manga.reader.R;
import com.nindo.manga.reader.cache_bitmaps.ImageDetailActivity;
import com.nindo.manga.reader.data_model.Manga;
import com.nindo.manga.reader.home.HomeListViewFragment;
import com.nindo.manga.reader.network_request.RequestManagaDetails;

import java.util.List;

/**
 * Created by NindoDev on 9/29/2015.
 */
public class MangaDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "manga_name";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manga_details_activity);

        Intent intent = getIntent();
        final int position = intent.getIntExtra(EXTRA_NAME, 0);
        List<Manga> mangaList = RequestManagaDetails.getMangaList();
        final Bitmap mangaImage =  ImageDetailActivity.decodeSampledBitmapFromResource(getResources(), mangaList.get(position).getMangaImage(), 100, 100);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final String mangaName = mangaList.get(position).getMangaTitle();

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(mangaName);
       // collapsingToolbar.setCollapsedTitleTextAppearance(R.style.MyTextAppearance);
        loadBackdrop( mangaImage);
    }

    private void loadBackdrop(Bitmap mangaImage) {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        imageView.setImageBitmap(mangaImage);
//        WebView view = (WebView) findViewById(R.id.mangaContent);
//        String text;
//        text = "<html><body><p align=\"justify\">";
//        text+= getResources().getString(R.string.manga_desc);
//        text+= "</p></body></html>";
//        view.loadData(text, "text/html", "utf-8");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
