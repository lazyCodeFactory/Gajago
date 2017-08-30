package com.Gajago.com.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gajago.com.dao.InnerTravelDao;
import com.Gajago.com.util.KeyClass;
import com.Gajago.com.vo.innerQnAcomunityVo;

@Service
public class InnerTravelService {
	@Autowired  
	InnerTravelDao dao;
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
		String innerTravelRegionDetailKey = KeyClass.INNER_TRAVEL_REGION_DETAIL;
		String innerTravelCourseInfo = KeyClass.INNER_TRAVEL_INTRO_INFO;
		String serviceKey = KeyClass.TRAVEL_API_KEY;
		String reInfp = KeyClass.INNER_TRAVEL_RE_INFO;
		StringBuilder queryUrlCommon = new StringBuilder();
		System.out.println("분류코드"+cateCode);
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
 		
/////////////////////////////////공통 정보 부분//////////////////////////////////////////////////
 			Elements elements = document.select("item");
			for (Element element : elements) {
				travelMap.put("contentid", element.select("contentid").text());
				travelMap.put("contenttypeid", element.select("contenttypeid").text());
				travelMap.put("mapx", element.select("mapx").text());
				travelMap.put("mapy", element.select("mapy").text());
				travelMap.put("overview", element.select("overview").text().trim());
				travelMap.put("homepage", element.select("homepage").text().trim());
				travelMap.put("title", element.select("title").text().trim());
				travelMap.put("addr1", element.select("addr1").text().trim());
				travelMap.put("addr2", element.select("addr2").text().trim());
				travelMap.put("firstimage", element.select("firstimage").text().trim());
				travelMap.put("zipcode", element.select("zipcode").text().trim());
				
				
			}
 	 
		
///////////////////////////소개정보/////////////////////////////////////////////////////////////////////////////////////
			
				StringBuilder queryUrlTravelInfo = new StringBuilder();
	
				queryUrlTravelInfo.append(innerTravelCourseInfo);
				queryUrlTravelInfo.append(serviceKey);
				queryUrlTravelInfo.append("&contentTypeId=");
				queryUrlTravelInfo.append(cateCode);
				queryUrlTravelInfo.append("&contentId=");
				queryUrlTravelInfo.append(contentId);
				queryUrlTravelInfo.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide");
				queryUrlTravelInfo.append("&introYN=Y");
				
				Document documentTravelInfo = Jsoup.connect(queryUrlTravelInfo.toString()).get();
 				Elements elementsTravelInfo = documentTravelInfo.select("item");
 				//코스  소개정보	
 				if("25".equals(cateCode)) {
	  				for (Element element : elementsTravelInfo) {
						travelMap.put("distance",element.select("distance").text().trim());
						travelMap.put("taketime",element.select("taketime").text().trim());

	  				}
 				}
 				//여행지  소개정보	
 				else if("12".equals(cateCode)) {
	  				for (Element element : elementsTravelInfo) {
						String expguide = element.select("expguide").text().trim();
						String restdate = element.select("restdate").text().trim();
						String chkbabycarriage = element.select("chkbabycarriage").text().trim();
						String chkcreditcard = element.select("chkcreditcard").text().trim();
						String chkpet = element.select("chkpet").text().trim();
						String infocenter = element.select("infocenter").text().trim();
						String usetime = element.select("usetime").text().trim();
 						
						travelMap.put("expguide",expguide);
						travelMap.put("restdate",restdate);
						travelMap.put("chkbabycarriage",chkbabycarriage);
						travelMap.put("chkcreditcard",chkcreditcard);
						travelMap.put("chkpet",chkpet);
						travelMap.put("infocenter",infocenter);
						travelMap.put("usetime",usetime);

	  				}
	  			//레포츠 소개정보
	  			}else if("28".equals(cateCode)) {
	  				for (Element element : elementsTravelInfo) {
		  				String chkbabycarriageleports = element.select("chkbabycarriageleports").text().trim();
						String chkcreditcardleports = element.select("chkcreditcardleports").text().trim();
						String chkpetleports = element.select("chkpetleports").text().trim();
						String expagerangeleports = element.select("expagerangeleports").text().trim();
						String infocenterleports = element.select("infocenterleports").text().trim();
						String parkingleports = element.select("parkingleports").text().trim();
						String reservation = element.select("reservation").text().trim();
						String restdateleports = element.select("restdateleports").text().trim();
						String scaleleports = element.select("scaleleports").text().trim();
						String usetimeleports = element.select("usetimeleports").text().trim();
						 
						
						travelMap.put("chkbabycarriageleports",chkbabycarriageleports);
						travelMap.put("chkcreditcardleports",chkcreditcardleports);
						travelMap.put("chkpetleports",chkpetleports);
						travelMap.put("expagerangeleports",expagerangeleports);
						travelMap.put("infocenterleports",infocenterleports);
						travelMap.put("parkingleports",parkingleports);
						travelMap.put("reservation",reservation);
						travelMap.put("restdateleports",restdateleports);
						travelMap.put("scaleleports",scaleleports);
						travelMap.put("usetimeleports",usetimeleports);
 						
	  				}
	  			}
 				//숙박 소개정보
	  			else if("32".equals(cateCode)) {
	  				for (Element element : elementsTravelInfo) {
						String checkintime = element.select("checkintime").text().trim();
						String checkouttime = element.select("checkouttime").text().trim();
						String chkcooking = element.select("chkcooking").text().trim();
						String foodplace = element.select("foodplace").text().trim();
						String infocenterlodging = element.select("infocenterlodging").text().trim();
						String reservationlodging = element.select("reservationlodging").text().trim();
						String reservationurl = element.select("reservationurl").text().trim();
						String roomcount = element.select("roomcount").text().trim();
						String roomtype = element.select("roomtype").text().trim();
						String sauna = element.select("sauna").text().trim();
						String seminar = element.select("seminar").text().trim();
						String sports = element.select("sports").text().trim();

						travelMap.put("checkintime",checkintime);
						travelMap.put("checkouttime",checkouttime);
						travelMap.put("chkcooking",chkcooking);
						travelMap.put("foodplace",foodplace);
						travelMap.put("infocenterlodging",infocenterlodging);
						travelMap.put("reservationlodging",reservationlodging);
						travelMap.put("reservationurl",reservationurl);
						travelMap.put("roomcount",roomcount);
						travelMap.put("roomtype",roomtype);
						travelMap.put("sauna",sauna);
						travelMap.put("seminar",seminar);
						travelMap.put("sports",sports);
						 
	  				}
	  			
	  			
	  			}
	  			//음식점 소개정보
	  			else if("39".equals(cateCode)) {
	  				for (Element element : elementsTravelInfo) {
						travelMap.put("treatmenu", element.select("treatmenu").text().trim());
						travelMap.put("smoking", element.select("smoking").text().trim());
						travelMap.put("seat", element.select("seat").text().trim());
						travelMap.put("restdatefood", element.select("restdatefood").text().trim());
						travelMap.put("reservationfood", element.select("reservationfood").text().trim());
						travelMap.put("parkingfood", element.select("parkingfood").text().trim());
						travelMap.put("opentimefood", element.select("opentimefood").text().trim());
						travelMap.put("infocenterfood", element.select("infocenterfood").text().trim());
						travelMap.put("firstmenu", element.select("firstmenu").text().trim());
						travelMap.put("chkcreditcardfood", element.select("chkcreditcardfood").text().trim());
						travelMap.put("kidsfacility", element.select("kidsfacility").text().trim());
					}
	  			}
 			//////반복정보////////// 				
 				StringBuilder queryUrlreInfo = new StringBuilder();
 				queryUrlreInfo.append(reInfp);
 				queryUrlreInfo.append(serviceKey);
 				queryUrlreInfo.append("&contentTypeId=");
 				queryUrlreInfo.append(cateCode);
 				queryUrlreInfo.append("&contentId=");
 				queryUrlreInfo.append(contentId);
 				queryUrlreInfo.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&listYN=Y");

 				Document documentUrlReInfo = Jsoup.connect(queryUrlreInfo.toString()).get();
 				Elements elementsTravelReInfo = documentUrlReInfo.select("item");
			
  			if("28".equals(cateCode) || "12".equals(cateCode) || "39".equals(cateCode)) {
 				List<String> infonameList= new ArrayList<String>();
 				List<String> infotextList= new ArrayList<String>();

 				for (Element element : elementsTravelReInfo) {
					infonameList.add(element.select("infoname").text().trim());
					infotextList.add(element.select("infotext").text().trim());
 				}
 				travelMap.put("infotextList", infotextList);
 				travelMap.put("infonameList", infonameList);
 			} 

///////////////////////////아에 다른 부분/////////////////////////////////////////////////////////////////////////////////////
		
		//코스부분 ,코스정보
 		 if("25".equals(cateCode)) {
 		    String  courseInfoKey = KeyClass.INNER_TRAVEL_COURSE_INFO;
 		    StringBuilder queryTravelCourseInfo = new StringBuilder();
 		
	 		queryTravelCourseInfo.append(courseInfoKey);
	 		queryTravelCourseInfo.append(serviceKey);
	 		queryTravelCourseInfo.append("&contentTypeId=");
	 		queryTravelCourseInfo.append(cateCode);
	 		queryTravelCourseInfo.append("&contentId=");
	 		queryTravelCourseInfo.append(contentId);
	 		queryTravelCourseInfo.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide");
	 		queryTravelCourseInfo.append("&listYN=Y");
	
			Document documentTravelCourseInfo = Jsoup.connect(queryTravelCourseInfo.toString()).get();
			Elements elementsTravelCourseInfo = documentTravelCourseInfo.select("item");
			List<String> subdetailimgList = new ArrayList<String>();
			List<String> subdetailoverviewList = new ArrayList<String>();
			List<String> subnameList = new ArrayList<String>();
	
	 		for (Element element : elementsTravelCourseInfo) {
				String subdetailimg = element.select("subdetailimg").text().trim();
				String subdetailoverview = element.select("subdetailoverview").text().trim();
				String subname = element.select("subname").text().trim();
				subdetailimgList.add(subdetailimg);
				subdetailoverviewList.add(subdetailoverview);
				subnameList.add(subname);
			}
	 		
	 		travelMap.put("subdetailimgList", subdetailimgList);
			travelMap.put("subdetailoverviewList",subdetailoverviewList);
			travelMap.put("subnameList",subnameList);
	  		
 		
 		 //관광지 레포츠,추가이미지	 
 		 }else if("12".equals(cateCode) || "28".equals(cateCode) || "39".equals(cateCode)) {
 			
 			 
 			String  addImageKey = KeyClass.INNER_TRAVEL_ADD_IMAGE;
 		    StringBuilder queryTravelImageInfo = new StringBuilder();
 		
 		    queryTravelImageInfo.append(addImageKey);
 		   	queryTravelImageInfo.append(serviceKey);
 		   	queryTravelImageInfo.append("&contentTypeId=");
	 		queryTravelImageInfo.append(cateCode);
	 		queryTravelImageInfo.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide");
	 		queryTravelImageInfo.append("&contentId=");
	 		queryTravelImageInfo.append(contentId);
	 		queryTravelImageInfo.append("&imageYN=Y");
 			 
	 		Document documentTravelImageInfo = Jsoup.connect(queryTravelImageInfo.toString()).get();
			Elements elementsTravelImageInfo = documentTravelImageInfo.select("item");
 			List<String> originimgurlList = new ArrayList<String>();
 			List<String> smallimageurlList = new ArrayList<String>();
 			
	 		for (Element element : elementsTravelImageInfo) {
	 			String originimgurl = element.select("originimgurl").text().trim();
				String smallimageurl = element.select("smallimageurl").text().trim();
 	 		
				originimgurlList.add(originimgurl);
				smallimageurlList.add(smallimageurl);
	 		}
	 		
	 		travelMap.put("originimgurlList", originimgurlList);
			travelMap.put("smallimageurlList",smallimageurlList);
	 		
			 
 		  //숙박은 룸이미지만 있음 	 
 		 }else if("32".equals(cateCode)) {
 		    String  courseInfoKey = KeyClass.INNER_TRAVEL_COURSE_INFO;
 		    StringBuilder queryTravelRoomImage = new StringBuilder();
 		
 		    queryTravelRoomImage.append(courseInfoKey);
 		   	queryTravelRoomImage.append(serviceKey);
 		  	queryTravelRoomImage.append("&contentTypeId=");
	 		queryTravelRoomImage.append(cateCode);
	 		queryTravelRoomImage.append("&contentId=");
	 		queryTravelRoomImage.append(contentId);
	 		queryTravelRoomImage.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide");
	 		queryTravelRoomImage.append("&listYN=Y");
 			 
	 		
	 		Document documentRoomImageInfo = Jsoup.connect(queryTravelRoomImage.toString()).get();
			Elements elementsRoomImageInfo = documentRoomImageInfo.select("item");
	 		List<String> titleList = new ArrayList<String>();
	 		List<String> roomairconditionList = new ArrayList<String>();
	 		List<String> roombasecountList = new ArrayList<String>();
	 		List<String> roombathList = new ArrayList<String>();
	 		List<String> roomcookList = new ArrayList<String>();
	 		List<String> roomhairdryerList = new ArrayList<String>();
	 		List<String> roomoffseasonminfee1List = new ArrayList<String>();
	 		List<String> roomoffseasonminfee2List = new ArrayList<String>();
	 		List<String> roompeakseasonminfee1List = new ArrayList<String>();
	 		List<String> roompeakseasonminfee2List = new ArrayList<String>();
	 		List<String> roomrefrigeratorList = new ArrayList<String>();
	 		List<String> roomsize1List = new ArrayList<String>();
	 		List<String> roomsize2List = new ArrayList<String>();
	 		List<String> roomtitleList = new ArrayList<String>();
	 		List<String> roomtvList = new ArrayList<String>();
	 		List<String> roomimg1List = new ArrayList<String>();
	 		List<String> roomcountList = new ArrayList<String>();
	 		
	 		
	 		
	 		
 			for(Element element : elementsRoomImageInfo) {
 				String roomaircondition = element.select("roomaircondition").text().trim();
 				String roombasecount = element.select("roombasecount").text().trim();
				String roombath = element.select("roombath").text().trim();
				String roomcook = element.select("roomcook").text().trim();
				String roomcount = element.select("roomcount").text().trim();
				String roomhairdryer = element.select("roomhairdryer").text().trim();
				String roomoffseasonminfee1 = element.select("roomoffseasonminfee1").text().trim();
				String roomoffseasonminfee2 = element.select("roomoffseasonminfee2").text().trim();
				String roompeakseasonminfee1 = element.select("roompeakseasonminfee1").text().trim();
				String roompeakseasonminfee2 = element.select("roompeakseasonminfee2").text().trim();
				String roomrefrigerator = element.select("roomrefrigerator").text().trim();
				String roomsize1 = element.select("roomsize1").text().trim();
				String roomsize2 = element.select("roomsize2").text().trim();
				String roomtitle = element.select("roomtitle").text().trim();
				String roomtv = element.select("roomtv").text().trim();
				String roomimg1 = element.select("roomimg1").text().trim();

				

				roomairconditionList.add(roomaircondition);
				roombasecountList.add(roombasecount);
				roombathList.add(roombath);
				roomcookList.add(roomcook);
				roomcountList.add(roomcount);
				roomhairdryerList.add(roomhairdryer);
				roomoffseasonminfee1List.add(roomoffseasonminfee1);
				roomoffseasonminfee2List.add(roomoffseasonminfee2);
				roompeakseasonminfee1List.add(roompeakseasonminfee1);
				roompeakseasonminfee2List.add(roompeakseasonminfee2);
				roomrefrigeratorList.add(roomrefrigerator);
				roomsize1List.add(roomsize1);
				roomsize2List.add(roomsize2);
				roomtitleList.add(roomtitle);
				roomtvList.add(roomtv);
				roomimg1List.add(roomimg1);
				titleList.add(roomtitle);
				
 			}
 			travelMap.put("roomimg1List", roomimg1List);
 			travelMap.put("titleList", titleList);
			travelMap.put("roomairconditionList", roomairconditionList);
	 		travelMap.put("roombasecountList", roombasecountList);
	 		travelMap.put("roombathList", roombathList);
	 		travelMap.put("roomcookList", roomcookList);
	 		travelMap.put("roomcountList", roomcountList);
	 		travelMap.put("roomhairdryerList", roomhairdryerList);
	 		travelMap.put("roomoffseasonminfee1List", roomoffseasonminfee1List);
	 		travelMap.put("roomoffseasonminfee2List", roomoffseasonminfee2List);
	 		travelMap.put("roompeakseasonminfee1List", roompeakseasonminfee1List);
	 		travelMap.put("roompeakseasonminfee2List", roompeakseasonminfee2List);
	 		travelMap.put("roomrefrigeratorList", roomrefrigeratorList);
	 		travelMap.put("roomsize1List", roomsize1List);
	 		travelMap.put("roomsize2List", roomsize2List);
	 		travelMap.put("roomtitleList", roomtitleList);
	 		travelMap.put("roomtvList", roomtvList);

 			
 		 }
 		 //음식점은 메뉴이미지도 받자	 
 		 if("39".equals(cateCode)) {
 			 String menuImageKey = KeyClass.INNER_TRAVEL_ADD_IMAGE;
  		     StringBuilder queryTravelMenuImage = new StringBuilder();
  	 		
  		    queryTravelMenuImage.append(menuImageKey);
  		    queryTravelMenuImage.append(serviceKey);
	  		queryTravelMenuImage.append("&contentTypeId=");
	  		queryTravelMenuImage.append(cateCode);
	  		queryTravelMenuImage.append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide");
	  		queryTravelMenuImage.append("&contentId=");
	  		queryTravelMenuImage.append(contentId);
	  		queryTravelMenuImage.append("&imageYN=N");
	  		
	  		Document documentMenuImageInfo = Jsoup.connect(queryTravelMenuImage.toString()).get();
			Elements elementsMenuImageInfo = documentMenuImageInfo.select("item");
			List<String> menuImgnameList  = new ArrayList<String>();
			List<String> menuoriginimgurlList  = new ArrayList<String>();
			List<String> menusmallimageurlList  = new ArrayList<String>();

 			for(Element element : elementsMenuImageInfo) {
 				menuImgnameList.add(element.select("imgname").text().trim());
 				menuoriginimgurlList.add(element.select("originimgurl").text().trim());
 				menusmallimageurlList.add(element.select("smallimageurl").text().trim());
 			}
 			
 			travelMap.put("menuImgnameList", menuImgnameList);
 			travelMap.put("menuoriginimgurlList", menuoriginimgurlList);
 			travelMap.put("menusmallimageurlList", menusmallimageurlList);
 			
 		 }
 		travelMap.put("cateCode", cateCode);
 		System.out.println(travelMap.toString());
			 
      return travelMap;
	}

	public int insertQnaComVo(innerQnAcomunityVo qnaCom) {
		int result = dao.insertQnaComVo(qnaCom);
		return result;
	}

	public List<innerQnAcomunityVo> selectQnaComVoList(innerQnAcomunityVo community) {
		List<innerQnAcomunityVo> innerQnaComList = new ArrayList<innerQnAcomunityVo>(); 		
		innerQnaComList = dao.selectQnaComVoList(community);
		return innerQnaComList;
	}

	public int deleteTwit(innerQnAcomunityVo community) {
		int result = 0;
		result = dao.deleteTwit(community);
		return result;
	}

}
