package com.tsel.multimatics.myshoppingmall;

import android.view.View;

/**
 * Created by Multimatics on 22/07/2016.
 */
public class CustomOnItemClickListener implements View.OnClickListener {

    private OnItemClickCalllBack onItemClickCallback;
    private int pos;

    public CustomOnItemClickListener(OnItemClickCalllBack onItemClickCallback, int pos) {
        this.onItemClickCallback = onItemClickCallback;
        this.pos = pos;
    }

    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, pos);
    }

    public interface OnItemClickCalllBack {
        void onItemClicked(View view, int pos);
    }
}
