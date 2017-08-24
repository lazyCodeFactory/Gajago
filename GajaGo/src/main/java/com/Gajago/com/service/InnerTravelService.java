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
		StringBuilder queryUrlCommon = new StringBuilder();
		String innerTravelRegionDetailKey = KeyClass.INNER_TRAVEL_REGION_DETAIL;
		String innerTravelCourseInfo = KeyClass.INNER_TRAVEL_INTRO_INFO;
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
 		
/////////////////////////////////공통 정보 부분//////////////////////////////////////////////////
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
				travelMap.put("firstimage", element.select("firstimage").text());
				
 				
				 

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
						travelMap.put("distance",element.select("distance").text());
						travelMap.put("taketime",element.select("taketime").text());

	  				}
 				}
 				//여행지  소개정보	
 				else if("12".equals(cateCode)) {
	  				for (Element element : elementsTravelInfo) {
						String expguide = element.select("expguide").text();
						String restdate = element.select("restdate").text();
						String chkbabycarriage = element.select("chkbabycarriage").text();
						String chkcreditcard = element.select("chkcreditcard").text();
						String chkpet = element.select("chkpet").text();
						String infocenter = element.select("infocenter").text();
						String usetime = element.select("usetime").text();
 						
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
		  				String chkbabycarriageleports = element.select("chkbabycarriageleports").text();
						String chkcreditcardleports = element.select("chkcreditcardleports").text();
						String chkpetleports = element.select("chkpetleports").text();
						String expagerangeleports = element.select("expagerangeleports").text();
						String infocenterleports = element.select("infocenterleports").text();
						String parkingleports = element.select("parkingleports").text();
						String reservation = element.select("reservation").text();
						String restdateleports = element.select("restdateleports").text();
						String scaleleports = element.select("scaleleports").text();
						String usetimeleports = element.select("usetimeleports").text();
						 
						
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
						String checkintime = element.select("checkintime").text();
						String checkouttime = element.select("checkouttime").text();
						String chkcooking = element.select("chkcooking").text();
						String foodplace = element.select("foodplace").text();
						String infocenterlodging = element.select("infocenterlodging").text();
						String reservationlodging = element.select("reservationlodging").text();
						String reservationurl = element.select("reservationurl").text();
						String roomcount = element.select("roomcount").text();
						String roomtype = element.select("roomtype").text();
						String sauna = element.select("sauna").text();
						String seminar = element.select("seminar").text();
						String sports = element.select("sports").text();

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
				String subdetailimg = element.select("subdetailimg").text();
				String subdetailoverview = element.select("subdetailoverview").text();
				String subname = element.select("subname").text();
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
	 			String originimgurl = element.select("originimgurl").text();
				String smallimageurl = element.select("smallimageurl").text();
 	 		
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
			List<String> roomImgList = new ArrayList<String>();
	 		List<String> roomImgaltList = new ArrayList<String>();
	 		
 			for(Element element : elementsRoomImageInfo) {
 				String roomaircondition = element.select("roomaircondition").text();
				String roombasecount = element.select("roombasecount").text();
				String roombath = element.select("roombath").text();
				String roomcook = element.select("roomcook").text();
				String roomcount = element.select("roomcount").text();
				String roomhairdryer = element.select("roomhairdryer").text();
				String roomoffseasonminfee1 = element.select("roomoffseasonminfee1").text();
				String roomoffseasonminfee2 = element.select("roomoffseasonminfee2").text();
				String roompeakseasonminfee1 = element.select("roompeakseasonminfee1").text();
				String roompeakseasonminfee2 = element.select("roompeakseasonminfee2").text();
				String roomrefrigerator = element.select("roomrefrigerator").text();
				String roomsize1 = element.select("roomsize1").text();
				String roomsize2 = element.select("roomsize2").text();
				String roomtitle = element.select("roomtitle").text();
				String roomtv = element.select("roomtv").text();
				
				
		 		travelMap.put("roomaircondition", roomaircondition);
		 		travelMap.put("roombasecount", roombasecount);
		 		travelMap.put("roombath", roombath);
		 		travelMap.put("roomcook", roomcook);
		 		travelMap.put("roomcount", roomcount);
		 		travelMap.put("roomhairdryer", roomhairdryer);
		 		travelMap.put("roomoffseasonminfee1", roomoffseasonminfee1);
		 		travelMap.put("roomoffseasonminfee2", roomoffseasonminfee2);
		 		travelMap.put("roompeakseasonminfee1", roompeakseasonminfee1);
		 		travelMap.put("roompeakseasonminfee2", roompeakseasonminfee2);
		 		travelMap.put("roomrefrigerator", roomrefrigerator);
		 		travelMap.put("roomsize1", roomsize1);
		 		travelMap.put("roomsize2", roomsize2);
		 		travelMap.put("roomtitle", roomtitle);
		 		travelMap.put("roomtv", roomtv);
		 		

		 		for(int i=1;i<5;i++) {
		 			String roomImg =  element.select("roomimg"+i+"").text();
		 			String roomImgalt =  element.select("roomimg"+i+"alt").text();
		 			roomImgList.add(roomImg);
		 			roomImgaltList.add(roomImgalt);
		 		}

		 		travelMap.put("roomImgList", roomImgList);
		 		travelMap.put("roomImgaltList", roomImgaltList);
				
 			}

 			
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
	  		queryTravelMenuImage.append("&listYN=N");
	  		
	  		Document documentMenuImageInfo = Jsoup.connect(queryTravelMenuImage.toString()).get();
			Elements elementsMenuImageInfo = documentMenuImageInfo.select("item");
			List<String> menuImgnameList  = new ArrayList<String>();
			List<String> menuoriginimgurlList  = new ArrayList<String>();
			List<String> menusmallimageurlList  = new ArrayList<String>();

 			for(Element element : elementsMenuImageInfo) {
 				menuImgnameList.add(element.select("imgname").text());
 				menuoriginimgurlList.add(element.select("originimgurl").text());
 				menusmallimageurlList.add(element.select("smallimageurl").text());
 				
 			}
 			
 			travelMap.put("menuImgnameList", menuImgnameList);
 			travelMap.put("menuoriginimgurlList", menuoriginimgurlList);
 			travelMap.put("menusmallimageurlList", menusmallimageurlList);
 			
 		 }
 		travelMap.put("cateCode", cateCode);
 		  
			 
      return travelMap;
	}

	public int insertQnaComVo(innerQnAcomunityVo qnaCom) {
		int result = dao.insertQnaComVo(qnaCom);
		return result;
	}

	public List<innerQnAcomunityVo> selectQnaComVoList(String innerTravelQnaContentId) {
		List<innerQnAcomunityVo> innerQnaComList = new ArrayList<innerQnAcomunityVo>(); 		
		innerQnaComList = dao.selectQnaComVoList(innerTravelQnaContentId);
		return innerQnaComList;
	}

}
