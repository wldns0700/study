package book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import book.service.BookService;
import book.vo.BookVO;


@RestController
public class Bookresapi {
	ModelAndView mv = new ModelAndView();
	@Autowired
	BookService service;
	
	@RequestMapping("/index")
	public String index() {
		return "/WEB-INF/index.jsp";
		
	}
	
	
	
	@PostMapping("/bookap")
	public int insert(@RequestBody BookVO m) {

	
		int result=service.insert(m);
		
		return result;
		
		
	}
	
	//@RequestMapping(value = "/member",method = RequestMethod.GET,params = "id")
	@PutMapping("/bookap/${idx}")
	public BookVO findone(@PathVariable int idx) {
		BookVO book = new BookVO();
		book=service.findOneById(idx);
		
		 return book;
	}
	@PutMapping("/")
	public List<BookVO> findall() {
		List<BookVO> list = new ArrayList<BookVO>();
		list.addAll(service.findAll());
		 return list;
	}
	
	@PutMapping("/bookap/${idx}")
	public int update(int idx,@RequestBody BookVO m) {
		int result=service.update(idx,m);
		return result;
	}
	//curl : curl http:s//localhost:8080/member -v -X DELETE
	@DeleteMapping("/bookap/${idx}")
	public int memberDelete(@PathVariable int idx) {
		int result=service.delete(idx);
		return result;
	}
	
	
}
