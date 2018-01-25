package com.yht.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelUtil {
	/**
	 * 通用解析xls格式文件。解析后组装成二维字符数组，每行的列数必须一致。
	 * @param filePath
	 * @param colNum
	 * @return
	 * @throws Exception
	 */
	public static String[][] parse(String filePath, int colNum) throws Exception {
		try {
			Workbook book = Workbook.getWorkbook(new File(filePath));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			int rowNum = sheet.getRows();
			// 创建二维数组
			String[][] data = new String[rowNum][colNum];
			Cell[] cells = null;
			for (int i = 0; i < rowNum; i++) {
				cells = sheet.getRow(i);
				for (int j = 0; j < colNum; j++) {
					if (CellType.DATE.equals(cells[j].getType())) {
						DateCell date = (DateCell) cells[j];
						data[i][j] = format(date.getDate(), "yyyyMMdd");
					} else {
						data[i][j] = cells[j].getContents();
					}
				}
			}
			book.close();
			return data;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 使用参数Format格式化Date成字符串
	 */
	public static String format(Date date, String pattern) {
		return date == null ? "" : new SimpleDateFormat(pattern).format(date);
	}
	
	/**
	 * 提取上传方法为公共方法
	 * 
	 * @param uploadDir
	 *            上传文件目录
	 * @param file
	 *            上传对象
	 * @throws Exception
	 */
	public static String executeUpload(String uploadDir, MultipartFile file) throws Exception {
		// 文件后缀名
		String suffix = file.getOriginalFilename();
		// 上传文件名
		String filename = UtilDate.getFileNum() + suffix;
		// 服务器端保存的文件对象
		File serverFile = new File(uploadDir + filename);
		// 将上传的文件写入到服务器端文件内
		file.transferTo(serverFile);
		return filename;
	}
	
}
