package com.vision.mybatis_board;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vision.mybatis_board.service.BContentService;
import com.vision.mybatis_board.service.BJoinService;
import com.vision.mybatis_board.service.BModifyService;
import com.vision.mybatis_board.service.BReplyService;
import com.vision.mybatis_board.service.BReplyViewService;
import com.vision.mybatis_board.service.BWriteService;
import com.vision.mybatis_board.service.Constant;
import com.vision.mybatis_board.service.IBoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	IBoardService service;
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
		
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list")
	public String list(Model model,HttpServletRequest request, HttpServletResponse reponse) {
		System.out.println("list() 실행");
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view() 실행");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(Model model,HttpServletRequest request) throws SQLException {
		System.out.println("write() 실행");
		model.addAttribute("request",request);
		service = new BWriteService();
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/join_view")
	public String join_view(Model model) {
		System.out.println("join_view() 실행");
		return "join_view";
	}
	
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		System.out.println("welcome() 실행");
		return "welcome";
	}
	
	@RequestMapping("/join")
	public String join(Model model, HttpServletRequest request) throws SQLException {
		System.out.println("join() 실행");
		model.addAttribute("request",request);
		service = new BJoinService();
		service.execute(model);
		return "welcome";
	}
	
	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request) throws SQLException {
		System.out.println("login() 실행");

		return "welcome";
	}
	
	@RequestMapping("/content_view")
	public String content_view(Model model,HttpServletRequest request) throws SQLException {
		System.out.println("content_view() 실행");
		model.addAttribute("request",request);
		service = new BContentService();
		service.execute(model);
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(Model model,HttpServletRequest request) throws SQLException {
		System.out.println("modify() 실행");
		model.addAttribute("request",request);
		service = new BModifyService();
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/reply")
	public String reply(Model model,HttpServletRequest request) throws SQLException {
		System.out.println("reply() 실행");
		model.addAttribute("request",request);
		service = new BReplyService();
		service.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(Model model,HttpServletRequest request) throws SQLException {
		System.out.println("reply_view() 실행");
		model.addAttribute("request",request);
		service = new BReplyViewService();
		service.execute(model);
		return "reply_view";
	}
}
