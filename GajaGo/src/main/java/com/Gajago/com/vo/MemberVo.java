package com.Gajago.com.vo;

public class MemberVo {

	private String id;
	private String password;
	private String snsId;
	private String name;
	private String nickname;
	private String phone;
	private String email;
	private String gender;
	private String profilePic;
	private String snsType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSnsId() {
		return snsId;
	}
	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getSnsType() {
		return snsType;
	}
	public void setSnsType(String snsType) {
		this.snsType = snsType;
	}
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", password=" + password + ", snsId=" + snsId + ", name=" + name + ", nickname="
				+ nickname + ", phone=" + phone + ", email=" + email + ", gender=" + gender + ", profilePic="
				+ profilePic + ", snsType=" + snsType + "]";
	}	

}
