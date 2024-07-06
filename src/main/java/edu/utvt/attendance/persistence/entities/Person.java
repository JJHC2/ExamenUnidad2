package edu.utvt.attendance.persistence.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="te_person")
public class Person {
	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable=false,length=50)
	private String nombre;
	@Column(nullable=false)
	private Integer edad;
	@Column(nullable=false,length=100)
	private String universidad;
	@Column(nullable=false,length=20)
	private String correo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(nullable = false,columnDefinition = "DATE")
	private Date birthDate;
	
	 @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	    private List<Item> items;
	 
	 
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(nullable = false, updatable = false,columnDefinition = "TIMESTAMP")
	@CreationTimestamp
	private Date createdOn;
}
