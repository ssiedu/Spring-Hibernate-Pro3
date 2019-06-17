package com.ssi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.StudentDAO;
import com.ssi.entities.Student;

@Controller
public class MyController {
	
	@Autowired
	private StudentDAO studentDAO;	
	
	@RequestMapping("savestudentchanges")
	public ModelAndView saveChanges(@ModelAttribute("student") Student student){
		studentDAO.updateStudent(student);
		ModelAndView mv=new ModelAndView("redirect:viewallstudents");
		return mv;
	}
	
	@RequestMapping("updatestudent")
	public ModelAndView showUpdateForm(@RequestParam("id") int code){
		Student student=studentDAO.getStudentById(code);
		ModelAndView mv=new ModelAndView("updateform.jsp");
		mv.addObject("student", student);
		return mv;
	}
	
	@RequestMapping("removestudent")
	public ModelAndView removeData(@RequestParam("id") int code){
		studentDAO.removeStudent(code);
		ModelAndView mv=new ModelAndView("redirect:viewallstudents");
		return mv;
	}
	
	@RequestMapping("viewallstudents")
	public ModelAndView showAllStudents(){
		List<Student> students=	studentDAO.getAllStudents();
		ModelAndView mv=new ModelAndView("studentjstl.jsp");
		mv.addObject("students", students);
		return mv;
	}
	
	@RequestMapping("search")
	public ModelAndView doSearch(@RequestParam("t1") int code){
		Student student=studentDAO.getStudentById(code);
		if(student==null){
			ModelAndView mv=new ModelAndView("search.jsp");
			mv.addObject("searchErr","Invalid Roll Number");
			return mv;
		}
		//ModelAndView mv=new ModelAndView("searchresult.jsp");
		ModelAndView mv=new ModelAndView("studentdetails.jsp");
		mv.addObject("student", student);
		return mv;
	}
	
	@RequestMapping("searchstudent")
	public String showSearchForm(){
		return "search.jsp";
	}
	
	@RequestMapping(value="savestudent",method=RequestMethod.GET)
	public String showEntryForm(){
		return "dataentry.jsp";
	}
	
	@RequestMapping(value="savestudent",method=RequestMethod.POST)
	public ModelAndView addStudentData(@ModelAttribute("student") Student student){
		studentDAO.addStudent(student);
		ModelAndView mv=new ModelAndView("saveconfirm.jsp");
		return mv;
	}
}
