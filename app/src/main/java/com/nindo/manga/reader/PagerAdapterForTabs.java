package com.nindo.manga.reader;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by NindoDev on 9/27/2015.
 */
public class PagerAdapterForTabs  extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterForTabs(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PopularMangaFragment tab1 = new PopularMangaFragment();
                return tab1;
            case 1:
                NewMangaFragment tab2 = new NewMangaFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}