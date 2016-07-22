package com.tsel.multimatics.myshoppingmall;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Multimatics on 22/07/2016.
 */
public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener{

    private OnItemSelectedCallBack onItemSelectedCallBack;
    private int pos;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        onItemSelectedCallBack.onItemSelected(view, pos, position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public interface OnItemSelectedCallBack {
        void onItemSelected (View view, int pos, int arr_pos);
    }
}
