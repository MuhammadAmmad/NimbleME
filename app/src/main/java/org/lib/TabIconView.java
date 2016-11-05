/*
 * Copyright 2016. Arshad Ali <arshadalisoomro7@gmail.com.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lib;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import org.arshad.nimbleme.R;


/**
 * Created by Arshay on 9/20/2016.
 */

public class TabIconView extends HorizontalScrollView {
    private LinearLayout mLayout;
    private LayoutInflater mInflater;

    public TabIconView(Context context) {
        super(context);
        init();
    }

    public TabIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TabIconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setOverScrollMode(OVER_SCROLL_NEVER);
        this.setHorizontalScrollBarEnabled(false);

        mInflater = LayoutInflater.from(getContext());

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mLayout = new LinearLayout(getContext());
        mLayout.setPadding(1, 0, 1, 0);
        mLayout.setOrientation(LinearLayout.HORIZONTAL);
        addView(mLayout, params);
    }


    public void addTab(@DrawableRes int iconId, @IdRes int id, OnClickListener onClickListener) {
        ImageButton view = (ImageButton) mInflater.inflate(R.layout.item_tab_icon, mLayout, false);
        view.setImageResource(iconId);
        view.setId(id);
        view.setOnClickListener(onClickListener);
        mLayout.addView(view, mLayout.getChildCount());
        this.postDelayed(new Runnable() {
            @Override
            public void run() {
                TabIconView.this.smoothScrollBy(1000, 0);
            }
        }, 5);
    }


    public void removeTab() {
        int count = mLayout.getChildCount();
        mLayout.removeViewAt(count - 1);
    }

}