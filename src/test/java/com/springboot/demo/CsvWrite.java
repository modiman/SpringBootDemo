package com.springboot.demo;

import java.nio.charset.Charset;

import com.csvreader.CsvWriter;

public class CsvWrite {
    public static void csvWrite() {
        String csvFilePath = "D://test.csv";
        try {
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));
            // 表头
            String[] csvHeaders = {"编号", "姓名", "年龄"};
            csvWriter.writeRecord(csvHeaders);
            // 内容  
            for (int i = 0; i < 5; i++) {
                String[] csvContent = {i + "", "userName", "1" + i};
                csvWriter.writeRecord(csvContent);
            }
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CsvWrite.csvWrite();
    }
}