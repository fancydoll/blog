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
	//��ǰ�౻����ʱ�ͼ�������
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//����һ��conn����
	public static Connection getConnection(){
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/blog","root","108023");
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}