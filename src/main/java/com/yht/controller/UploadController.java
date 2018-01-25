package com.yht.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.yht.WebSecurityConfig;
import com.yht.service.UploadService;
import com.yht.util.ExcelUtil;

@Controller
public class UploadController {

	/**
	 * @param file 前台上传的文件对象
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, MultipartFile file, Map<String, Object> map) {
		try {
			// 上传目录地址
			String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
			//String uploadDir = "/home/weblogic/workspace//upload/";
			// 如果目录不存在，自动创建文件夹
			File dir = new File(uploadDir);
			if (!dir.exists()) {
				dir.mkdir();
			}
			// 调用上传方法
			String filename = ExcelUtil.executeUpload(uploadDir, file);
			// 获取文件路径
			String filepath = uploadDir + filename;
			List<String> resultList = UploadService.xlsSett(filepath);
			map.put("num", resultList.size());
			map.put("resultList", resultList);
			for(int i=0;i<resultList.size();i++){
				map.put("result"+i, "解析结果结果：" + resultList.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "处理异常");
			return "forms";
		}
		return "forms";
	}

	@RequestMapping("/*")
	public String all(HttpServletRequest request, HttpSession session) {

		Object verify = session.getAttribute(WebSecurityConfig.SESSION_KEY);
		if (verify != null) {
			return request.getServletPath().toString();
		} else {
			return "redirect:/login";
		}
	}

}
