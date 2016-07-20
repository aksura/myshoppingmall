package com.tsel.multimatics.myshoppingmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    private ProductAdapter adapter;
    private ArrayList<Product> listProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        String selectedCategory = getIntent().getStringExtra("category");
        getSupportActionBar().setTitle(selectedCategory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.lv_item);
        listProduct = new ArrayList<>();

        adapter = new ProductAdapter(ProductActivity.this);
        adapter.setListItem(listProduct);

        Product product = null;
        for (int i = 0; i < SampleData.boots.length; i++) {
            product = new Product();

            product.setId(System.currentTimeMillis());
            product.setName(SampleData.boots[i][0]);
            product.setPrice(SampleData.boots[i][2]);
            product.setImageURL(SampleData.boots[i][1]);

            listProduct.add(product);
        }

        adapter.setListItem(listProduct);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ProductActivity.this, DetailProductActivity.class);
        intent.putExtra("product", listProduct.get(position));
        startActivity(intent);
    }
}
