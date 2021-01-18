package tw.iii.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service("MemberService")
public class MemberService {
	@Autowired
	private MemberDAO mDao;
	
	public Member insert(Member mb) {
		
		return mDao.insert(mb);
		
	};
	
	public Member select(String Account) {
		
		return mDao.select(Account);
		
	};
	
	public List<Member> selectAll(){
		
		return mDao.selectAll();
		
	};
	
	public Member update(String Account,String Password) {
		
		return mDao.update(Account, Password);
	};
	
	public Member updateAll(String Account,String userName,String email,String phone,String address,Date birthday,String gender) {
		
		return mDao.updateAll(Account, userName, email, phone, address, birthday, gender);
	};
	
	public boolean checkLogin(String Account,String Password) {
		
		return mDao.checkLogin(Account, Password);
	};
	
	public boolean forgetpwd(String Account,String email) {
		
		return mDao.forgetpwd(Account, email);
	};
	
	public boolean changepwd(String Password) {
		
		return mDao.changepwd(Password);
	};
}
