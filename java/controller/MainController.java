package controller;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import phonebook.Pagelist;
import phonebook.PhonebookOracleDAO;
import phonebook.PhonebookService;
import phonebook.PhonebookVO;
import replyboard.BoardService;
import replyboard.BoardVO;
import replyboard.BoardpageList;


@Controller
public class MainController{
	@Autowired
	MemberService service;
	@Autowired
	PhonebookService phonebookservice;
	@Autowired
	BoardService boardservice;

	 @RequestMapping("/")
	    public ModelAndView index() {
	        ModelAndView mv=new ModelAndView();
	        mv.addObject("mainpage","/home/main.jsp");
	        mv.setViewName("index");
	        return mv;
	    }
	 @RequestMapping("/login")
	 	public ModelAndView login() {
		
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("login/login");
		 return mv;
}
	 @RequestMapping("/index")
	  public ModelAndView indexgo() {
	        ModelAndView mv=new ModelAndView();
	        mv.addObject("mainpage","/home/main.jsp");
	        mv.setViewName("index");
	        return mv;
	    }
	 @RequestMapping("/logout")
	 public ModelAndView logout(HttpSession session) {
		 session.invalidate();
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("login");
		 return mv;
}
	 @RequestMapping("/loginProc")
	 public ModelAndView loginproc(String id,String password,HttpSession session) {
		 ModelAndView mv=new ModelAndView();
		if(service.loginchek(id, password)) {
			
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			mv.addObject("mainpage","/home/main.jsp");
			mv.setViewName("index");
	 }
		else {
			mv.setViewName("login");
			
		}
		return mv;
	 }
		@RequestMapping("/member/joinmember")
		public ModelAndView joinmember() {
			ModelAndView mv=new ModelAndView();
			mv.setViewName("/member/joinmember");
			return mv;
		}
		@RequestMapping("/member/joinmemberproc")
		public ModelAndView joinmemberproc(String id,String password,String email,String name){ {
			MemberVO VO = new MemberVO(id,password,email,name);
			int result = service.joinMember(VO);
			ModelAndView mv=new ModelAndView();
			if(result>0) {
				mv.addObject("mainpage", "member/membersuc.jsp");
				mv.setViewName("index");
			}
			else{
				mv.addObject("mainpage", "member/memberfail.jsp");
				mv.setViewName("index");
			}
			return mv;
		}
		}
		@RequestMapping("/update")
		public 	ModelAndView update(String id) {
			ModelAndView mv=new ModelAndView();
			mv.addObject("id",id);
			mv.addObject("mainpage","bember/update.jsp");
			mv.setViewName("index");
			return mv;
		}
		@RequestMapping("/updateproc")
		public ModelAndView updateproc(String id,String password,String email,String name) {
			MemberVO VO = new MemberVO(id,password,email,name);
			int result = service.updateMember(VO);
			ModelAndView mv=new ModelAndView();
			if(result>0) {
				mv.addObject("mainpage", "member/updatesuc.jsp");
				mv.setViewName("index");
			}
			else{
				mv.addObject("mainpage", "member/updatefail.jsp");
				mv.setViewName("index");
			}
			return mv;
		}
		@RequestMapping("/company")
		public ModelAndView company() {
			ModelAndView mv=new ModelAndView();
			mv.addObject("mainpage","drool-html/index.jsp");
			mv.setViewName("index");
			return mv;
		
		}
		@RequestMapping("/phonebook")
		public ModelAndView phonebook(Integer currentPage) {
			
			if(currentPage==null) {
				currentPage=1;
			}
			
			Pagelist pagelist=phonebookservice.pageList(currentPage);
			System.out.println(pagelist.getTotalPage());
			ModelAndView mv=new ModelAndView();
			mv.addObject("pagelist",pagelist);
			mv.addObject("mainpage","phonebook/pagelist.jsp");
			mv.setViewName("index");
			return mv;
			
		}
		@RequestMapping("/phupdate")
		public ModelAndView phupdate(int idx,String name,String hp,String memo) {
			ModelAndView mv=new ModelAndView();
			PhonebookVO phonebookvo = new PhonebookVO(idx,name,hp,memo);
			mv.addObject("update",phonebookvo);
			mv.addObject("mainpage", "phonebook/update.jsp");
			mv.setViewName("index");
			return mv;
			
		}

		@RequestMapping("/phupdateProc")
		public ModelAndView phupdateproc(int idx,String name,String hp,String memo,Integer currentPage) {
			PhonebookVO phonebookvo = new PhonebookVO(idx,name,hp,memo);
			phonebookservice.update(phonebookvo);
			System.out.println(phonebookvo.toString());
			if(currentPage==null) {
				currentPage=1;
			}
			
			Pagelist pagelist=phonebookservice.pageList(currentPage);
			System.out.println(pagelist.getTotalPage());
			
			
			ModelAndView mv=new ModelAndView();
			mv.addObject("pagelist",pagelist);
			mv.addObject("mainpage","phonebook/pagelist.jsp");
			mv.setViewName("index");
			return mv;
		}
		
		@RequestMapping("/viewOne")
		public ModelAndView view(int idx) {
		    PhonebookVO phonebookvo = phonebookservice.findone(idx);
		    
		    ModelAndView mv = new ModelAndView();
		   
		    mv.addObject("board", phonebookvo);
		    mv.addObject("mainpage", "phonebook/view.jsp");
		    mv.setViewName("index");
		    return mv;
		}

		@RequestMapping("/del")
		public ModelAndView del(Integer idx,Integer currentPage) {
			
			if(idx != null) {
		   System.out.println(phonebookservice.del(idx));
			}
			if(currentPage==null) {
				currentPage=1;
			}
		    Pagelist pagelist=phonebookservice.pageList(currentPage);
			
			ModelAndView mv=new ModelAndView();
			mv.addObject("pagelist",pagelist);
			mv.addObject("mainpage","phonebook/pagelist.jsp");
			mv.setViewName("index");
		    return mv;
		}
		
		
		@RequestMapping("/board")
		public ModelAndView board(Integer currentPage) {
			
			if(currentPage==null) {
				currentPage=1;
			}
			
			int countPerPage=10;
			BoardpageList boardpageList
			=boardservice.pageList(currentPage, countPerPage);
			 ModelAndView mv = new ModelAndView();
			 mv.addObject("pagelist",boardpageList);
			 mv.addObject("mainpage","replyboard/pageList.jsp");
			 mv.setViewName("index");
			 return mv;
		}
		@RequestMapping("/findView")
		public ModelAndView findView(int idx) {
			BoardVO board=boardservice.findOneById(idx);
			 ModelAndView mv = new ModelAndView();
			 mv.addObject("board",board);
			 mv.addObject("mainpage", "replyboard/findOne.jsp");
			 mv.setViewName("index");
			 return mv;
		}
		@RequestMapping("/write")
		public ModelAndView write() {
			ModelAndView mv = new ModelAndView();

			mv.addObject("mainpage","replyboard/writeForm.jsp");
			mv.setViewName("index");
			return mv;
		}
		@RequestMapping(value = "/writeProc", method = RequestMethod.POST)
		public ModelAndView writeProc(
				
		        @RequestParam("writename") String writename,
		        @RequestParam("title") String title,
		        @RequestParam("content") String content,
		        @RequestParam("filename") MultipartFile file,
		        RedirectAttributes redirectAttributes) {

		    // Handle file upload
		    String filename = null;
		    int countPerPage=10;
			BoardpageList boardpageList
			=boardservice.pageList(1, countPerPage);
			 ModelAndView mv = new ModelAndView();
			 mv.addObject("pagelist",boardpageList);
		    mv.addObject("mainpage","replyboard/pageList.jsp");
		    mv.setViewName("index");
		    if (!file.isEmpty()) {
		        try {
		            byte[] bytes = file.getBytes();
		            filename = file.getOriginalFilename();
		            Path path = Paths.get("C:\\Users\\admin\\eclipse-workspace\\replyboard\\src\\main\\webapp\\WEB-INF\\fileupload", filename);
		            Files.write(path, bytes);
		        } catch (IOException e) {
		            e.printStackTrace();
		        
		            return mv;
		        }
		    }

		    // Prepare data
		    BoardVO board = new BoardVO();
		    board.setWritename(writename);
		    board.setWriteid(writename);
		    board.setTitle(title);
		    board.setContent(content);
		    board.setFilename(filename);
		    

		    // Send data to the service
		    boardservice.insert(board);
		    
		    return mv;
		}
		@RequestMapping("/updateProc")
		public ModelAndView boardupdateProc(int idx,String title,String content) {
			BoardVO board=new  BoardVO();
			board.setIdx(idx);
			board.setTitle(title);
			board.setContent(content);
			//System.out.println(board.toString());
			boardservice.update(board);
			ModelAndView mv = new ModelAndView();
			board=boardservice.findOneById(idx);
			 mv.addObject("board",board);
			 mv.addObject("mainpage", "replyboard/findOne.jsp");
			 mv.setViewName("index");
			 return mv;
			 
		}
		
		@RequestMapping("/deleteProc")
		public ModelAndView deleteProc(int idx) {
			
			 ModelAndView mv = new ModelAndView();
			 
			boardservice.del(idx);
			int countPerPage=10;
			BoardpageList boardpageList
			=boardservice.pageList(1, countPerPage);
			mv.addObject("pagelist",boardpageList);
			  mv.addObject("mainpage","replyboard/pageList.jsp");
			mv.setViewName("index");
			return mv;
		}
		@RequestMapping("/replyForm")
		public ModelAndView replyForm(int idx) {
			BoardVO parent = boardservice.findOneById(idx);
			ModelAndView mv = new ModelAndView();
			mv.addObject("parent",parent);
			mv.addObject("mainpage", "replyboard/replyForm.jsp");
			mv.setViewName("index");
			return mv;
		}
		@RequestMapping("/replyFormProc")
		public ModelAndView replyFormProc(String title,String content,String writename,int tab,int parentid) {
			tab = tab+1;
			int currentPage =1;
			String filename ="";
			BoardVO board=new  BoardVO();
			board.setWritename(writename);
			board.setWriteid(writename);
			board.setTitle(title);
			board.setContent(content);
			board.setFilename(filename);
			board.setTab(tab);
			board.setParentid(parentid);
			boardservice.insertreply(board);
			int countPerPage=10;
			BoardpageList boardpageList
			=boardservice.pageList(currentPage, countPerPage);
			 ModelAndView mv = new ModelAndView();
			 mv.addObject("pagelist",boardpageList);
			 mv.addObject("mainpage","replyboard/pageList.jsp");
			 mv.setViewName("index");
			
			 return mv;
		}
		@RequestMapping("/chat")
		public ModelAndView chat(HttpSession session) {
		    ModelAndView mv = new ModelAndView();
		    try {
		        mv.addObject("id", session.getAttribute("id"));
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    mv.addObject("mainpage", "chat.jsp");
		    mv.setViewName("index");
		    return mv;
		}
		@RequestMapping("/gallery")
		public ModelAndView gallery() {
			  ModelAndView mv = new ModelAndView();
			  mv.addObject("mainpage","gallery.jsp");
			  mv.setViewName("index");
			return mv;
			  
		}
		@RequestMapping("/mail")
		public ModelAndView mail() {
			ModelAndView mv = new ModelAndView();
			mv.addObject("mainpage","mail/mail.jsp");
			  mv.setViewName("index");
			return mv;
			
		}
		@RequestMapping("/mailproc")
		public ModelAndView mailproc(String title,String msg) {
			ModelAndView mv = new ModelAndView();
			service.mailsend(title,msg);
			 mv.addObject("mainpage","/home/main.jsp");
			 
				mv.setViewName("index");
			return mv;
			
		}
		@RequestMapping("/phsearch")
		public ModelAndView phsearch(@RequestParam("query") String query,@RequestParam("field") String field,
				Integer currentPage
				) {
		 
		    if(currentPage==null) {
				currentPage=1;
			}
			
			Pagelist pagelist=phonebookservice.search(field,query,currentPage);
			System.out.println(pagelist.getTotalPage());
			ModelAndView mv=new ModelAndView();
			mv.addObject("pagelist",pagelist);
			mv.addObject("mainpage","phonebook/pagelist.jsp");
			mv.setViewName("index");
			return mv;
		    
		    
		    
		  
		}
		
		@RequestMapping("/boardsearch")
		public ModelAndView boardsearch(@RequestParam("query") String query,@RequestParam("field") String field,
				Integer currentPage
				) {
		 
		    if(currentPage==null) {
				currentPage=1;
			}
			
		    BoardpageList BoardpageList=boardservice.search(field,query,currentPage);
			System.out.println(BoardpageList.getTotalPage());
			ModelAndView mv=new ModelAndView();
			mv.addObject("pagelist",BoardpageList);
			mv.addObject("mainpage","replyboard/pageList.jsp");
			mv.setViewName("index");
			return mv;
		    
		    
		    
		  
		}

		}




	
		
				
				
			
		

		
		
	
	



