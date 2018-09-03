package com.xiaoping.controller.api;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class ExcelController {


//    public static void main(String[] args) throws IOException {

        // 1. 写到 Excel
        // writeToExcel("Hello POI!");

//        String[] arr = {"商户订单号", "宝付订单号", "商品名称", "用户名称", "type", "支付类型", "创建时间", "订单状态", "订单金额",
//                "amount", "手续费", "accountName", "accountNo", "失败原因", "开始时间", "payTime", "remark"};
//        String s = "accountName";
//        System.out.println(Arrays.binarySearch(arr, s));
//        readExcel();
//    }

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

    public static void readExcel () throws IOException {
        // 2. 读 Excel
        String filePath = "/src/main/resources/doc/支付宝转账.xls"; // XML row file
//        String filePath = "/src/main/resources/doc/银行转账.xls";
//        String filePath = "/src/main/resources/doc/宝付代扣.xlsx";
        InputStream in = new FileInputStream(System.getProperty("user.dir") + filePath);

        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(in);
//            System.out.println(document.asXML());
            Element root = document.getRootElement();
            Element sheet = root.element("Worksheet");
            Element table = sheet.element("Table");
            List<Element> rows = table.elements();
            for (Element row : rows){
                if(rows.indexOf(row) <= 3) continue;
                List<Element> cells = row.elements();
                for(Element cell : cells) {
                    System.out.println("cellIdx: " + cells.indexOf(cell));
                    System.out.println(cell.getStringValue());
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
//        Workbook wb = null;
//        try{
//            wb = new HSSFWorkbook(in);
//        } catch (Exception e) {
//            e.printStackTrace();
//            in = new FileInputStream(System.getProperty("user.dir") + filePath);
//            if(e instanceof OfficeXmlFileException) {
//                wb = new XSSFWorkbook(in);
//            } else {
//
//            }
//
//        }
//
//        System.out.println("Read Excel Start.");
//        Sheet sheet = wb.getSheetAt(0);
//        for (Row row : sheet){
//
//            for(Cell cell: row){
//                System.out.println(cell.getRowIndex() + ": " +  cell.toString());
//            }
//
//        }
//        System.out.println("Read Excel End.");
    }

}
