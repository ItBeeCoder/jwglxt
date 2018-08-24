package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.connection.DataConn;



public class UserDao {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static DataConn dc = null;
	//增加用户
	public static  void add(User user) throws Exception{
		conn = dc.getConnection();
	    String sql = "insert into cms_user(user_name,psw) values('"+ user.getUsername() +"','"+ user.getPsw() +"')";
	    stmt = conn.createStatement();
	    int result = stmt.executeUpdate(sql);
	    dc.release(conn);
	}
	
    //删除用户
	public static void del(int id) throws Exception{
		conn = dc.getConnection();
	    String sql = "delete from cms_user where id ='"+id+"'";
	    stmt = conn.createStatement();
	    int result = stmt.executeUpdate(sql);
		dc.release(conn);
	}
	
	//查询全部用户
	public static List<User> list() throws Exception{
		conn = dc.getConnection();
	    String sql = "select * from cms_user"; 
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(sql);
	    
	    List<User> userList = new ArrayList<User>();
	    while(rs.next()){
	    	User user = new User();
	    	user.setId(rs.getInt(1));
	    	user.setUsername(rs.getString(2));
	    	user.setPsw(rs.getString(3));
	    	userList.add(user);
	    }
		dc.release(conn);
	   
		return userList;
	}
	
	//根据用户名查询用户密码
	public static String queryByName(String username) throws Exception{
		String result = "";
		conn = dc.getConnection();
		String sql = "select psw from cms_user as cu where cu.user_name = '"+username+"'";
		System.out.println("sql语句为："+sql);
		stmt = conn.createStatement();
	    rs = stmt.executeQuery(sql);
		if(rs.next()){
			result = rs.getString(1);
		}
		dc.release(conn);
		return result;
	}

	//根据id查询用户
	public static User queryById(int id) throws Exception{
		User user =new User();
		conn = dc.getConnection();
		String sql = "select id,user_name,psw from cms_user where cms_user.id = '"+id+"'";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPsw(rs.getString(3));
		}
		dc.release(conn);
		return user;
	}

	//更新用户
	public static void update(User user) throws Exception{
		conn = dc.getConnection();
		String sql = "update cms_user as cu set cu.user_name = '"+ user.getUsername() +"',cu.psw = '"+ user.getPsw() +"'where cu.id ='"+user.getId()+"'";
		stmt = conn.createStatement();
	    int result = stmt.executeUpdate(sql);
		dc.release(conn);
	}
    
    
}
