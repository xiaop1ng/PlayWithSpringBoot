package com.xiaoping.controller.api;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ExcelController {


    public static void main(String[] args) throws IOException {

        // 1. 写到 Excel
        // writeToExcel("Hello POI!");

        // 2. 读 Excel
        String filePath = "/src/main/resources/doc/支付宝转账.xls";
//        String filePath = "/src/main/resources/doc/银行转账.xls";
//        String filePath = "/src/main/resources/doc/宝付代扣.xlsx";
        FileInputStream in = new FileInputStream(System.getProperty("user.dir") + filePath);
        Workbook wb = null;
        try{
            wb = new HSSFWorkbook(in);
        } catch (Exception e) {
            in = new FileInputStream(System.getProperty("user.dir") + filePath);
            wb = new XSSFWorkbook(in);
        }

        System.out.println("Read Excel Start.");
        Sheet sheet = wb.getSheetAt(0);
        for (Row row : sheet){

            for(Cell cell: row){
                System.out.println(cell.toString());
            }

        }
        System.out.println("Read Excel End.");
    }

    public static void writeToExcel(String value) throws IOException {
        // 文档对象
        Workbook wb = new HSSFWorkbook();

        // sheet 对象
        HSSFSheet sheet = (HSSFSheet) wb.createSheet("sheet1");

        // 行对象
        HSSFRow row = sheet.createRow(0);

        // 单元格对象
        HSSFCell cell = row.createCell(0);

        // 给单元格写值
        cell.setCellValue(value);

        // 输出到文件
        wb.write(new FileOutputStream(System.getProperty("user.dir") + "/src/main/resources/doc/out/out.xls"));
    }

}
