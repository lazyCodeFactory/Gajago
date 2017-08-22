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
				if(!"".equals(element.select("firstimage").text()) ) {
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
		}

		return trevelObjList;
	}

	public HashMap<String, Object> selectOne(String cateCode, String contentId) throws IOException {
		HashMap<String, Object> travelMap = new HashMap<String, Object>();
		StringBuilder queryUrlCommon = new StringBuilder();
		String innerTravelRegionDetailKey = KeyClass.INNER_TRAVEL_REGION_DETAIL;
		String innerTravelCourseInfo = KeyClass.INNER_TRAVEL_COURSE_INFO;
		String innerTravelIntroInfo = KeyClass.INNER_TRAVEL_INTRO_INFO;
		String innerTravelRoomImageInfo = KeyClass.INNER_TRAVEL_RE_INFO;
		
		String serviceKey = KeyClass.TRAVEL_API_KEY;
		queryUrlCommon.append(innerTravelRegionDetailKey);
		queryUrlCommon.append(serviceKey);
		queryUrlCommon.append("&contentTypeId=");
		queryUrlCommon.append(cateCode);
		queryUrlCommon.append("&contentId=");
		queryUrlCommon.append(contentId);
		queryUrlCommon.append("&MobileOS=ETC");
		queryUrlCommon.append("&MobileApp=TourAPI3.0_Guide");
		queryUrlCommon.append("&defaultYN=Y");
		queryUrlCommon.append("&firstImageYN=Y");
		queryUrlCommon.append("&areacodeYN=Y");
		queryUrlCommon.append("&catcodeYN=Y");
		queryUrlCommon.append("&addrinfoYN=Y");
		queryUrlCommon.append("&mapinfoYN=Y");
		queryUrlCommon.append("&overviewYN=Y");
		queryUrlCommon.append("&transGuideYN=Y");
		
		Document document = Jsoup.connect(queryUrlCommon.toString()).get();
		String errorCode = document.select("error_code").text();
		
		//일반 정보
		if ("".equals(errorCode) || null == errorCode) {
			Elements elements = document.select("item");
			for (Element element : elements) {
				travelMap.put("contentid", element.select("contentid").text());
				travelMap.put("contenttypeid", element.select("contenttypeid").text());
				travelMap.put("mapx", element.select("mapx").text());
				travelMap.put("mapy", element.select("mapy").text());
				travelMap.put("overview", element.select("overview").text());
				travelMap.put("homepage", element.select("homepage").text());
				travelMap.put("title", element.select("title").text());
				travelMap.put("addr1", element.select("addr1").text());
				travelMap.put("addr2", element.select("addr2").text());

			}
 		}
		
		//여행코스 추천일 경우에 
		if("25".equals(cateCode)) {
			StringBuilder queryUrlCourseInfo = new StringBuilder();

			queryUrlCourseInfo.append(innerTravelCourseInfo);
			queryUrlCourseInfo.append(serviceKey);
			queryUrlCourseInfo.append("&contentTypeId=");
			queryUrlCourseInfo.append(cateCode);
			queryUrlCourseInfo.append("&contentId=");
			queryUrlCourseInfo.append(contentId);
			queryUrlCourseInfo.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide");
			queryUrlCourseInfo.append("&listYN=Y");
			
			Document documentCourseInfo = Jsoup.connect(queryUrlCourseInfo.toString()).get();
			String errorCourseInfoCode = documentCourseInfo.select("error_code").text();

			if ("".equals(errorCourseInfoCode) || null == errorCourseInfoCode) {
				Elements elements = documentCourseInfo.select("item");
				List<String> subnameList = new ArrayList<String>();
				List<String> subdetailimgList = new ArrayList<String>();
				List<String> subdetailoverviewList = new ArrayList<String>();

				for (Element element : elements) {
					String subname = element.select("contentid").text();
					subnameList.add(subname);
			
					String subdetailimg = element.select("subdetailimg").text();
					subdetailimgList.add(subdetailimg);
			
					String subdetailoverview = element.select("subdetailimg").text();
					subdetailoverviewList.add(subdetailoverview);
					
				}
				
				travelMap.put("subnameList",subnameList);
				travelMap.put("subdetailimgList",subdetailimgList);
				travelMap.put("subdetailoverviewList",subdetailoverviewList);
			}
		
			
		//관광지일경우에	
		}else if("12".equals(cateCode) || "32".equals(cateCode) || "39".equals(cateCode)) {
			StringBuilder querytravelIntroInfo = new StringBuilder(); 

			querytravelIntroInfo.append(innerTravelIntroInfo);
			querytravelIntroInfo.append(serviceKey);
			querytravelIntroInfo.append("&contentTypeId=");
			querytravelIntroInfo.append(cateCode);
			querytravelIntroInfo.append("&contentId=");
			querytravelIntroInfo.append(contentId);
			querytravelIntroInfo.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&introYN=Y");
			
			Document documentTravelIntroInfo = Jsoup.connect(querytravelIntroInfo.toString()).get();
 			
			Elements elements = documentTravelIntroInfo.select("item");
		    if("12".equals(cateCode)) {
				for (Element element : elements) {
					travelMap.put("infocenter", element.select("infocenter").text());
					travelMap.put("parking", element.select("parking").text());
					travelMap.put("restdate", element.select("restdate").text());
					travelMap.put("chkcreditcard", element.select("chkcreditcard").text());
					travelMap.put("chkpet", element.select("chkpet").text());
				}
				
			}else if("32".equals(cateCode)) {
				for (Element element : elements) {
					travelMap.put("chkcooking", element.select("chkcooking").text());
					travelMap.put("infocenterlodging", element.select("infocenterlodging").text());
					travelMap.put("parkinglodging", element.select("parkinglodging").text());
					travelMap.put("reservationurl", element.select("reservationurl").text());
					travelMap.put("roomcount", element.select("roomcount").text());
					travelMap.put("roomtype", element.select("roomtype").text());
					travelMap.put("checkintime", element.select("checkintime").text());
					travelMap.put("checkouttime", element.select("checkouttime").text());
				}

			
			}else if("39".equals(cateCode)) {
				for (Element element : elements) {
					travelMap.put("treatmenu", element.select("treatmenu").text());
					travelMap.put("smoking", element.select("smoking").text());
					travelMap.put("seat", element.select("seat").text());
					travelMap.put("restdatefood", element.select("restdatefood").text());
					travelMap.put("reservationfood", element.select("reservationfood").text());
					travelMap.put("parkingfood", element.select("parkingfood").text());
					travelMap.put("opentimefood", element.select("opentimefood").text());
					travelMap.put("infocenterfood", element.select("infocenterfood").text());
					travelMap.put("firstmenu", element.select("firstmenu").text());
					travelMap.put("chkcreditcardfood", element.select("chkcreditcardfood").text());
					travelMap.put("kidsfacility", element.select("kidsfacility").text());
				}
			}
		    
		    //룸이미지 부분 추가
		    if("32".equals(cateCode)) {
		    	
				StringBuilder queryTravelRoomImageInfo = new StringBuilder(); 

				queryTravelRoomImageInfo.append(innerTravelRoomImageInfo);
				queryTravelRoomImageInfo.append(serviceKey);
				queryTravelRoomImageInfo.append("&contentTypeId=");
				queryTravelRoomImageInfo.append(cateCode);
				queryTravelRoomImageInfo.append("&contentId=");
				queryTravelRoomImageInfo.append(contentId);
				queryTravelRoomImageInfo.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&introYN=Y");
				queryTravelRoomImageInfo.append("&listYN=Y");
				Document documentTravelRoomImageInfo = Jsoup.connect(queryTravelRoomImageInfo.toString()).get();
				Elements imageElements = documentTravelRoomImageInfo.select("item");
				
				List<String> roomimgImgList = new ArrayList<String>();
				List<String> roomimgAltList = new ArrayList<String>();

				for(Element element : imageElements) {
					for(int i=1;i<5;i++) {
						roomimgImgList.add(element.select("roomimg"+i).text());
						roomimgAltList.add(element.select("roomimg"+i+"alt").text());
					}
				}
				travelMap.put("roomimgImgList", roomimgImgList);
				travelMap.put("roomimgAltList", roomimgAltList);
		    }else if("12".equals(cateCode)) {
		    	StringBuilder querytravelReInfo = new StringBuilder(); 
				querytravelReInfo.append(innerTravelIntroInfo);
				querytravelReInfo.append(serviceKey);
				querytravelReInfo.append("&contentTypeId=");
				querytravelReInfo.append(cateCode);
				querytravelReInfo.append("&contentId=");
				querytravelReInfo.append(contentId);
				querytravelReInfo.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&introYN=Y");
				
				Document documentTravelReInfo = Jsoup.connect(querytravelReInfo.toString()).get();
 				
				Elements elementsReInfo = documentTravelReInfo.select("item");
				List<String> infonameList = new ArrayList<String>();
				List<String> infotextList = new ArrayList<String>();
			 
				for(Element element : elementsReInfo) {
				String 	infoname = element.select("infoname").text();
				String 	infotext = element.select("infotext").text();
					infonameList.add(infoname);
					infotextList.add(infotext);
				}
				travelMap.put("infonameList", infonameList);
				travelMap.put("infotextList", infotextList);	 
		//음식점인 경우
		   }else if("39".equals(cateCode)){
			   
			   StringBuilder querytravelCMenuImgInfo = new StringBuilder(); 
			   querytravelCMenuImgInfo.append(innerTravelIntroInfo);
			   querytravelCMenuImgInfo.append(serviceKey);
			   querytravelCMenuImgInfo.append("&contentTypeId=");
			   querytravelCMenuImgInfo.append(cateCode);
			   querytravelCMenuImgInfo.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide");
			   querytravelCMenuImgInfo.append("&contentId=");
			   querytravelCMenuImgInfo.append(contentId);
			   querytravelCMenuImgInfo.append("&imageYN=N");
			   
			   
				Document documentTravelCMenuImgInfo = Jsoup.connect(querytravelCMenuImgInfo.toString()).get();
 				
				Elements elementsReInfo = documentTravelCMenuImgInfo.select("item");
				List<String> imgnameList= new ArrayList<String>();
				List<String> originimgurlList= new ArrayList<String>();
				List<String> smallimageurlList= new ArrayList<String>();
				
				
				for(Element element : elementsReInfo) {
					String imgname =element.select("imgname").text();
					String originimgurl =element.select("originimgurl").text();
					String smallimageurl =element.select("smallimageurl").text();
					imgnameList.add(imgname);
					originimgurlList.add(originimgurl);
					smallimageurlList.add(smallimageurl);
					
				}
				travelMap.put("imgnameList", imgnameList);
				travelMap.put("originimgurlList", originimgurlList);
				travelMap.put("smallimageurlList", smallimageurlList);
				
		   }
		    
		    
		    //숙박,관광지,음식점 다 추가이미지가 있고 아래는 그부분
			StringBuilder querytravelImageListStr = new StringBuilder(); 
			String innerTravelListUrl = KeyClass.INNER_TRAVEL_ADD_IMAGE;
			querytravelImageListStr.append(innerTravelListUrl);
			querytravelImageListStr.append(serviceKey);
			querytravelImageListStr.append("&contentTypeId=");
			querytravelImageListStr.append(cateCode);
			querytravelImageListStr.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&introYN=Y");
			querytravelImageListStr.append("&contentId=");
			querytravelImageListStr.append(contentId);
			querytravelImageListStr.append("&imageYN=Y");
		
			Document documentTravelAddList = Jsoup.connect(querytravelImageListStr.toString()).get();
			Elements elementsAddImage = documentTravelAddList.select("item");
			List<String> originimgurlList = new ArrayList<String>();
			List<String> smallimageurlList = new ArrayList<String>();

			for(Element element : elementsAddImage) {
				String originimgurl = element.select("originimgurl").text();
				String smallimageurl = element.select("smallimageurl").text();
				originimgurlList.add(originimgurl); 
				smallimageurlList.add(smallimageurl);
			}
			
			travelMap.put("originimgurlList", originimgurlList);
			travelMap.put("smallimageurlList", smallimageurlList);
 			
		}
		
		return travelMap;
	}

}
