package com.example.securi.listView;

public class ListViewItem_datainfo {
    String dataTitle;
    String dataDate;
    int dataInfoImg;

    public ListViewItem_datainfo(){}
    public ListViewItem_datainfo(String dataTitle, String dataDate, int dataInfoImg){
        this.dataTitle = dataTitle;
        this.dataDate = dataDate;
        this.dataInfoImg = dataInfoImg;
    }
    public String getDataTitle() {
        return dataTitle;
    }

    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public int getDataInfoImg() {
        return dataInfoImg;
    }

    public void setDataInfoImg(int dataInfoImg) {
        this.dataInfoImg = dataInfoImg;
    }

}
