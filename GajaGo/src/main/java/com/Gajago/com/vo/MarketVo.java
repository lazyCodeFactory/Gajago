package com.Gajago.com.vo;

public class MarketVo {
	private String	marketidx;				
	private String	marketMethodType;				
	private String	marketItemSellItemType;			
	private String	marketTitle;			
	private String	marketWriter;				
	private String	marketItemFile1;				
	private String	marketItemFile2;				
	private String	marketItemFile3;			
	private String	marketItemFile4;				
	private String	marketEnrollTime;
	public String getMarketidx() {
		return marketidx;
	}
	public void setMarketidx(String marketidx) {
		this.marketidx = marketidx;
	}
	public String getMarketMethodType() {
		return marketMethodType;
	}
	public void setMarketMethodType(String marketMethodType) {
		this.marketMethodType = marketMethodType;
	}
	public String getMarketItemSellItemType() {
		return marketItemSellItemType;
	}
	public void setMarketItemSellItemType(String marketItemSellItemType) {
		this.marketItemSellItemType = marketItemSellItemType;
	}
	public String getMarketTitle() {
		return marketTitle;
	}
	public void setMarketTitle(String marketTitle) {
		this.marketTitle = marketTitle;
	}
	public String getMarketWriter() {
		return marketWriter;
	}
	public void setMarketWriter(String marketWriter) {
		this.marketWriter = marketWriter;
	}
	public String getMarketItemFile1() {
		return marketItemFile1;
	}
	public void setMarketItemFile1(String marketItemFile1) {
		this.marketItemFile1 = marketItemFile1;
	}
	public String getMarketItemFile2() {
		return marketItemFile2;
	}
	public void setMarketItemFile2(String marketItemFile2) {
		this.marketItemFile2 = marketItemFile2;
	}
	public String getMarketItemFile3() {
		return marketItemFile3;
	}
	public void setMarketItemFile3(String marketItemFile3) {
		this.marketItemFile3 = marketItemFile3;
	}
	public String getMarketItemFile4() {
		return marketItemFile4;
	}
	public void setMarketItemFile4(String marketItemFile4) {
		this.marketItemFile4 = marketItemFile4;
	}
	public String getMarketEnrollTime() {
		return marketEnrollTime;
	}
	public void setMarketEnrollTime(String marketEnrollTime) {
		this.marketEnrollTime = marketEnrollTime;
	}
	@Override
	public String toString() {
		return "MarketVo [marketidx=" + marketidx + ", marketMethodType=" + marketMethodType
				+ ", marketItemSellItemType=" + marketItemSellItemType + ", marketTitle=" + marketTitle
				+ ", marketWriter=" + marketWriter + ", marketItemFile1=" + marketItemFile1 + ", marketItemFile2="
				+ marketItemFile2 + ", marketItemFile3=" + marketItemFile3 + ", marketItemFile4=" + marketItemFile4
				+ ", marketEnrollTime=" + marketEnrollTime + "]";
	}	
	
}
