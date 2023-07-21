package controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class Controll {
	@RequestMapping("/index")
    public String index() {
        return "/WEB-INF/index.jsp";
    }


   // @RequestMapping("/restindex")
   // @ResponseBody
    public String restindex() {
        return "restindex test";
    }

 
}
