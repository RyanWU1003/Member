package tw.iii.model;


import java.sql.Date;
import java.util.List;

public interface IMemberDao {
	public Member insert(Member mb);
	public Member select(String Account);
	public List<Member> selectAll();
	public Member update(String Account,String Password);
	public Member updateAll(String Account,String userName,String email,String phone,String address,Date birthday,String gender);
	public boolean checkLogin(String Account,String Password);
	public boolean forgetpwd(String Account,String email);
	public boolean changepwd(String Password);
	public boolean checkAccount(String Account);
	
}
