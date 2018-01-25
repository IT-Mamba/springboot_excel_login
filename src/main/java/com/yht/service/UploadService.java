package com.yht.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yht.util.ExcelUtil;

@Service
public class UploadService {

	public static List<String> xlsSett(String filepath) throws Exception {
		String msg = "";
		int colNum = 5;
		// 解析文件内容
		List<String> resultList = new ArrayList<String>();
        String[][] data = ExcelUtil.parse(filepath, colNum);
        System.out.println(data.length);
        //此处可对data数据进行使用
        
        msg ="返回结果大小" +  resultList.size() ;
        System.out.println(msg);
		return resultList;
	}

}
