package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
//오라클에접속할려면 클래스를 만들어야됨
	
//DB 접속	
		
	
	public static Connection getConnection(){
	
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String db_ur1 = "jdbc:oracle:thin:@1.245.91.227:1523/xe"; //이건아이피로접속하는거
		String db_user="track27_11g";
		String db_password ="1234";
		
		try {
			con = DriverManager.getConnection(db_ur1, db_user, db_password);
		} catch (SQLException e) {
			System.out.println("DB접속오류");
			e.printStackTrace();
		}
		
		
		return con;
		
	}

	
	//DB연결종료
	public static void closeDB(Connection con, PreparedStatement ps, ResultSet rs) {
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //null값은 널인지아닌지 비교밖에안됨 , 메모리주소가없다	
		
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	
	
	
	
		}
	
	
}
