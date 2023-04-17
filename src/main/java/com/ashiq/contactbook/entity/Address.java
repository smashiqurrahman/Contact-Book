package com.ashiq.contactbook.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "address")
public class Address {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String address_line;
	private String city;
	private String state;
	private String country;
	private String postal;
	private float latitude;
	private float longitude;
	
	@ManyToMany(mappedBy = "addresses", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<User> users;
}
