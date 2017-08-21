package com.Gajago.com.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.Gajago.com.util.KeyClass;

@Service
public class InnerTravelService {

	public List<HashMap<String, Object>> selectList(String areacode, String cateCode) throws IOException {
		StringBuilder queryUrl = new StringBuilder();
		String innerTravelRegionInfoListKey = KeyClass.INNER_TRAVEL_REGION_INFO_LIST;
		String serviceKey = KeyClass.TRAVEL_API_KEY;
		String areaCode = areacode;
		queryUrl.append(innerTravelRegionInfoListKey);
		queryUrl.append(serviceKey);
		queryUrl.append("&query=");
		queryUrl.append("&contentTypeId=");
		queryUrl.append(cateCode);
		queryUrl.append("&areaCode=");
		queryUrl.append(areaCode);
		queryUrl.append("&sigunguCode=");
		queryUrl.append("&cat1=");
		queryUrl.append("&cat2=");
		queryUrl.append("&cat3=");
		queryUrl.append("&listYN=Y");
		queryUrl.append("&MobileOS=ETC");
		queryUrl.append("&MobileApp=TourAPI3.0_Guide");
		queryUrl.append("&arrange=A");
		// &numOfRows=12&pageNo=1

		Document document = Jsoup.connect(queryUrl.toString()).get();

		List<HashMap<String, Object>> trevelObjList = new ArrayList<HashMap<String, Object>>();
		String errorCode = document.select("error_code").text();
		if ("".equals(errorCode) || null == errorCode) {
			Elements elements = document.select("item");
			for (Element element : elements) {
				HashMap<String, Object> elementMap = new HashMap<String, Object>();
				elementMap.put("areacode", element.select("areacode").text());
				elementMap.put("cat1", element.select("cat1").text());
				elementMap.put("cat2", element.select("cat2").text());
				elementMap.put("cat3", element.select("cat3").text());
				elementMap.put("contentid", element.select("contentid").text());
				elementMap.put("contenttypeid", element.select("contenttypeid").text());
				elementMap.put("createdtime", element.select("createdtime").text());
				elementMap.put("firstimage", element.select("firstimage").text());
				elementMap.put("firstimage2", element.select("firstimage2").text());
				elementMap.put("mapx", element.select("mapx").text());
				elementMap.put("mapy", element.select("mapy").text());
				elementMap.put("mlevel", element.select("mlevel").text());
				elementMap.put("sigungucode", element.select("sigungucode").text());
				elementMap.put("title", element.select("title").text());
				trevelObjList.add(elementMap);
			}
		}

		return trevelObjList;
	}

}
