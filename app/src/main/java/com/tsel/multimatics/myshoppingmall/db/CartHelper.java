package com.tsel.multimatics.myshoppingmall.db;



import android.content.Context;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Multimatics on 22/07/2016.
 */
public class CartHelper {

    private Realm realm;
    private Context mContext;

    public CartHelper(Context mContext) {
        this.mContext = mContext;

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(mContext).build();
        realm = Realm.getInstance(realmConfiguration);
    }

    public void create(int id, String name, String image, int qty, double price) {
        realm.beginTransaction();

        CartItem mCartItem = realm.createObject(CartItem.class);

        mCartItem.setId(id);
        mCartItem.setName(name);
        mCartItem.setImage(image);
        mCartItem.setQty(qty);;
        mCartItem.setPrice(price);

        realm.commitTransaction();
    }

    public ArrayList<CartItem> getAll() {
        ArrayList<CartItem> listCartItem = null;

        RealmResults<CartItem> results = realm.where(CartItem.class).findAll();

        if (results.size() > 0 ) {
            listCartItem = new ArrayList<CartItem>();

            for (CartItem cartItem : listCartItem) {
                listCartItem.add(cartItem);
            }
        }

        return listCartItem;
    }

    public void update(int qty, int id) {
        realm.beginTransaction();
        CartItem cartItem = realm.where(CartItem.class).equalTo("id", id).findFirst();
        cartItem.setQty(qty);

        realm.commitTransaction();
    }

    public void delete(int id) {
        realm.beginTransaction();
        RealmResults<CartItem> items = realm.where(CartItem.class).equalTo("id", id).findAll();
        CartItem item = items.get(0);

        item.deleteFromRealm();

        realm.commitTransaction();
    }

    public boolean isItemAlreadyExist(int id) {
        CartItem cartItem = realm.where(CartItem.class).equalTo("id", id).findFirst();

        if (cartItem == null) {
            return true;
        }else {
            return false;
        }
    }
}
