package com.Gajago.com.util;

import javax.servlet.http.HttpSession;

import com.Gajago.com.vo.MemberVo;

public class SessionUtil {
//세션에다가 셋팅 
	public static int setSession(HttpSession session,MemberVo member) {
 		int result = 1 ;
		try {
			session.setAttribute("id", member.getId());
			session.setAttribute("snsId", member.getSnsId());
			session.setAttribute("profilePic", member.getProfilePic());
			session.setAttribute("nickname", member.getNickname());
 		} catch (Exception ex) {
			ex.printStackTrace();
			result = -1;
		}
		return result;
	}
//세션 정보 가져오기	
	public static MemberVo getSession(HttpSession session) {
		MemberVo sessionInfo = new MemberVo();
		try {
			 String id 	      = 	(String) session.getAttribute("id");
			 String snsId 	  = 	(String) session.getAttribute("snsId");
			 String profilePic =     (String) session.getAttribute("profilePic");
			 String nickname =     (String) session.getAttribute("nickname");
			 sessionInfo.setId(id);
			 sessionInfo.setSnsId(snsId);
			 sessionInfo.setProfilePic(profilePic);
			 sessionInfo.setNickname(nickname);
 		} catch (Exception ex) {
			ex.printStackTrace();
			sessionInfo =null;
		}
		return sessionInfo;
	}
 
	

}
