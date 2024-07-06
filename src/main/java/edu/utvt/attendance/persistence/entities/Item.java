package edu.utvt.attendance.persistence.entities;



import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "te_item")
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	@Id
	@Column(nullable=false)
	private Long id;
	@Column(nullable=false,length=50)
	private String nombre;
	@Column(nullable=false)
	private Double precio;
	 @ManyToOne
	    @JoinColumn(name = "persona_id", nullable = false)
	    private Person person;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(nullable = false, updatable = false,columnDefinition = "TIMESTAMP")
	@CreationTimestamp
	private Date createdOn;
}
