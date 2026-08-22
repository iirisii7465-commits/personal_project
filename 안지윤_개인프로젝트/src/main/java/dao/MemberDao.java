package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnection;
import dto.MemberDto;

public class MemberDao {
	
	Connection con = null;
	PreparedStatement ps =null;
	ResultSet rs = null;
	 private static MemberDao dao = new MemberDao();

	    private MemberDao() {

	    }

	    public static MemberDao getDao() {
	        return dao;
	    }

	//비밀번호암호화
	public String encryptSHA256(String value) throws NoSuchAlgorithmException {
		String encryptData = "";
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		sha.update(value.getBytes());

		byte[] digest = sha.digest();
		for (int i = 0; i < digest.length; i++) {
			encryptData += Integer.toHexString(digest[i] & 0xFF).toUpperCase();
		}

		return encryptData;
	}

	public int memberSave(MemberDto dto) {
		String sql ="insert into my_안지윤_member "
		        + "(id,name,password,password_length,email_1,email_2,reg_date) "
		        + "values "
		        + "('"+dto.getId()+"','"+dto.getName()+"','"+dto.getPassword()+"',"
		        + "'"+dto.getPassword_length()+"','"+dto.getEmail_1()+"','"+dto.getEmail_2()+"',"
		        + "to_date('"+dto.getReg_date()+"','YYYY-MM-DD HH24:MI:SS'))";
		int result =0;
		try {
			
			con=DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
					
			
		}catch(Exception e) {
			System.out.println("memberSave오류!");
			e.printStackTrace();
		}finally {	DBConnection.closeDB(con, ps, rs);	}
		
	
		
		
		
		return result;
	}

	public int getCheckPassword(String id, String password) {
		String sql ="SELECT COUNT(*) AS count\r\n"
				+ "FROM my_안지윤_member\r\n"
				+ "WHERE id = '"+id+"'\r\n"
				+ "AND password = '"+password+"'";
		
		int count =0;
	try {
			
			con=DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		if(rs.next()) {
			count=rs.getInt("count");
		}
			
		}catch(Exception e) {
			System.out.println("getloginName오류!");
			e.printStackTrace();
		}finally {	DBConnection.closeDB(con, ps, rs);	}
		
		return count;
	}

	public int checkId(String id) {
		    int result = 0;

		    String sql = "select count(*) as count "
		               + "from my_안지윤_member "
		               + "where id = ?";

		    try {

		        con = DBConnection.getConnection();
		        ps = con.prepareStatement(sql);

		        ps.setString(1, id);

		        rs = ps.executeQuery();

		        if(rs.next()) {
		            result = rs.getInt("count");
		        }

		    } catch(Exception e) {
		        System.out.println("CheckId오류!");
		        e.printStackTrace();

		    } finally {
		        DBConnection.closeDB(con, ps, rs);
		    }

		    return result;
		}
//로그인한이름 가져오는메소드
	public String getloginName(String id, String password) {

	    String name = "";

	    String sql =
	        "select name " +
	        "from my_안지윤_member " +
	        "where id = ? " +
	        "and password = ?";

	    try {

	        con = DBConnection.getConnection();

	        ps = con.prepareStatement(sql);

	        ps.setString(1, id);
	        ps.setString(2, password);

	        rs = ps.executeQuery();

	        if(rs.next()) {
	            name = rs.getString("name");
	        }

	    } catch(Exception e) {

	        System.out.println("getloginName 오류!");
	        e.printStackTrace();

	    } finally {

	        DBConnection.closeDB(con, ps, rs);
	    }

	    return name;
	}

	//회원정보조회
	public MemberDto getMemberInfo(String id) {

	    MemberDto dto = null;

	    String sql =
	        "select id, name, password, password_length, email_1, email_2, " +
	        "to_char(reg_date,'yyyy-MM-dd hh24:mi:ss') as reg_date, " +
	        "to_char(exit_date,'yyyy-MM-dd hh24:mi:ss') as exit_date " +
	        "from my_안지윤_member " +
	        "where id = ?";

	    try {

	        con = DBConnection.getConnection();
	        ps = con.prepareStatement(sql);

	        ps.setString(1, id);

	        rs = ps.executeQuery();

	        if(rs.next()) {

	            String name = rs.getString("name");
	            String password = rs.getString("password");
	            String password_length = rs.getString("password_length");
	            String email_1 = rs.getString("email_1");
	            String email_2 = rs.getString("email_2");
	            String reg_date = rs.getString("reg_date");
	            String exit_date = rs.getString("exit_date");

	            dto = new MemberDto(
	                id, name, password, password_length,
	                email_1, email_2, reg_date, exit_date
	            );
	        }

	    } catch(Exception e) {

	        System.out.println("getMemberInfo 오류!");
	        e.printStackTrace();

	    } finally {

	        DBConnection.closeDB(con, ps, rs);
	    }

	    return dto;
	}
}