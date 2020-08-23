package com.example.securi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter_datainfo extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem_datainfo> listViewItemList = new ArrayList<ListViewItem_datainfo>();

    // ListViewAdapter의 생성자
    public ListViewAdapter_datainfo() {

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
            convertView = inflater.inflate(R.layout.securi_datainfo_listview, parent, false);
        }
        TextView dataTitle = (TextView) convertView.findViewById(R.id.dataTitle);
        TextView dataDate = (TextView) convertView.findViewById(R.id.dataDate);
        Button btnDel = (Button) convertView.findViewById(R.id.btnDel);
        Button btnDown = (Button) convertView.findViewById(R.id.btnDown);
        ImageView dataInfoImg  = (ImageView) convertView.findViewById(R.id.dataInfoImg);

        ListViewItem_datainfo listViewItem = listViewItemList.get(position);
        dataDate.setText(listViewItem.getDataDate());
        dataTitle.setText(listViewItem.getDataTitle());
        dataInfoImg.setImageResource(listViewItem.getDataInfoImg());

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //파이어베이스에서 데이터 삭제하는 코딩
            }
        });
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //파이어베이스에서 이미지 다운 받는 코딩
            }
        });
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
    public void addItem_dataInfo(String dataTitle, String dataDate, int dataInfoImg) {
        ListViewItem_datainfo data_item = new ListViewItem_datainfo();

        data_item.setDataDate(dataDate);
        data_item.setDataTitle(dataTitle);
        data_item.setDataInfoImg(dataInfoImg);

        listViewItemList.add(data_item);
    }
}
