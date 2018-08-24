package util.connection;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.AbstractComboPooledDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;



public class DataConn {

	 private static ComboPooledDataSource dataSource=null;  
	    static{  
	        dataSource=new ComboPooledDataSource();
	        ((AbstractComboPooledDataSource) dataSource).setUser("root");// 用户姓名
	        dataSource.setPassword("1234abcd");// 用户密码
	        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dbtest");// MySQL数据库连接url
	        try {
				dataSource.setDriverClass("com.mysql.jdbc.Driver");
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }  
	      
	     
	    public static Connection getConnection(){  
	        Connection conn=null;  
	        try {  
	             conn=dataSource.getConnection();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        return conn;  
	    }  
	  
	    /**
	     * @param conn
	     * @return
	     */
	    public static Statement createStmt(Connection conn) {
	    	Statement stmt = null;
	    	try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	return stmt;
	    }
	    
	    /**
	     * @param conn
	     * @param sql
	     * @return
	     */
	    public static PreparedStatement preparedStmt(Connection conn, String sql) {
	    	PreparedStatement pstmt = null;
	    	try {
				pstmt = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	return pstmt;
	    }
	    
	    /**
	     * @param stmt
	     * @param sql
	     * @return
	     */
	    public static ResultSet executeQuery(Statement stmt , String sql) {
	    	ResultSet rs = null;
	    	try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	return rs;
	    }
	    
	    /**
	     * @param conn
	     */
	    public static void close(Connection conn) {
	    	if(conn != null) {
	    		try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		conn = null;
	    	}
	    }
	    
	    /**
	     * @param stmt
	     */
	    public static void close(Statement stmt) {
	    	if(stmt != null) {
	    		try {
	    			stmt.close();
	    		} catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    		stmt = null;
	    	}
	    }
	    
	    /**
	     * @param rs
	     */
	    public static void close(ResultSet rs) {
	    	if(rs != null) {
	    		try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		
	    		rs = null;
	    	}
	    }

	//释放链接
	public static void release(Connection conn){
		if(conn!=null){
			try{
				//将Connection连接对象还给数据库连接池
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
