package book.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import book.service.BookService;
import book.vo.BookVO;

@Controller
//@RequestMapping("/book/")
public class BookController {

	@Autowired
	BookService service;
	
	@RequestMapping("/")
	public  ModelAndView index() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",service.findAll());
		mv.setViewName("index");
		return mv;
		//return "index"; //viewResolver등록->dipatcher-servlet.xml
	}
	
	//입력 : form에서 값이 전달됨을 알아야합니다.(시작이 폼에서 시작)
	@RequestMapping("/insert")
	public ModelAndView insert(String title, String content, int price) {
		System.out.println(title+","+content+","+price);
		int result=service.insert(new BookVO(title, content, price));
		//입력 후에 화면을 어떻게 표시할 것인가를 결정(바뀌는 상황적 판단)-책의 전체리스트
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",service.findAll());
		mv.setViewName("index");
		return mv;
	}
	
	//전체출력(url요청-list값을 dao에 가져오고-list을 저장해서 웹페이지에 보내기)
	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		 ModelAndView mv=new ModelAndView();
		 mv.addObject("list", service.findAll());
		 mv.setViewName("index");
		 return mv;
	}
	
	//선택출력
	@RequestMapping("/findOne")
	public ModelAndView findone(int idx) {
		 System.out.println(idx);
		 ModelAndView mv=new ModelAndView();
		 mv.addObject("find", service.findOne(idx));
		 mv.addObject("list", service.findAll());
		 System.out.println(service.findOne(idx).toString());
		 mv.setViewName("index");
		 return mv;
	}
	
	//수정
	@RequestMapping("/update")
	public ModelAndView update(int idx,String title, String content, int price) {
		 System.out.println(idx);
		 	BookVO book = new BookVO(title, content, price);
		 int result=service.update(idx,book);
			//입력 후에 화면을 어떻게 표시할 것인가를 결정(바뀌는 상황적 판단)-책의 전체리스트
			ModelAndView mv=new ModelAndView();
			if(result==0) {
				mv.setViewName("error");
			}
			else {
			mv.addObject("list",service.findAll());
			mv.addObject("find", service.findOne(idx));
			mv.setViewName("index");
			
			}
			return mv;
	}
	//삭제
	@RequestMapping("/del")
	public ModelAndView del(int idx) {
		 System.out.println(idx);
		 ModelAndView mv=new ModelAndView();
		 int result = service.del(idx);
		 mv.addObject("list", service.findAll());
		 mv.setViewName("index");
		 return mv;
	}
	
}
