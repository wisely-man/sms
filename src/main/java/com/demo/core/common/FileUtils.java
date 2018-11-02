package com.demo.core.common;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

/**
 * FileUtils
 * 
 * @version 1.0.0
 */
public class FileUtils {

	/**
	 * 导出EXCEL文件
	 * PARAMETER: 
	 * Map<String, Object>
	 * key:filePath ; value:String(文件路径)
	 * key:tempPath ; value:String(模板路径:option)
	 * key:sheetName; value:String(表单名:option)
	 * key:startRowNum; value:int(报表起始行:option)
	 * key:dataTitle; value:List<List<String>>(标题列表:option)
	 * key:dataBody ; value:List<List<String>>(数据列表)
	 */
	public static String exportExcel(Map<String, Object> dataMap) throws Exception {
		// 创建Workbook
		HSSFWorkbook workbook;
		// 有模板
		if (null != dataMap.get("tempPath")) {
			try {
				// excel模板路径
				File template = new File((String) dataMap.get("tempPath"));
				POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(template));
				// 读取excel模板
				workbook = new HSSFWorkbook(fs);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("exportExcel---Excel导出出错：" + e.getMessage());
			}
		}
		// 没有模板
		else {
			workbook = new HSSFWorkbook();
		}
		
		try {
			// 创建Sheet
			createSheet(workbook, dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("exportExcel---Excel导出出错：" + e.getMessage());
		}
		
		FileOutputStream fileOut = null;
		// 文件路径
		String filePath = (String) dataMap.get("filePath");
		if (StringUtils.isEmpty(filePath)) {
			throw new Exception("exportExcel---Excel导出出错：" + "无效文件路径！");
		}
		try {
			fileOut = new FileOutputStream(filePath);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			fileOut.close();
			e.printStackTrace();
			throw new Exception("exportExcel---Excel导出出错：" + e.getMessage());
		}
		return filePath;
	}

	@SuppressWarnings("unchecked")
	private static void createSheet(HSSFWorkbook workbook, Map<String, Object> dataMap) throws Exception {
		// 创建表单
		HSSFSheet sheet = null;
		// 有模板
		if (null != dataMap.get("tempPath")) {
			sheet = workbook.getSheetAt(0);
		}
		// 没有模板
		else {
			// 表单名
			String sheetName = "sheet1";
			if (null != dataMap.get("sheetName")) {
				sheetName = (String) dataMap.get("sheetName");
			}
			// 创建表单
			sheet = workbook.createSheet(sheetName);
		}
		// 设置表头居中
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 12);
		// 标题样式
		HSSFCellStyle styleHeader = workbook.createCellStyle();
		styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		styleHeader.setFont(font);
		styleHeader.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		styleHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styleHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
		styleHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styleHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		styleHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 数据样式
		HSSFCellStyle styleBody = workbook.createCellStyle();
		styleBody.setBorderTop(HSSFCellStyle.BORDER_THIN);
		styleBody.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styleBody.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		styleBody.setBorderRight(HSSFCellStyle.BORDER_THIN);
		styleBody.setWrapText(true);
		// 创建表格
		HSSFRow row = null;
		// 创建行列
		HSSFCell cell = null;
		// 标题行数
		int titleRowNum = 0;
		// 起始行
		int startRowNum = 0;
		if (null != dataMap.get("startRowNum")) {
			startRowNum = (Integer) dataMap.get("startRowNum") - 1;
		}
		// 标题
		List<List<String>> dataTitle = (List<List<String>>) dataMap.get("dataTitle");
		if (dataTitle != null && dataTitle.size() > 0) {
			titleRowNum = dataTitle.size();
			for (int i = 0; i < dataTitle.size(); i++) {
				row = sheet.createRow(i + startRowNum);
				for (int j = 0; j < dataTitle.get(i).size(); j++) {
					cell = row.createCell(j);
					cell.setCellValue(dataTitle.get(i).get(j));
					cell.setCellStyle(styleHeader);
					sheet.setColumnWidth(j, 25*256);
				}
			}
		}
		// 数据
		List<List<String>> dataBody = (List<List<String>>) dataMap.get("dataBody");
		if (dataBody != null && dataBody.size() > 0) {
			for (int i = 0; i < dataBody.size(); i++) {
				row = sheet.createRow(i + titleRowNum + startRowNum);
				if (dataBody.get(i) != null && dataBody.get(i).size() > 0) {
					for (int j = 0; j < dataBody.get(i).size(); j++) {
						cell = row.createCell(j);
						cell.setCellValue(dataBody.get(i).get(j));
						cell.setCellStyle(styleBody);
					}
				}
			}
		}
	}
}
