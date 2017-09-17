package com.Gajago.com.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.Gajago.com.vo.itemMarketBoardVo;

public class FileUploader {

	public static HashMap<String,Object> fileUpload(MultipartHttpServletRequest mRequest) {
		HashMap<String,Object> retCheck = new HashMap<String,Object>();
		String root_path = mRequest.getSession().getServletContext().getRealPath("/");
		String attach_path = "resources/upload/";
		String realPath = root_path + attach_path;
		String realFile = "";
		File dir = new File(realPath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		MultipartHttpServletRequest multi = mRequest;
		Iterator<String> iter = multi.getFileNames();
		String saveFileName = "";
		while (iter.hasNext()) {
			String uploadFileName = iter.next();
			MultipartFile mFile = multi.getFile(uploadFileName);
			String originalFileName = mFile.getOriginalFilename();
			saveFileName = originalFileName;

			if (saveFileName != null && !saveFileName.equals("")) {
				if (new File(realPath + saveFileName).exists()) {
					saveFileName =System.currentTimeMillis() + "_" + saveFileName ;
				}
				try {
					realFile = realPath + saveFileName;
					mFile.transferTo(new File(realFile));
					retCheck.put("uploadSign", "Y");
					retCheck.put("uploadFile", saveFileName);
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
					retCheck.put("uploadSign", "N");
					retCheck.put("uploadFile", "Fail");
					
				} catch (IOException e) {
					e.printStackTrace();
					retCheck.put("uploadSign", "N");
					retCheck.put("uploadFile", "Fail");

				}

			} // if end

		} // while end
		return retCheck;
	} // fileUpload end

}
