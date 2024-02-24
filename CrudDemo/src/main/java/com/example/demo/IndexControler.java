package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexControler {
	@Autowired
	StudentDAO student;
	@RequestMapping("/Studentdetails")
	public String showMe() {
		return "home.jsp";
		
	}
//------------------------------------------------------	
	@RequestMapping("/addStudent") 
	public ModelAndView addStudent(Student stud) {
		System.out.println(stud.getRollNo());
		System.out.println(stud.getStudentName());				//ADD STUDENT
		ModelAndView mv = new ModelAndView();
		mv.addObject("studentdetails",stud);
		mv.setViewName("added.jsp");
		student.save(stud);
		return mv;
	}
//-------------------------------------------------------	
	@RequestMapping("/viewStudent")
	public ModelAndView display(Student stud) {
		Optional<Student> op =student.findById(stud.getRollNo());
		Student student =op.get();
		ModelAndView mv = new ModelAndView();							//VIEW STUDENT
		mv.addObject("studentdetails",student);
		mv.setViewName("display.jsp");
		return mv;
	}
//--------------------------------------------------------	
	@RequestMapping("deleteStudent")
	public ModelAndView deleteUser(Student stud) {
		ModelAndView mv = new ModelAndView();
		//student.updateStudent(stud.getStudentName(), stud.getRollNo());   //DELETE STUDENT
		student.deleteById(stud.getRollNo());
		mv.addObject("studentDetails",stud);
		mv.setViewName("deleted.jsp");
		return mv;	
	}
//-----------------------------------------------------------	
	@RequestMapping("updateStudent")
	public ModelAndView updateUser(Student stud) {
		student.updateStudent(stud.getStudentName(), stud.getRollNo());       //UPDATE STUDENT
		ModelAndView mv = new ModelAndView();
		mv.addObject("studentDetails",stud);
		mv.setViewName("updated.jsp");
		return mv;	
	}
//--------------------------------------------------------------

	
	
	
	
	
}
