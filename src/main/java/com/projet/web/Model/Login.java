package com.projet.web.Model;
import jakarta.persistence.*;
@Entity
@Table(name="login")
public class Login {

    @Id
    @Column(name="stagiaireid", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stagiaireid;
    @Column(name="stagiairename", length = 255)
    private String stagiairename;
    @Column(name="email", length = 255)
    private String email;
    @Column(name="password", length = 255)
    private String password;
    public Login() {
    }
    public Login(int stagiaireid, String stagiairename, String email, String password) {
        this.stagiaireid = stagiaireid;
        this.stagiairename = stagiairename;
        this.email = email;
        this.password = password;
    }
//create getters and setters
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
		return "Login [stagiaireid=" + stagiaireid + ", stagiairename=" + stagiairename + ", email=" + email
				+ ", password=" + password + "]";
	}
    
}