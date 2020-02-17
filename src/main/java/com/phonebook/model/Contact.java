package com.phonebook.model;

import lombok.Data;

@Data
public class Contact {
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private Character activeStatus;
}
