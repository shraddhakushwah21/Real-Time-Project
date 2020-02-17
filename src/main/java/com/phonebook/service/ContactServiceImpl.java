package com.phonebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.entity.ContactEntity;
import com.phonebook.model.Contact;
import com.phonebook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public boolean saveContact(Contact contact) {
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveStatus('Y');
		ContactEntity savedEntity = contactRepo.save(entity);
		return savedEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllActiveContacts() {
		List<ContactEntity> activeRecords = contactRepo.findByActiveStatus('Y');
		List<Contact> contactList=new ArrayList<Contact>();
		for(ContactEntity entity:activeRecords) {
			Contact con=new Contact();
			BeanUtils.copyProperties(entity, con);
			contactList.add(con);
		}
		return contactList;
	}

	@Override
	public Contact getContactById(Integer id) {
		Optional<ContactEntity> findById = contactRepo.findById(id);
		if(findById.isPresent()) {
			ContactEntity contactEntity = findById.get();
			Contact contact=new Contact();
			BeanUtils.copyProperties(contactEntity, contact);
			return contact;
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactEntity savedEntity = contactRepo.save(entity);
		return savedEntity.getContactId()!=null;
	}

	@Override
	public boolean deleteContact(Integer id) {
		contactRepo.deleteContact('N', id);
		return true ;
	}

}
