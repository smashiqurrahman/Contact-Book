package com.ashiq.contactbook.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String f_name;
	private String l_name;
	private String email_personal;
	private String note;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private Date dob;
	private Byte img;
//		
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "phone")	
//	private List<Phone> phones;
//	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
	private List<Phone> phones;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_address", 
	joinColumns = {
			@JoinColumn(name = "user_id_fk", referencedColumnName = "user_id") },
	inverseJoinColumns = {
			@JoinColumn(name = "address_id_fk", referencedColumnName = "id") })    
	private List<Address> addresses;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_occupation", 
	joinColumns = {
			@JoinColumn(name = "user_id_fk", referencedColumnName = "user_id") },
	inverseJoinColumns = {
			@JoinColumn(name = "occupation_id_fk", referencedColumnName = "id") })    
	private List<Occupation> occupations;
	
}
