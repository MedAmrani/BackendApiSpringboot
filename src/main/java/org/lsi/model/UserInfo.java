package org.lsi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String fullname;
    private String email;
    
    public UserInfo(String username, String password, String fullname, String email) {
    	this.username = username;
    	this.password = password;
    	this.fullname = fullname;
    	this.email = email;
    }


	@OneToMany(mappedBy = "userInfo", fetch = FetchType.LAZY)
	private List<Project> projects ;
	
	@OneToMany(mappedBy = "userInfo", fetch = FetchType.LAZY)
	private List<Donation> donations; 
	
	@ManyToMany
	private List<Project> favoriteProjects;
}
