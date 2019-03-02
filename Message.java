package com.ly.software172.zut;

public class Message {
    private String Txt;
    private String Date;

    public Message(String txt, String date) {
        Txt = txt;
        Date = date;
    }

    public String getTxt() {
        return Txt;
    }

    public String getDate() {
        return Date;
    }

    public void setTxt(String txt) {
        Txt = txt;
    }

    public void setDate(String date) {
        Date = date;
    }
}
