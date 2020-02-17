package com.phonebook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="CONTACT_DTLS")
public class ContactEntity {
	
	@Id
	@Column(name="CONTACT_ID")
	@SequenceGenerator(name = "ID_SEQ",sequenceName = "CONTACT_ID",initialValue = 101,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ID_SEQ")
	private Integer contactId;
	
	@Column(name="CONTACT_NAME")
	private String contactName;
	
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name="CONTACT_NUMBER")
	private Long contactNumber;
	
	@Column(name="ACTIVE_SW")
	private Character activeStatus;
	
	@Column(name="CREATED_DATE")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="UPDATED_DATE")
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
}
