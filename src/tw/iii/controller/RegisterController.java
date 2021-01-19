package tw.iii.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.iii.model.Member;
import tw.iii.model.MemberService;

@Controller
public class RegisterController {
	@Autowired
	private MemberService mbs;
	@RequestMapping(path = "/register.controller", method = RequestMethod.POST)
	public String registerAction(@RequestParam(name = "account") String account,@RequestParam(name = "password")String password
			,@RequestParam(name = "username")String userName,@RequestParam(name = "email")String email,@RequestParam(name = "phone")String phone,@RequestParam(name = "address")String address
			,@RequestParam(name = "birthday")Date birthday,@RequestParam(name = "gender")String gender,Model m) {
		Map<String, String>err = new HashMap<String, String>();
		boolean isaccount = mbs.checkaccount(account);
		Member mbean = new Member();
		if(account==null || account.length()==0) {
			err.put("account", "請輸入帳號");	
		}else if(isaccount) {
			err.put("repeat", "此帳號已被註冊，請換一個");
		}
		
		if(password==null || password.length()==0) {
			err.put("password", "請輸入密碼");	
		}
		if(userName==null || userName.length()==0) {
			err.put("userName", "請輸入姓名");	
		}
		if(email==null || email.length()==0) {
			err.put("email", "請輸入E-mail");	
		}
		if(phone==null || phone.length()==0) {
			err.put("phone", "請輸入電話");	
		}
		if(address==null || address.length()==0) {
			err.put("address", "請輸入地址");	
		}
		if(birthday==null ) {
			err.put("birthday", "請輸入生日");	
		}
		if(gender==null || gender.length()==0) {
			err.put("gender", "請輸入性別");	
		}
		m.addAttribute("err",err);
		if(err!=null&&!err.isEmpty()) {
			return "register.jsp";
		}
		mbean.setAccount(account);
		mbean.setPassword(password);
		mbean.setUserName(userName);
		mbean.setEmail(email);
		mbean.setPhone(phone);
		mbean.setAddress(address);
		mbean.setBirthday(birthday);
		mbean.setGender(gender);
		mbs.insert(mbean);
		
		m.addAttribute("selection","all");
			
		return "success.jsp";
	}
}
