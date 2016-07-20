package com.tsel.multimatics.myshoppingmall;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class DetailImageActivity extends AppCompatActivity {
    private ArrayList<String> listImageURL;
    private ViewPager viewPager;
    private ImagePagerAdapter adapter;

    private int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_image);

        getSupportActionBar().hide();
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        listImageURL = getIntent().getStringArrayListExtra("url_images");
        selectedPosition = getIntent().getIntExtra("pos",0);

        adapter = new ImagePagerAdapter(getSupportFragmentManager());
        adapter.setListImages(listImageURL);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(selectedPosition);
    }
}
