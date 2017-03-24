/**    
 *  name：DatabaseConnection   
 *  description：   
 *  author：Lcrit_Z   
 *  date：2017年3月23日 上午11:08:46 
 *  @version 
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *   @date：2017年3月23日 上午11:08:46 
 *  @author Lcrit_Z
 *  description：   
 */
public class DatabaseConnection {
	
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/testmysql1?autoReconnect=true&useSSL=true";
	public static final String USER_NAME = "root";
	public static final String USER_PW = "123";
	
	private Connection conn = null;

	/**
	 * 
	 */
	public DatabaseConnection() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL,USER_NAME,USER_PW);
		} catch (SQLException e) {
			e.printStackTrace();
		// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public Connection getConn(){
		return this.conn;
	}
	
	public void close() {
		if(this.conn != null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
}
