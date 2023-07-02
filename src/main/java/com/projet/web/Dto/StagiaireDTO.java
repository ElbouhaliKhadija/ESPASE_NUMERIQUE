package com.projet.web.Dto;

public class StagiaireDTO {

    private int stagiaireid;
    private String stagiairename;
    private String email;
    private String password;
    public StagiaireDTO() {
    }
    public StagiaireDTO(int stagiaireid, String stagiairename, String email, String password) {
        this.stagiaireid = stagiaireid;
        this.stagiairename = stagiairename;
        this.email = email;
        this.password = password;
    }
	public int getStagiaireid() {
		return stagiaireid;
	}
	public void setStagiaireid(int stagiaireid) {
		this.stagiaireid = stagiaireid;
	}
	public String getStagiairename() {
		return stagiairename;
	}
	public void setStagiairename(String stagiairename) {
		this.stagiairename = stagiairename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "StagiaireDTO [stagiaireid=" + stagiaireid + ", stagiairename=" + stagiairename + ", email=" + email
				+ ", password=" + password + "]";
	}


} 