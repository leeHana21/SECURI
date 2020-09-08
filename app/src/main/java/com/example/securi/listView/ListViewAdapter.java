package com.example.securi.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.securi.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    // ListViewAdapter의 생성자
    public ListViewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.securi_entryhistory_listview, parent, false);
        }
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView content = (TextView) convertView.findViewById(R.id.content);
        ImageView entryData = (ImageView) convertView.findViewById(R.id.entryData);

        ListViewItem listViewItem = listViewItemList.get(position);
        date.setText(listViewItem.getDate());
        title.setText(listViewItem.getTitle());
        content.setText(listViewItem.getContent());
        entryData.setImageResource(listViewItem.getEntryData());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    public void addItem(String date, String title, String content, int entryData) {
        ListViewItem item = new ListViewItem();

        item.setDate(date);
        item.setTitle(title);
        item.setContent(content);
        item.setEntryData(entryData);

        listViewItemList.add(item);
    }
}
