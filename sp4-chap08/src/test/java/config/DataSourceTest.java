package config;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appCtx.xml"})
public class DataSourceTest {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void test() throws SQLException {
		assertNotNull(dataSource);
		System.out.println(dataSource);
		
		Connection connection = dataSource.getConnection();
		PreparedStatement pstmt = connection.prepareStatement("select * from member");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("email"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getString("name"));
			System.out.println("=====================================");
		}
	}
}
