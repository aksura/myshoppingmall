package com.tsel.multimatics.myshoppingmall;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Multimatics on 19/07/2016.
 */

public class ProductAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Product> listItem = new ArrayList<Product>();

    public ArrayList<Product> getListItem() {
        return listItem;
    }

    public void setListItem(ArrayList<Product> listItem) {
        this.listItem = listItem;
    }

    public ProductAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.item_layout, null);
            viewHolder = new ViewHolder();

            viewHolder.imgItem = (ImageView) view.findViewById(R.id.img_item_product);
            viewHolder.tvPrice = (TextView) view.findViewById(R.id.tv_item_price);
            viewHolder.tvName = (TextView) view.findViewById(R.id.tv_item_name);

            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Product item = listItem.get(position);

        viewHolder.tvName.setText(item.getName());
        viewHolder.tvPrice.setText(item.getPrice());

        Glide.with(activity).load(item.getImageURL()).into(viewHolder.imgItem);

        return view;
    }

    static class ViewHolder {
        ImageView imgItem;
        TextView tvName, tvPrice;
    }
}
