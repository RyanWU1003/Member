package tw.iii.model;

import java.util.Date;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDAO implements IMember {
	@Autowired
	private SessionFactory sessionfactory;
	
	public MemberDAO(SessionFactory sessionfactory) {
		this.sessionfactory=sessionfactory;
	}

	@Override
	public Member insert(Member mb) {
		Session session = sessionfactory.getCurrentSession();
		Member mbr =session.get(Member.class, mb.getAccount());
		
		if(mbr == null) {
			session.save(mb);
			System.out.println("註冊成功");
			return mb;
		}
		System.out.println("已有此會員");
		return null;
	}

	@Override
	public Member select(String Account) {
		Session session = sessionfactory.getCurrentSession();
		Member mbr = session.get(Member.class, Account);
		return mbr;
	}

	@Override
	public List<Member> selectAll() {
		Session session = sessionfactory.getCurrentSession();
		Query<Member> mb=session.createQuery("from member",Member.class);
		return mb.list();
	}

	@Override
	public Member update(String Account,String Password) {
		Session session = sessionfactory.getCurrentSession();
		Member mbr = session.get(Member.class, Account);
		if(mbr != null) {
			mbr.setPassword(Password);
			session.save(mbr);
		}
		
		return mbr;
	}

	@Override
	public Member updateAll(String Account,String userName, String email, String phone, String address, Date birthday, String gender) {
		Session session = sessionfactory.getCurrentSession();
		Member mbr = session.get(Member.class, Account);
		
		if(mbr != null) {
			mbr.setUserName(userName);
			mbr.setEmail(email);
			mbr.setPhone(phone);
			mbr.setAddress(address);
			mbr.setBirthday(birthday);
			mbr.setGender(gender);
			
			session.save(mbr);
		}
		
		return mbr;
	}

	@Override
	public boolean checkLogin(String Account, String Password) {
		Session session = sessionfactory.getCurrentSession();
		Query<Object> query = session.createQuery("from member where account=?1 and password=?2");
		query.setParameter(1, Account);
		query.setParameter(2, Password);
		return query.list().isEmpty()?false:true;
	}

	@Override
	public boolean forgetpwd(String Account, String email) {
		Session session = sessionfactory.getCurrentSession();
		Query<Object> query = session.createQuery("from member where account=?1 and email=?2");
		query.setParameter(1, Account);
		query.setParameter(2, email);
		return query.list().isEmpty()?false:true;
	}

	@Override
	public boolean changepwd(String Password) {
		Session session = sessionfactory.getCurrentSession();
		Query<Object> query = session.createQuery("from member where password=?1");
		query.setParameter(1, Password);
		return query.list().isEmpty()?false:true;
	}

}
