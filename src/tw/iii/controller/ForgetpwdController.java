package tw.iii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.iii.model.MemberService;

@Controller
public class ForgetpwdController {
	@Autowired
	private MemberService mbs;
	@RequestMapping(path = "/forgetpwd.controller",method = RequestMethod.POST)
	public String forgetpwd(String Account,String email,Model m) {
		
		
		return "";
	}
}
