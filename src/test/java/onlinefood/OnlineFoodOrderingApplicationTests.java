package onlinefood;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import onlinefood.dao.AdminDao;
import onlinefood.dao.UserDao;
import onlinefood.model.Admin;
import onlinefood.model.User;

@SpringBootTest
class OnlineFoodOrderingApplicationTests {
	@Autowired
private UserDao dao;
	@Autowired
	private AdminDao ad;
	@Test
	void contextLoads() {
	}
	@Test
	@Order(1)
	public void testAddUser()
	{
		User u=new User();
		
		u.setName("aisha");
		u.setPhoneNumber("7856984785");
		u.setAddress("kolhapur");
		u.setEmailId("aisha@gmail.com");
		u.setPassword("aisha@16");
		dao.save(u);
	}
	@Test
	@Order(2)
	public void testLoginUser()
	{
		User u=dao.findByEmailIdAndPassword("aisha@gmail.com", "aisha@16");
		dao.save(u);
	}
	@Test
	@Order(3)
	public void getUserById()
	{
		dao.findById(2).get();
	}
	@Test
	@Order(4)
	public void testUpdateUser()
	{
		User u=dao.findByEmailId("aisha@gmail.com");
		u.setName("aisha1");
		u.setPhoneNumber("7856923145");
		u.setAddress("pune");
		u.setPassword("aisha@16");
		dao.save(u);
	}
	@Test
	@Order(5)
	public void testDeleteUser()
	{
		User u=dao.findByEmailId("aisha@gmail.com");
		dao.delete(u);
	}
	
	@Test
	@Order(6)
	public void testAddAdmin()
	{
		Admin a=new Admin();
		a.setName("shweta");
		a.setMobileNumber("5896547895");
		a.setEmailId("shweta@gmail.com");
		a.setPassword("shweta@16");
		ad.save(a);
	}
	@Test
	@Order(7)
	public void testAdminLogin()
	{
		Admin a=ad.findByEmailIdAndPassword("shweta@gmail.com", "shweta@16");
		ad.save(a);
	}
	@Test
	@Order(8)
	public void testAdminDetailsByEmailId()
	{
		ad.findByEmailId("shweta@gmail.com");
	}
	@Test
	@Order(9)
	public void testAdminUpdate()
	{
		Admin a=ad.findByEmailId("shweta@gmail.com");
		a.setName("aisha");
		a.setEmailId("shweta@gmail.com");
		a.setMobileNumber("5896478523");
		a.setPassword("shweta@16");
		ad.save(a);

	}
	
	@Test
	@Order(10)
	public void testAdminDeleteByEmailId()
	{
		Admin a=ad.findByEmailId("shweta@gmail.com");
		ad.delete(a);
	}
	
}
