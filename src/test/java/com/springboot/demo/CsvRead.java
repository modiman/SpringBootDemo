package com.springboot.demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;

public class CsvRead {
    public static void readCSV() {
        ArrayList<String[]> csvFileList = new ArrayList<String[]>();
        String csvFilePath = "D://test.csv";
        try {
            CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));
            // 跳过表头
            reader.readHeaders();
            // 逐行读入除表头的数据
            while (reader.readRecord()) {
                System.out.println(reader.getRawRecord());
                csvFileList.add(reader.getValues());
            }
            reader.close();

            // 遍历读取CSV每行每列
            for (int row = 0; row < csvFileList.size(); row++) {
                String[] cells = csvFileList.get(row);
                for (String str : cells) {
                    System.out.print(str + "  ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CsvRead.readCSV();
    }
}