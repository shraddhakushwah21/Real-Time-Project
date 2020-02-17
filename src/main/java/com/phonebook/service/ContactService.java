package com.phonebook.service;

import java.util.List;

import com.phonebook.model.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllActiveContacts();
	
	public Contact getContactById(Integer id);
	
	public boolean updateContact(Contact contact);
	
	public boolean deleteContact(Integer id);
}
