package com.phonebook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phonebook.model.Contact;
import com.phonebook.service.ContactService;

@Controller
public class ContactController {

	private static Logger logger=LoggerFactory.getLogger(ContactController.class);
	
	public ContactController() {
		logger.info("Controller instantiated");
	}
	
	@Autowired
	private ContactService service;
	
	@RequestMapping(value = "/loadContact")
	public String showContactForm(Model model) {
		logger.debug("Method Execution started");
		Contact contact=new Contact();
		model.addAttribute("contact", contact);
		logger.debug("Method Execution ended");
		return "contact";
	}
	
	@RequestMapping(value = "/addContact",method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("contact")Contact contact,Model model) {
		logger.debug("Method Execution started");
		boolean isSaved =service.saveContact(contact);
		if(isSaved) {
			model.addAttribute("sucMsg","Contact Saved");
		}else {
			logger.error("Contact failed to save");
			model.addAttribute("errMSg", "Failed to Save");
		}
		System.out.println(contact);
		logger.debug("Method Execution ended");
		return "contact";
	}
	
	
	@RequestMapping(value = "/viewContacts")
	public String handleViewAllContacts(Model model) {
		logger.debug("Method Execution started");
		List<Contact> contactList = service.getAllActiveContacts();
		model.addAttribute("contacts", contactList);
		logger.debug("Method Execution ended");
		return "viewContacts";
	}
	
	@RequestMapping(value = "/editContact")
	public String handleEditLink(HttpServletRequest request,Model model) {
		Integer id=Integer.parseInt(request.getParameter("contactId"));
		Contact contactById = service.getContactById(id);
		model.addAttribute("contact", contactById);
		return "contact";
	}
	
	@RequestMapping(value = "/deleteContact")
	public String handleDeleteLink(HttpServletRequest request,RedirectAttributes ra) {
		logger.debug("Method Execution started");
		Integer id=Integer.parseInt(request.getParameter("contactId"));
		boolean deleteContact = service.deleteContact(id);
		if(deleteContact) {
			ra.addFlashAttribute("succMsg", "Contact deleted");
		}else {
			ra.addFlashAttribute("failMsg", "Contact not deleted");
		}
		logger.debug("Method Execution ended");
		return "redirect:/viewContacts";
	}
}
