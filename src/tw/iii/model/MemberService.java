package tw.iii.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberService {
	@Autowired
	private MemberDAO mbrDao;
	
	public Member insert(Member mb) {
		
		return mbrDao.insert(mb);
		
	};
	
	public Member select(String Account) {
		
		return mbrDao.select(Account);
		
	};
	
	public List<Member> selectAll(){
		
		return mbrDao.selectAll();
		
	};
	
	public Member update(String Account,String Password) {
		
		return mbrDao.update(Account, Password);
	};
	
	public Member updateAll(String Account,String userName,String email,String phone,String address,Date birthday,String gender) {
		
		return mbrDao.updateAll(Account, userName, email, phone, address, birthday, gender);
	};
	
	public boolean checkLogin(String Account,String Password) {
		
		return mbrDao.checkLogin(Account, Password);
	};
	
	public boolean forgetpwd(String Account,String email) {
		
		return mbrDao.forgetpwd(Account, email);
	};
	
	public boolean changepwd(String Password) {
		
		return mbrDao.changepwd(Password);
	};
}
