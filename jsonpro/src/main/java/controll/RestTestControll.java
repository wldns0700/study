package controll;

import java.util.ArrayList;
import java.util.List;

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

import VO.MemberVO;

@RestController
public class RestTestControll {
	
	//@controller는 함수의 리턴값이 string일 때 viewpage를 의미한다.
	//@RequestMapping("/index")
	public String index() {
		return "rest ap test";
	}
	
	//@RequestMapping(value = "/member",method = RequestMethod.GET,params = "id")
	public String memberselect() {
		return "rest ap test";
	}
	//curl : curl http:s//localhost:8080/member -v -X get
	/*
	 * @GetMapping("/member") public String memberFindOne() { return
	 * "member find one"; }
	 */
	//curl : curl http:s//localhost:8080/member -v -X POST
	
	
	// curl : curl http://localhost:8080/member/1/1111/1231/313 -x -X POST
	//curl pd "{\"id\":\"test1\", /"password\":\"1111\"}"-H "content-Type: application/json" -x POST http://localhost:8080/member
	@PostMapping("/member")
	public String memberInsert() {
		return "member insert";
	}
	//curl : curl http:s//localhost:8080/member -v -X PUT
	@PutMapping("/member")
	public String memberUpdate() {
		return "member update one";
	}
	//curl : curl http:s//localhost:8080/member -v -X DELETE
	@DeleteMapping("/member")
	public String memberDelete() {
		return "member delete";
	}
	@GetMapping("/member")
	public String memberFindOne(String id) {
		System.out.println(id);
		return "member find one";
	}
	//localhost:8080/member/admin
	@RequestMapping("/getmember/{id}")
	public String getMember(@PathVariable String id) {
		System.out.println(id);
		return "get member";
	}
	@GetMapping("/getmember")
	public MemberVO getMember() {
	
		return new MemberVO("admin","1234");
	}
	@GetMapping("/getmembers")
	public List<MemberVO> getMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		list.add(new MemberVO("admin1","1234"));
		list.add(new MemberVO("admin2","1234"));
		list.add(new MemberVO("admin3","1234"));
		list.add(new MemberVO("admin4","1234"));
		list.add(new MemberVO("admin5","1234"));
		return list;
	}
	@PostMapping("/sendmember")
	public MemberVO sendMember(@RequestBody MemberVO m) {
		System.out.println(m.toString());
		return m;
	}
	@RequestMapping("/MODELANDVIEW")
	public ModelAndView MODELANDVIE() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("test","1234");
		mv.setViewName("/WEB-INF/index.jsp");
		return mv;
		
	}
	
}
