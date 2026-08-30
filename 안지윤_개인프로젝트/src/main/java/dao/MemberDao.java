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
	PreparedStatement ps = null;
	ResultSet rs = null;


	// =========================
	// 싱글톤
	// =========================
	private static MemberDao dao = new MemberDao();

	private MemberDao() {

	}

	public static MemberDao getDao() {
		return dao;
	}


	// =========================
	// 비밀번호 SHA-256 암호화
	// =========================
	public String encryptSHA256(String value)
			throws NoSuchAlgorithmException {

		String encryptData = "";

		MessageDigest sha =
				MessageDigest.getInstance("SHA-256");

		sha.update(value.getBytes());

		byte[] digest = sha.digest();

		for(int i = 0; i < digest.length; i++) {

			encryptData +=
					Integer.toHexString(
							digest[i] & 0xFF
					).toUpperCase();
		}

		return encryptData;
	}


	// =========================
	// 회원가입
	// =========================
	public int memberSave(MemberDto dto) {

		String sql =
				"insert into my_안지윤_member " +
				"(id, name, password, password_length, " +
				"email_1, email_2, reg_date) " +
				"values " +
				"('" + dto.getId() + "', " +
				"'" + dto.getName() + "', " +
				"'" + dto.getPassword() + "', " +
				"'" + dto.getPassword_length() + "', " +
				"'" + dto.getEmail_1() + "', " +
				"'" + dto.getEmail_2() + "', " +
				"to_date('" + dto.getReg_date() +
				"','YYYY-MM-DD HH24:MI:SS'))";

		int result = 0;

		try {

			con = DBConnection.getConnection();

			ps = con.prepareStatement(sql);

			result = ps.executeUpdate();

		} catch(Exception e) {

			System.out.println("memberSave 오류!");
			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}


	// =========================
	// 비밀번호 확인
	// =========================
	public int getCheckPassword(
			String id,
			String password) {

		int count = 0;

		String sql =
				"select count(*) as count " +
				"from my_안지윤_member " +
				"where id = ? " +
				"and password = ? " +
				"and exit_date is null";

		try {

			con = DBConnection.getConnection();

			ps = con.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if(rs.next()) {

				count =
						rs.getInt("count");
			}

		} catch(Exception e) {

			System.out.println(
					"getCheckPassword 오류!"
			);

			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return count;
	}


	// =========================
	// ID 중복확인
	// =========================
	public int checkId(String id) {

		int result = 0;

		String sql =
				"select count(*) as count " +
				"from my_안지윤_member " +
				"where id = ?";

		try {

			con = DBConnection.getConnection();

			ps = con.prepareStatement(sql);

			ps.setString(1, id);

			rs = ps.executeQuery();

			if(rs.next()) {

				result =
						rs.getInt("count");
			}

		} catch(Exception e) {

			System.out.println(
					"checkId 오류!"
			);

			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}


	// =========================
	// 로그인한 회원 이름 조회
	// =========================
	public String getloginName(
			String id,
			String password) {

		String name = "";

		String sql =
				"select name " +
				"from my_안지윤_member " +
				"where id = ? " +
				"and password = ? " +
				"and exit_date is null";

		try {

			con = DBConnection.getConnection();

			ps = con.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if(rs.next()) {

				name =
						rs.getString("name");
			}

		} catch(Exception e) {

			System.out.println(
					"getloginName 오류!"
			);

			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return name;
	}


	// =========================
	// 회원정보 조회
	// =========================
	public MemberDto getMemberInfo(String id) {

		MemberDto dto = null;

		String sql =
				"select id, name, password, password_length, " +
				"email_1, email_2, " +
				"to_char(reg_date,'yyyy-MM-dd hh24:mi:ss') as reg_date, " +
				"to_char(update_date,'yyyy-MM-dd hh24:mi:ss') as update_date, " +
				"to_char(exit_date,'yyyy-MM-dd hh24:mi:ss') as exit_date " +
				"from my_안지윤_member " +
				"where id = ?";

		try {

			con = DBConnection.getConnection();

			ps = con.prepareStatement(sql);

			ps.setString(1, id);

			rs = ps.executeQuery();

			if(rs.next()) {

				String name =
						rs.getString("name");

				String password =
						rs.getString("password");

				String password_length =
						rs.getString("password_length");

				String email_1 =
						rs.getString("email_1");

				String email_2 =
						rs.getString("email_2");

				String reg_date =
						rs.getString("reg_date");

				String update_date =
						rs.getString("update_date");

				String exit_date =
						rs.getString("exit_date");


				dto = new MemberDto(
						id,
						name,
						password,
						password_length,
						email_1,
						email_2,
						reg_date,
						update_date,
						exit_date
				);
			}

		} catch(Exception e) {

			System.out.println(
					"getMemberInfo 오류!"
			);

			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return dto;
	}


	// =========================
	// 회원정보 수정
	// =========================
	public int updateMember(MemberDto dto) {

		int result = 0;

		String sql =
				"update my_안지윤_member " +
				"set name = ?, " +
				"password = ?, " +
				"password_length = ?, " +
				"email_1 = ?, " +
				"email_2 = ?, " +
				"update_date = sysdate " +
				"where id = ? " +
				"and exit_date is null";

		try {

			con = DBConnection.getConnection();

			ps = con.prepareStatement(sql);

			ps.setString(
					1,
					dto.getName()
			);

			ps.setString(
					2,
					dto.getPassword()
			);

			ps.setString(
					3,
					dto.getPassword_length()
			);

			ps.setString(
					4,
					dto.getEmail_1()
			);

			ps.setString(
					5,
					dto.getEmail_2()
			);

			ps.setString(
					6,
					dto.getId()
			);

			result =
					ps.executeUpdate();

		} catch(Exception e) {

			System.out.println(
					"updateMember 오류!"
			);

			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}


	// =========================
	// 회원탈퇴
	// 실제 DELETE 아님
	// exit_date 기록하는 soft delete
	// =========================
	public int deleteMember(String id) {

		int result = 0;

		String sql =
				"update my_안지윤_member " +
				"set exit_date = sysdate " +
				"where id = ? " +
				"and exit_date is null";

		try {

			con = DBConnection.getConnection();

			ps = con.prepareStatement(sql);

			ps.setString(1, id);

			result =
					ps.executeUpdate();

		} catch(Exception e) {

			System.out.println(
					"deleteMember 오류!"
			);

			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}

}