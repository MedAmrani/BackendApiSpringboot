package org.lsi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String name ;
	private String description;
	private Double reachedAmount;
	private Double totalAmount;
	private Date date;
	private String photo;
	
	@JsonIgnore
	@ManyToOne
	private UserInfo userInfo;
	@JsonIgnore
	@ManyToOne
	private Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<Donation> donations ;
	
	@JsonIgnore
	@ManyToMany
	private List<UserInfo> favorited;
	
	
}
