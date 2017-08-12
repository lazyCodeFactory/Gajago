package com.Gajago.com.util;

import java.security.MessageDigest;

public class StringUtil { 
	
 //비밀번호 암호화 	
 public String encryptSha256(String str) {
	 String sha="";
	 try {
		 MessageDigest sh  = MessageDigest.getInstance("SHA-256");
		 sh.update(str.getBytes());
		 byte byteData[] =sh.digest();
		 StringBuffer sb = new StringBuffer();
		 for(int i=0;i<byteData.length;i++) {
			 sb.append(Integer.toString((byteData[i]&0xff)+0x100,16).substring(1));
		 }
		 sha = sb.toString();
		 
		 
		 
	 }catch(Exception ex) {
		 ex.printStackTrace();
		 sha = null;
	}
	 return sha;
 }
 
 //비밀번호 초기화 
 public static String randowPwdInit(int length) {
   int index = 0;
   char [] charSet = new char[]{
		   '0','1','2','3','4','5','6','7','8','9'
		   ,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
		   ,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
	};
   
   
   StringBuffer sb = new StringBuffer();
   for(int i=0; i<length; i++) {
	   index = (int) (charSet.length * Math.random());
	   sb.append(charSet[index]);
   }
   return sb.toString();
 }
 
}


