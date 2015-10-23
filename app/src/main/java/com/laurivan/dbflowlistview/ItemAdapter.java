/*
 * Copyright (c) 2015 Laur IVAN.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.laurivan.dbflowlistview;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.raizlabs.android.dbflow.list.FlowCursorList;

/**
 * Adapter for the listview
 * <p/>
 * Created by ivanlla on 22/10/2015.
 */
public class ItemAdapter extends BaseAdapter {
    private FlowCursorList<SampleTable> mFlowCursorList;
    private Context context;

    public ItemAdapter(Context context) {
        // retrieve and cache rows
        this.context = context;
        mFlowCursorList = new FlowCursorList<>(false, SampleTable.class);
    }

    @Override
    public int getCount() {
        return mFlowCursorList.getCount();
    }

    @Override
    public SampleTable getItem(int position) {
        return mFlowCursorList.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // This a new view we inflate the new layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.fragment_item_list, null);
        SampleTable item = getItem(position);

        TextView textView = (TextView) rowView.findViewById(R.id.article_title);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText(String.format("Item: %d", item.id));

        TextView dateView = (TextView) rowView.findViewById(R.id.article_content);
        dateView.setText(item.name);

        return rowView;
    }

    @Override
    public void notifyDataSetChanged() {
        mFlowCursorList.refresh();
        super.notifyDataSetChanged();
    }
}
