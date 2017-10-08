package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MyConnection {
	Connection conn = null;
	PreparedStatement qs = null;
	ResultSet rs = null;
	//当前类被加载时就加载驱动
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//返回一个conn对象
	public static Connection getConnection(){
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/blog","root","108023");
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}