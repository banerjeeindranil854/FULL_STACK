package com.hackfse.fdbck.mgmt.systm.XL.XlWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfse.fdbck.mgmt.systm.XL.model.ReportFormat;
import com.hackfse.fdbck.mgmt.systm.svc.impl.EvtSvcImpl;

@Service
public class ReportXlWritter {
	private static String[] columns = { "EVENT_ID", "EMP_ID", "BASE_LOCATION", "PROJECT" };
	@Autowired
	EvtSvcImpl evtSvcImpl;

	
	public String createXlSheet(String path,List<ReportFormat> reportFormat,String type) throws IOException {
		Workbook workbook = new XSSFWorkbook(); 
		Sheet sheet = workbook.createSheet("REPORT");
		Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
            int rowNum = 1;
        for(ReportFormat Format :reportFormat) {
        	Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(Format.getEventId());

            row.createCell(1)
                    .setCellValue(Format.getEmpId());
            
            row.createCell(2)
            .setCellValue(Format.getBaseLocation());
            
            row.createCell(3)
            .setCellValue(Format.getProject());
        }
        
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream fileOut = new FileOutputStream(path+"/"+type+"_REPORT.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        return path+"/"+type+"_REPORT.xlsx";
	}
}
