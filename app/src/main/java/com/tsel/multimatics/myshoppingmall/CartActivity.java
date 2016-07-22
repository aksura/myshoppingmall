package com.tsel.multimatics.myshoppingmall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.tsel.multimatics.myshoppingmall.db.CartHelper;
import com.tsel.multimatics.myshoppingmall.db.CartItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity {
    @BindView(R.id.lv_item)
    ListView lvItem;

    private ArrayList<CartItem> list;
    private CartHelper cartHelper;
    private CartAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cartHelper = new CartHelper(CartActivity.this);
        list = cartHelper.getAll();

        adapter = new CartAdapter(CartActivity.this);
        if (list != null) {
            if (list.size() > 0) {
                adapter.setList(list);
            }else {
                adapter.setList(new ArrayList<CartItem>());
                Toast.makeText(CartActivity.this, "Cart is empty", Toast.LENGTH_SHORT).show();

            }

        }else {
            Toast.makeText(CartActivity.this, "Cart is empty", Toast.LENGTH_SHORT).show();
        }

        lvItem.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
