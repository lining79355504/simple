package excel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;



import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

/**
 * Created by mortli on 1/13/17.
 */
public class ExportExcelUtils {


    /**
     * @Title: exportExcel
     * @Description: 导出Excel的方法
     * @author: evan @ 2014-01-09
     * @param workbook
     * @param sheetNum (sheet的位置，0表示第一个表格中的第一个sheet)
     * @param sheetTitle  （sheet的名称）
     * @param headers    （表格的标题）
     * @param result   （表格的数据）
     * @param out  （输出流）
     * @throws Exception
     */
    public void exportExcel(HSSFWorkbook workbook, int sheetNum, boolean sheetType ,
                            String sheetTitle, String[] headers, List<List<String>> result,
                            OutputStream out) throws Exception {
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        if(sheetType){
            workbook.setSheetName(sheetNum, sheetTitle);
        }else {
            workbook.setActiveSheet(sheetNum);
        }
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell((short) i);
            //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }
        // 遍历集合数据，产生数据行
        if (result != null) {
            int index = 1;
            for (List<String> m : result) {
                row = sheet.createRow(index);
                int cellIndex = 0;
                for (String str : m) {
                    HSSFCell cell = row.createCell((short) cellIndex);
                    //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                    cell.setCellValue(str.toString());
                    cellIndex++;
                }
                index++;
            }
        }
    }

    public void exportExcel(SXSSFWorkbook workbook, int sheetNum, boolean sheetType ,
                            String sheetTitle, String[] headers, List<List<String>> result,
                            OutputStream out) throws Exception {
        // 生成一个表格
        Sheet sheet = workbook.createSheet();
        if(sheetType){
            workbook.setSheetName(sheetNum, sheetTitle);
        }else {
            workbook.setActiveSheet(sheetNum);
        }
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        CellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        Font font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        Row row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell((short) i);
            //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }
        // 遍历集合数据，产生数据行
        if (result != null) {
            int index = 1;
            for (List<String> m : result) {
                row = sheet.createRow(index);
                int cellIndex = 0;
                for (String str : m) {
                    Cell cell = row.createCell((short) cellIndex);
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setWrapText(true);
                    cell.setCellStyle(cellStyle);
                    //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                    XSSFRichTextString text = new XSSFRichTextString(str);
                    cell.setCellValue(text);
                    cellIndex++;
                }
                index++;
            }
        }
    }


    public static void exportExcel(Workbook workbook, int sheetNum, boolean sheetType,
                                   String sheetTitle, String[] headers, List<List<String>> result,
                                   OutputStream out) throws Exception {
        // 生成一个表格
        Sheet sheet = workbook.createSheet();
        if (sheetType) {
            workbook.setSheetName(sheetNum, sheetTitle);
        } else {
            workbook.setActiveSheet(sheetNum);
        }
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        CellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        Font font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        Row row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell((short) i);
            //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }
        // 遍历集合数据，产生数据行
        if (result != null) {
            int index = 1;
            for (List<String> m : result) {
                row = sheet.createRow(index);
                int cellIndex = 0;
                for (String str : m) {
                    Cell cell = row.createCell((short) cellIndex);
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setWrapText(true);
                    cell.setCellStyle(cellStyle);
                    //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                    HSSFRichTextString cellText = new HSSFRichTextString(String.valueOf(str));
                    cell.setCellValue(String.valueOf(cellText));
                    cellIndex++;
                }
                index++;
            }
        }
    }


    public static byte[] getByteData(String file) throws Exception {
        InputStream ins = new FileInputStream(file);
        byte[] data = IOUtils.toByteArray(ins);
        return data;
    }

    /**
     * private 接口服务  不走CDN 无缓存
     *
     * @param fileTmpName
     * @param fileHSName
     * @return
     * @throws Exception
     */
//    public static boolean createAndUpdate(String fileTmpName, String fileHSName) throws Exception {
//
//        if (EnvUtil.isOfflineEnv()) {
//            //dev
//            HSClient.setCacheHost("10.13.132.175");
//            HSClient.setCachePort(19090);
//            HSClient.setHsserverHost("10.13.132.175");
//            HSClient.setHsserverPort(19090);
//        } else if (EnvUtil.isPreEnv()) {
//
//        } else {
//
//        }
//
//        HSClient hsClient = new HSClient(10000, 10000);
//        byte[] fileData = ExportExcelUtil.getByteData(fileTmpName);
//        HSObject hsHeadObject = hsClient.head("private", fileHSName);
//        if (!hsHeadObject.isSucc()) {
//            HSObject hsCreateObject = hsClient.create("private", fileHSName, fileData);
//            if (!hsCreateObject.isSucc()) {
//                logger.error("billDetailExcelCreateByShopCode hsCreate error {}", fileHSName);
//                return false;
//            }
//        } else {
//            HSObject hsUpdateObject = hsClient.update("private", fileHSName, fileData);
//            if (!hsUpdateObject.isSucc()) {
//                logger.error("billDetailExcelCreateByShopCode hsUpdate error {}", fileHSName);
//                return false;
//            }
//
//        }
//        return true;
//    }

}



