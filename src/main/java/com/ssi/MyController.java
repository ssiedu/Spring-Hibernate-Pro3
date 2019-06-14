package com.ssi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	@RequestMapping("newstudent")
	public String test(){
		return "dataentry.jsp";
	}
	
	@RequestMapping("savestudent")
	public ModelAndView addStudentData(@ModelAttribute("student") Student student){
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(student);
		tr.commit();
		session.close();
		ModelAndView mv=new ModelAndView("saveconfirm.jsp");
		return mv;
		
	}
}
