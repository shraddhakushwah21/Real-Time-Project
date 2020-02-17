package com.phonebook;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.phonebook.entity.ContactEntity;
import com.phonebook.model.Contact;
import com.phonebook.repository.ContactRepository;
import com.phonebook.service.ContactService;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private static ContactService service;
	
	
	@Test
	public void testSaveContact01() {		
		Contact contact=new Contact();
		contact.setContactName("sonam");
		contact.setContactEmail("sonam@gmail.com");
		contact.setContactNumber(8899776688l);
		
		PowerMockito.when(service.saveContact(contact)).thenReturn(true);
		boolean saveContact = service.saveContact(contact);
		System.out.println(contact);
		assertNotNull(saveContact);
	}
	
	@Test
	public void testSaveContact02() throws Exception {
		Contact contact=new Contact();
		PowerMockito.when(service.saveContact(contact)).thenThrow(NullPointerException.class);
		boolean saveContact = service.saveContact(contact);
		System.out.println(contact);
		assertNull(saveContact);
	}
	
	/*
	 * @Test public void testGetContactById01() throws Exception { Contact
	 * con=service.getContactById(104); assertNull(con); }
	 * 
	 * @Test public void testGetContactById02() { Contact
	 * con=service.getContactById(101); System.out.println(con); assertNotNull(con);
	 * }
	 */
}
