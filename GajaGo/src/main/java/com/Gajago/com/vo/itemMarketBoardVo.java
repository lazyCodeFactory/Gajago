package com.Gajago.com.vo;

import java.util.List;

public class itemMarketBoardVo {
	private String marketIdx; // �ε���
	private String marketMethodType; // �޴�Ÿ��
	private String marketItemTicketType; // Ƽ��Ÿ�� 1.�� 2.�պ�
	private String marketItemTitle; // ����
	private String oTripStartDay; // �����
	private String rTripStartDay; // �����
	private String rTripEndDay; // ������
	private String marketItemContent; // �۳���
	private String marketWriter; // �۾����
	private String marketEnrollTime; // �� ��Ͻð�
	private String marketThumNail; // �� �����
	private String maxIdx;
	private List<String> imgfile;
	public List<String> getImgfile() {
		return imgfile;
	}
	public void setImgfile(List<String> imgfile) {
		this.imgfile = imgfile;
	}
	public String getMaxIdx() {
		return maxIdx;
	}
	public void setMaxIdx(String maxIdx) {
		this.maxIdx = maxIdx;
	}
	public String getMarketThumNail() {
		return marketThumNail;
	}
	public void setMarketThumNail(String marketThumNail) {  
		this.marketThumNail = marketThumNail;
	}
	public String getMarketIdx() {
		return marketIdx;
	}
	public void setMarketIdx(String marketIdx) {
		this.marketIdx = marketIdx;
	}
	public String getMarketMethodType() {
		return marketMethodType;
	}
	public void setMarketMethodType(String marketMethodType) {
		this.marketMethodType = marketMethodType;
	}
	public String getMarketItemTicketType() {
		return marketItemTicketType;
	}
	public void setMarketItemTicketType(String marketItemTicketType) {
		this.marketItemTicketType = marketItemTicketType;
	}
	public String getMarketItemTitle() {
		return marketItemTitle;
	}
	public void setMarketItemTitle(String marketItemTitle) {
		this.marketItemTitle = marketItemTitle;
	}
	public String getoTripStartDay() {
		return oTripStartDay;
	}
	public void setoTripStartDay(String oTripStartDay) {
		this.oTripStartDay = oTripStartDay;
	}
	public String getrTripStartDay() {
		return rTripStartDay;
	}
	public void setrTripStartDay(String rTripStartDay) {
		this.rTripStartDay = rTripStartDay;
	}
	public String getrTripEndDay() {
		return rTripEndDay;
	}
	public void setrTripEndDay(String rTripEndDay) {
		this.rTripEndDay = rTripEndDay;
	}
	public String getMarketItemContent() {
		return marketItemContent;
	}
	public void setMarketItemContent(String marketItemContent) {
		this.marketItemContent = marketItemContent;
	}
	public String getMarketWriter() {
		return marketWriter;
	}
	public void setMarketWriter(String marketWriter) {
		this.marketWriter = marketWriter;
	}
	public String getMarketEnrollTime() {
		return marketEnrollTime;
	}
	public void setMarketEnrollTime(String marketEnrollTime) {
		this.marketEnrollTime = marketEnrollTime;
	}
	@Override
	public String toString() {
		return "itemMarketBoardVo [marketIdx=" + marketIdx + ", marketMethodType=" + marketMethodType
				+ ", marketItemTicketType=" + marketItemTicketType + ", marketItemTitle=" + marketItemTitle
				+ ", oTripStartDay=" + oTripStartDay + ", rTripStartDay=" + rTripStartDay + ", rTripEndDay="
				+ rTripEndDay + ", marketItemContent=" + marketItemContent + ", marketWriter=" + marketWriter
				+ ", marketEnrollTime=" + marketEnrollTime + ", marketThumNail=" + marketThumNail + ", maxIdx=" + maxIdx
				+ ", imgfile=" + imgfile + "]";
	}  
 
	 
}
