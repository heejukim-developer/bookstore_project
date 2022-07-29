package ezenproject.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import ezenproject.dto.BookDTO;
import ezenproject.dto.MemberDTO;
import ezenproject.dto.OrderDTO;
import ezenproject.service.BookService;
import ezenproject.service.MemberService;
import ezenproject.service.OrderService;


// http://localhost:8090/

@CrossOrigin("*")
@Controller
public class MainController {

	@Autowired
	private BookService bservice;
	
	@Autowired
	private MemberService mservice;
	
	@Autowired
	private OrderService oservice;
	private BookDTO bdto;
	private MemberDTO mdto;
	private OrderDTO odto;

	public MainController() {
		// TODO Auto-generated constructor stub
	}
	
	@Value("${spring.servlet.multipart.location}")
	private String filepath;
	
	
	// http://localhost:8090/
	@RequestMapping(value = {"/", "/index.do"}, method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, ModelAndView mav ) {
		String viewname = (String) request.getAttribute("viewName");
		if(viewname==null) {
			viewname = "/index";
		}
		
		mav.setViewName(viewname);
		
		return mav;
	}
	
//	Form으로 끝나는 친구들 연결 시키는거
	@RequestMapping(value = "/member/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
            @RequestParam(value= "action", required=false) String action,
            HttpServletRequest request, 
            HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		HttpSession session = request.getSession();
		session.setAttribute("action", action);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}
	
//	로그인 하는 행위
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST )
	public ModelAndView memberLoginMethod(@ModelAttribute("member") MemberDTO dto, RedirectAttributes rAttr,
			HttpServletRequest request,  HttpServletResponse response
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mdto = mservice.memberLogin(dto);
		if(mdto!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", mdto);
			session.setAttribute("isLogOn", true);
			
			String action = (String) session.getAttribute("action");
			session.removeAttribute("action");
			if(action!=null) {
				mav.setViewName("redirect:" + action);
			}else {
				mav.setViewName("redirect:/");
			}
		}else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/member/loginForm.do");
		}
		
		return mav;
	}
	
	
//	로그아웃 하는 행위
	@RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogin");
		
		return "redirect:/";
	}
//////////////////주문페이지 ////////////////////////////////////////////////////////////
	
// http://localhost:8090/order_detail.do?currentPage=1&num=1
// 주문 페이지로 이동 
	@RequestMapping("/order_detail.do")
	public ModelAndView viewMethod(HttpServletRequest request,int currentPage,int num,ModelAndView mav) {
		//BoardDTO dto= service.contentProcess(num);
		String viewName= (String)request.getAttribute("viewName");
		mav.addObject("mdto",mservice.selectOneProcess(num));
		mav.addObject("bdto",bservice.selectOneProcess(num));
		mav.addObject("currentPage",currentPage);
		//mav.setViewName("/board/view");
		mav.setViewName(viewName);
		return mav;
		
	}
// 결제하기 누르면 주문테이블에 넣기 
	@RequestMapping(value="/order/order_List.do",method = RequestMethod.POST)
	public String updateProMethod(OrderDTO odto,int currentPage,HttpServletRequest request) {
		
		return "redirect:/order/order_List.do?currentPage="+currentPage;
	}
	
	@ResponseBody
	@RequestMapping(value="orderList.do", method = RequestMethod.POST)
	public void insertOrderMethod(OrderDTO odto,int currentPage,HttpServletRequest request) {
	
		oservice.addOrderProcess(odto);
		
	}
	
	
//@RequestMapping("/order/order_detail.do")
//public String order_detail() {
//return "/order_detail";
//}

	
}
	
	
	