package ezenproject.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ezenproject.dto.BookDTO;
import ezenproject.dto.MemberDTO;
import ezenproject.dto.OrderDTO;
import ezenproject.service.BookService;
import ezenproject.service.MemberService;
import ezenproject.service.OrderService;


// http://localhost:8090/index.jsp

@Controller
@CrossOrigin("*")
public class MainController {

	
//	@Autowired
//	private BookService bservice;
	@Autowired
	private MemberService mservice;
//	private OrderService oservice;
//	private BookDTO bdto;
	//	private OrderDTO odto;
	
	@Autowired
	private MemberDTO mdto;
	
	public MainController() {
		// TODO Auto-generated constructor stub
	}

	

	//2번째 방법 .. 로그인화면 
	@RequestMapping(value = "/")
	public String loginpage() {
		return "login"; //login.jsp로 
	}
//	
//	@RequestMapping(value = "/logincheck")
//	public ModelAndView loginCheck(@ModelAttribute MemberDTO dto, HttpSession session) {
//		boolean result = mservice.loginCheck(dto, session);
//		ModelAndView mav = new ModelAndView();
//		if (result == true) {//로그인 성공 
//			//mypage.jsp로 이동
//			mav.setViewName("redirect:/mypage.jsp");
//		}else {
//			//mypage.jsp로 이동
//			mav.setViewName("redirect:/member_join.jsp");
//			
//		}
//		return mav;
//	}
	
	//컨트롤러 아예 안먹힘 
	//@RequestMapping(value = "/login.jsp", method = RequestMethod.POST)
	@PostMapping("/login.jsp")
	public ModelAndView Login(@ModelAttribute("member") MemberDTO member,
			                  RedirectAttributes  rAttr,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("확인");
		ModelAndView mav = new ModelAndView();
		mdto = mservice.Login(member);
		if(mdto != null) {  
			//getSession() 메서드는 서버에 생성된 세션이 있다면 세션을 반환
			HttpSession session = request.getSession();
			//setAttribute는 name, value 쌍으로 객체 저장.
			session.setAttribute("member", mdto);
			session.setAttribute("isLogOn", true);
			
			//action값 조회 
			String action = (String)session.getAttribute("action");
			session.removeAttribute("action");
			
			if(action!= null) {
				mav.setViewName("redirect:"+action);
			}else {
				//성공시 마이페이지로 
				mav.setViewName("redirect:/mypage.jsp");	
			}
		}else {
			rAttr.addAttribute("result","loginFailed");
			//실패시 회원가입 페이지로
			mav.setViewName("redirect:/member_join.jsp");
		}
		return mav;
	}
	
	

}
