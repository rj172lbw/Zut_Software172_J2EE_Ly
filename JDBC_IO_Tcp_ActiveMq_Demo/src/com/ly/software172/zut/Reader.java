package com.ly.software172.zut;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public Reader() {
    }

    public static String Reader_MyTcpClient() {
        BufferedReader bufferedReader;
        String string = null;
        String strings = "";
        try {
            bufferedReader = new BufferedReader(new FileReader("D:/Java/Java_Practice__SC/JDBC_IO_Tcp_Demo/src/Txt"));
            while((string = bufferedReader.readLine()) != null) {
                strings += string;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
