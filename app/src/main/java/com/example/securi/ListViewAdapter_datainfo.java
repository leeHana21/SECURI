package com.example.securi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.Image;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewAdapter_datainfo extends BaseAdapter {
    Context context;
    ArrayList<ListViewItem_datainfo> list;
    LayoutInflater inflater;
    AlertDialog dialog;



    public ListViewAdapter_datainfo(Context context, ArrayList<ListViewItem_datainfo> list){
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    public void addDTO(ListViewItem_datainfo dto) {
        list.add(dto);
    }

    //리스트의 항목을 삭제할 메서드 작성
    public void delDTO(int position) {
        list.remove(position);
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
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        InfoViewHolder viewHolder;
        if(convertView ==null){
            convertView = inflater.inflate(R.layout.securi_datainfo_listview,parent,false);
            viewHolder = new InfoViewHolder();
            viewHolder.date = convertView.findViewById(R.id.dataDate);
            viewHolder.image = convertView.findViewById(R.id.dataInfoImg);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (InfoViewHolder) convertView.getTag();
        }
        ListViewItem_datainfo dto = list.get(position);
        String date = dto.getDataDate();
        int resId = dto.getDataInfoImg();

        viewHolder.date.setText(date);
        viewHolder.date.setGravity(Gravity.CENTER_HORIZONTAL);
        viewHolder.image.setImageResource(resId);

        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "선택 : "+position+",날짜 : "+list.get(position).getDataDate(), Toast.LENGTH_SHORT).show();
                popupXml(list.get(position).getDataInfoImg(),list.get(position).getDataDate());
            }
        });
        return convertView;
    }
    public class InfoViewHolder{
        public ImageView image;
        public TextView date;
    }
    public void popupXml(int resId, String date){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.securi_datainfo_dialog,null);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        imageView.setImageResource(resId);
        textView.setText(date);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("상세보기").setView(view);
        builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(dialog!=null){
                    dialog.dismiss();
                }
            }
        });
        builder.setPositiveButton("다운", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dialog!=null){
                    dialog.dismiss();
                }
            }
        });
        dialog = builder.create();
        dialog.setOnShowListener( new DialogInterface.OnShowListener() {
            @Override public void onShow(DialogInterface arg0) {
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
            }
        });
        dialog.show();
    }

}
