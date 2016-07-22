package com.tsel.multimatics.myshoppingmall;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tsel.multimatics.myshoppingmall.db.CartItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Multimatics on 22/07/2016.
 */
public class CartAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<CartItem> list;
    private String[] qtyOptions = new String[] {
            "1","2","3","4","5"
    };

    public CartAdapter(Activity activity) {
        setActivity(activity);
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ArrayList<CartItem> getList() {
        return list;
    }

    public void setList(ArrayList<CartItem> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_row_cart, null);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        CartItem item = (CartItem) getItem(pos);

        viewHolder.tvProductName.setText(item.getName());
        viewHolder.tvProductPrice.setText(String.valueOf(item.getPrice()));
        Glide.with(activity).load(item.getImage()).into(viewHolder.imgProduct);

        int selectedQtyposition = 0;

        for (int j = 0; j < qtyOptions.length; j++) {
            if (Integer.parseInt(qtyOptions[j]) == item.getQty()) {
                selectedQtyposition = j;
                break;
            }
        }

        viewHolder.spnQty.setSelection(selectedQtyposition);

//        viewHolder.imgDelete.setOnClickListener(new CustomOnItemClickListener());


        viewHolder.tvProductSubTotal.setText("5");


        return null;
    }

    static class ViewHolder {
        @BindView(R.id.img_delete)
        ImageView imgDelete;
        @BindView(R.id.img_product)
        ImageView imgProduct;
        @BindView(R.id.tv_product_name)
        TextView tvProductName;
        @BindView(R.id.tv_product_price)
        TextView tvProductPrice;
        @BindView(R.id.spn_qty)
        Spinner spnQty;
        @BindView(R.id.tv_product_sub_total)
        TextView tvProductSubTotal;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
