package Article;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.MyConnection;
import Article.article;
public class ArticleConnection {
	Connection conn = null;
	PreparedStatement qs = null;
	ResultSet rs = null;
//	public int setArticle(String name,String img,String dec,String xname){
//		int xid = 0;
//		int flag = 0;
//		try{
//			conn = MyConnection.connect();
//			qs = conn.prepareStatement("select id from major where xname=?");
//			qs.setString(1,xname);
//			rs = qs.executeQuery();
//			if(rs.next()){
//				xid = rs.getInt(1);
//			}
//			if(xid != 0){
//				qs = conn.prepareStatement("insert into article(`name`,`img`,`dec`,`xid`) values (?,?,?,?)");
//				qs.setString(1, name);
//				qs.setString(2, img);
//				qs.setString(3, dec);
//				qs.setInt(4, xid);
//				flag = qs.executeUpdate();
//			}
//			return flag;
//		}catch(Exception e){
//			e.printStackTrace();
//			return flag;
//		}
//	}
	//查询文章分类
//	public List findMajor(){
//		conn = MyConnection.connect();
//		try{
//			qs = conn.prepareStatement("select * from major");
//			rs = qs.executeQuery();
//			List list = new ArrayList();
//			while(rs.next()){
//				major m1 = new major();
//				m1.setId(rs.getInt(1));
//				m1.setxname(rs.getString(2));
//				list.add(m1);
//			}
//			return list;
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//		return null;
//	}
	//查询文章
	public List getArticle(int index,int count){
		conn = MyConnection.getConnection();
		try {
			qs = conn.prepareStatement("select * from article limit ?,?");
			qs.setInt(1,index);
			qs.setInt(2,count);
			rs = qs.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				article m1 = new article();
				m1.setName(rs.getString(2));
				m1.setImg(rs.getString(3));
				m1.setDec(rs.getString(4));
				list.add(m1);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//查询不同分类不同文章
	public List findArticle(int xid,int index,int count){
		conn = MyConnection.getConnection();
		try {
			qs = conn.prepareStatement("select * from article where xid= ? limit ?,?");
			qs.setInt(1,xid);
			qs.setInt(2,index);
			qs.setInt(3,count);
			rs = qs.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				article m1 = new article();
				m1.setId(rs.getInt(1));
				m1.setName(rs.getString(2));
				m1.setImg(rs.getString(3));
				m1.setDec(rs.getString(4));
				m1.setXid(rs.getInt(5));
				list.add(m1);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
