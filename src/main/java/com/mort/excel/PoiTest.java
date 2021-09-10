package com.mort.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mortli on 1/13/17.
 */
public class PoiTest {


    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            OutputStream out = new FileOutputStream("./test.xls");
            List<List<String>> data = new ArrayList<List<String>>();
            List<List<String>> dataA = new ArrayList<List<String>>();
            List<List<String>> dataB = new ArrayList<List<String>>();
            List<List<String>> dataC = new ArrayList<List<String>>();
            for (int i = 1; i < 4; i++) {
                List rowData = new ArrayList();
                rowData.add(String.valueOf(i));
                rowData.add("东霖\r\n柏鸿");
                data.add(rowData);
            }
            String[] headers = { "ID", "用户名" };
            ExportExcelUtils eeu = new ExportExcelUtils();
            //HSSFWorkbook workbook = new HSSFWorkbook();
            SXSSFWorkbook workbook = new SXSSFWorkbook(500);
            eeu.exportExcel(workbook, 0, true  , "上海", headers, data, out);
            //eeu.exportExcel(workbook, 0, false , "上海", headers, data, out);
            eeu.exportExcel(workbook, 1, true , "深圳", headers, dataA, out);
            eeu.exportExcel(workbook, 2, true , "广州", headers, dataB, out);
            //原理就是将所有的数据一起写入，然后再关闭输入流。
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
