package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestBookDao guestbookDao;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("list진입");
		
		List<GuestBookVo> list = guestbookDao.getlist();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute GuestBookVo guestbookVo) {
		
		System.out.println(guestbookVo.toString());
		
		guestbookDao.write(guestbookVo);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/deleteform", method = RequestMethod.GET)
	public String deleteform() {
		
		System.out.println("deleteform 진입");
		
		return "deleteform";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute GuestBookVo guestbookVo) {
		
		System.out.println("delete 진입");
		
		guestbookDao.delete(guestbookVo.getNo(), guestbookVo.getPassword());
		
		return "redirect:list";
	}
	
}
