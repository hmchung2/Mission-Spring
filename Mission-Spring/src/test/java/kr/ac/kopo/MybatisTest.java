package kr.ac.kopo;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/config/spring/spring-mvc.xml"})
public class MybatisTest {
	@Autowired
	private DataSource dataSource;
		
	@Autowired	
	private SqlSessionFactory sqlFactory;
		
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Test
	public void 로그인테스트() throws Exception{
		MemberVO member = new MemberVO();
		member.setId("hmchung2");
		member.setPassword("12345");
		MemberVO userVO =  sessionTemplate.selectOne("member.MemberDAO.login" , member);
		assertNotNull(userVO);
	}
	
	
	@Ignore
	@Test
	public void DataSourceCreatetest() throws Exception{
		System.out.println("dataSource : " + dataSource);
		assertNotNull(dataSource);
	}
	
	@Test
	public void mybatisCreatetest() throws Exception{
		assertNotNull(sqlFactory);
		assertNotNull(sessionTemplate);
		
	}
	
	
	
}
