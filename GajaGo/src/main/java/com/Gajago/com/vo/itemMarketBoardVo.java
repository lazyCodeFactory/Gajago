package com.Gajago.com.vo;

public class itemMarketBoardVo {

	private String menuWriteType; //�޴�Ÿ��
	private String itemTitle;     //����
	private String fileshowName;  //����
	private String ticketType;    //Ƽ��Ÿ�� 1.�� 2.�պ�
	private String oTripstartDay; //�����
	private String rTripStartDay; //�����
	private String rTripEndDay;   //������
	private String itemContent;   //���� ������
	public String getMenuWriteType() {
		return menuWriteType;
	}
	public void setMenuWriteType(String menuWriteType) {
		this.menuWriteType = menuWriteType;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getFileshowName() {
		return fileshowName;
	}
	public void setFileshowName(String fileshowName) {
		this.fileshowName = fileshowName;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getoTripstartDay() {
		return oTripstartDay;
	}
	public void setoTripstartDay(String oTripstartDay) {
		this.oTripstartDay = oTripstartDay;
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
	public String getItemContent() {
		return itemContent;
	}
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	@Override
	public String toString() {
		return "itemMarketBoardVo [menuWriteType=" + menuWriteType + ", itemTitle=" + itemTitle + ", fileshowName="
				+ fileshowName + ", ticketType=" + ticketType + ", oTripstartDay=" + oTripstartDay + ", rTripStartDay="
				+ rTripStartDay + ", rTripEndDay=" + rTripEndDay + ", itemContent=" + itemContent + "]";
	}
	

}
