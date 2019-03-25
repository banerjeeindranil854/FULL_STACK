package com.hackfse.fdbck.mgmt.systm.XL.XlWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfse.fdbck.mgmt.systm.XL.model.FeedbackResponse;
import com.hackfse.fdbck.mgmt.systm.res.vo.OutReachStatusRspVo;
import com.hackfse.fdbck.mgmt.systm.svc.impl.EvtSvcImpl;

@Service
public class ExcelWriter {
	private static String[] columns = { "EVENT_ID", "EMP_ID", "RATING", "DESCRIPTION" };
	@Autowired
	EvtSvcImpl evtSvcImpl;

	public List<FeedbackResponse> getAllFeedBackResponse() {
		List<FeedbackResponse> feedbackResponses = new ArrayList<>();
		for (OutReachStatusRspVo outReachStatusRspVo : evtSvcImpl.getFedbacks()) {
			FeedbackResponse feedbackResponse = new FeedbackResponse(outReachStatusRspVo.getEventId(),
					outReachStatusRspVo.getEmpId(), outReachStatusRspVo.getRating(),
					outReachStatusRspVo.getDescription());
			feedbackResponses.add(feedbackResponse);
		}
		return feedbackResponses;
	}
	public String createXlSheet(String path) throws IOException {
		Workbook workbook = new XSSFWorkbook(); 
		Sheet sheet = workbook.createSheet("FEED_BACK");
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
        for(FeedbackResponse feedbackResponse :getAllFeedBackResponse()) {
        	Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(feedbackResponse.getEventId());

            row.createCell(1)
                    .setCellValue(feedbackResponse.getEmpId());
            
            row.createCell(2)
            .setCellValue(feedbackResponse.getRating());
            
            row.createCell(3)
            .setCellValue(feedbackResponse.getDescription());
        }
        
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        FileOutputStream fileOut = new FileOutputStream(path+"/FEED_BACK_RESPONSE.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        return path+"/FEED_BACK_RESPONSE.xlsx";
	}
}
