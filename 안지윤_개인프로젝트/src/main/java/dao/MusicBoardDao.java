package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.MusicBoardDto;
import dto.MusicDto;

public class MusicBoardDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static MusicBoardDao dao = new MusicBoardDao();

	private MusicBoardDao() {

	}

	public static MusicBoardDao getDao() {
		return dao;
	}

	public int saveBoard(MusicBoardDto dto) {

		int result = 0;

		try {

			con = DBConnection.getConnection();

			// 1. 다음 게시글 번호 구하기
			String sql = "select nvl(max(board_no), 0) + 1 " + "from my_안지윤_music_board";

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			int board_no = 0;

			if (rs.next()) {
				board_no = rs.getInt(1);
			}

			rs.close();
			ps.close();

			// 2. 게시글 저장
			sql = "insert into my_안지윤_music_board " + "(board_no, id, music_no, recommend_reason, board_content) "
					+ "values (?, ?, ?, ?, ?)";

			ps = con.prepareStatement(sql);

			ps.setInt(1, board_no);
			ps.setString(2, dto.getId());
			ps.setInt(3, dto.getMusic_no());
			ps.setString(4, dto.getRecommend_reason());
			ps.setString(5, dto.getBoard_content());

			result = ps.executeUpdate();

		} catch (Exception e) {

			System.out.println("saveBoard 오류!");
			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}

	public ArrayList<MusicBoardDto> getBoardList(String select, String search, int start, int end) {

		ArrayList<MusicBoardDto> list = new ArrayList<MusicBoardDto>();

		String sql = "select * from ( " + "    select rownum rnum, tbl.* " + "    from ( " + "        select b.*, "
				+ "               m.title, " + "               m.artist, " + "               m.album_image, "
				+ "               (select count(*) " + "                  from my_안지윤_music_like l "
				+ "                 where l.board_no = b.board_no) as like_count "
				+ "        from my_안지윤_music_board b " + "        join my_안지윤_music m "
				+ "        on b.music_no = m.music_no " + "        where " + select + " like ? "
				+ "        order by b.board_no desc " + "    ) tbl " + ") " + "where rnum >= ? and rnum <= ?";

		try {

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, "%" + search + "%");
			ps.setInt(2, start);
			ps.setInt(3, end);

			rs = ps.executeQuery();

			while (rs.next()) {

				MusicBoardDto dto = new MusicBoardDto();

				dto.setBoard_no(rs.getInt("board_no"));

				dto.setId(rs.getString("id"));

				dto.setMusic_no(rs.getInt("music_no"));

				dto.setRecommend_reason(rs.getString("recommend_reason"));

				dto.setBoard_content(rs.getString("board_content"));

				dto.setReg_date(rs.getString("reg_date"));

				dto.setHit(rs.getInt("hit"));

				dto.setTitle(rs.getString("title"));

				dto.setArtist(rs.getString("artist"));

				dto.setAlbum_image(rs.getString("album_image"));

				// 좋아요 수
				dto.setLike_count(rs.getInt("like_count"));

				list.add(dto);
			}

		} catch (Exception e) {

			System.out.println("getBoardList 오류!");
			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return list;
	}

	 //음악목록가져오기
    public ArrayList<MusicDto> getMusicList(){
    ArrayList<MusicDto>list = new ArrayList<MusicDto>();
    
    String sql = "select * from my_안지윤_music order by music_no";
    
    
    try {

        con = DBConnection.getConnection();
        ps = con.prepareStatement(sql);

       

        rs = ps.executeQuery();

        while(rs.next()) {

        	 MusicDto dto = new MusicDto();

             dto.setMusic_no(rs.getInt("music_no"));
             dto.setTitle(rs.getString("title"));
             dto.setArtist(rs.getString("artist"));
             dto.setAlbum_image(rs.getString("album_image"));

             list.add(dto);
            
        }

    } catch(Exception e) {

        System.out.println("getMemberInfo 오류!");
        e.printStackTrace();

    } finally {

        DBConnection.closeDB(con, ps, rs);
    }

    
    return list;
    
    }
    
	
	
	// 페이징,검색
	public int getTotalCount(String select, String search) {

		int count = 0;

		String sql = "select count(*) as count " + "from my_안지윤_music_board b " + "join my_안지윤_music m "
				+ "on b.music_no = m.music_no " + "where " + select + " like ?";

		try {

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, "%" + search + "%");

			rs = ps.executeQuery();

			if (rs.next()) {
				count = rs.getInt("count");
			}

		} catch (Exception e) {

			System.out.println("getTotalCount 오류!");
			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return count;
	}

	public MusicBoardDto getBoardView(int no) {
		MusicBoardDto dto = null;

		String sql = "select b.*, m.title, m.artist, m.album_image " + "from my_안지윤_music_board b "
				+ "join my_안지윤_music m " + "on b.music_no = m.music_no " + "where b.board_no = ?";

		try {

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, no);

			rs = ps.executeQuery();

			if (rs.next()) {

				dto = new MusicBoardDto();

				dto.setBoard_no(rs.getInt("board_no"));
				dto.setId(rs.getString("id"));
				dto.setMusic_no(rs.getInt("music_no"));
				dto.setRecommend_reason(rs.getString("recommend_reason"));
				dto.setBoard_content(rs.getString("board_content"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setHit(rs.getInt("hit"));

				dto.setTitle(rs.getString("title"));
				dto.setArtist(rs.getString("artist"));
				dto.setAlbum_image(rs.getString("album_image"));
			}

		} catch (Exception e) {

			System.out.println("getBoardView 오류!");
			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return dto;

	}

	// 업데이트
	public int updateBoard(MusicBoardDto dto) {

		int result = 0;

		String sql = "update my_안지윤_music_board " + "set recommend_reason = ?, " + "    board_content = ? "
				+ "where board_no = ?";

		try {

			con = DBConnection.getConnection();

			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getRecommend_reason());
			ps.setString(2, dto.getBoard_content());
			ps.setInt(3, dto.getBoard_no());

			result = ps.executeUpdate();

		} catch (Exception e) {

			System.out.println("updateBoard 오류!");
			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}

	// 삭제
	public int deleteBoard(int board_no) {

		int result = 0;

		try {

			con = DBConnection.getConnection();

			// 1. 해당 게시글 좋아요 먼저 삭제
			String sqlLike =
					"delete from my_안지윤_music_like " +
					"where board_no = ?";

			ps = con.prepareStatement(sqlLike);

			ps.setInt(1, board_no);

			ps.executeUpdate();

			ps.close();


			// 2. 게시글 삭제
			String sqlBoard =
					"delete from my_안지윤_music_board " +
					"where board_no = ?";

			ps = con.prepareStatement(sqlBoard);

			ps.setInt(1, board_no);

			result = ps.executeUpdate();


		} catch(Exception e) {

			System.out.println("deleteBoard 오류!");
			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}

	// 조회수증가

	public int setHitCount(int board_no) {

		int result = 0;

		String sql = "update my_안지윤_music_board " + "set hit = hit + 1 " + "where board_no = ?";

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, board_no);

			result = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("setHitCount 오류!");
			e.printStackTrace();

		} finally {
			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}

	// 좋아요카운트
	public int getLikeCount(int board_no) {

		int count = 0;

		String sql = "select count(*) as count " + "from my_안지윤_music_like " + "where board_no = ?";

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, board_no);

			rs = ps.executeQuery();

			if (rs.next()) {
				count = rs.getInt("count");
			}

		} catch (Exception e) {
			System.out.println("getLikeCount 오류!");
			e.printStackTrace();

		} finally {
			DBConnection.closeDB(con, ps, rs);
		}

		return count;
	}

	// 상세보기좋아요
	public int insertLike(int board_no, String id) {

		int result = 0;

		String sql = "insert into my_안지윤_music_like " + "(board_no, id) " + "values (?, ?)";

		try {
			con = DBConnection.getConnection();

			ps = con.prepareStatement(sql);

			ps.setInt(1, board_no);
			ps.setString(2, id);

			result = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertLike 오류!");
			e.printStackTrace();

		} finally {
			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}

	// 좋아요 했는지 확인
	public boolean checkLike(int board_no, String id) {

		boolean result = false;

		String sql = "select count(*) as count " + "from my_안지윤_music_like " + "where board_no = ? and id = ?";

		try {

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, board_no);
			ps.setString(2, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				if (rs.getInt("count") > 0) {
					result = true;
				}

			}

		} catch (Exception e) {

			System.out.println("checkLike 오류!");
			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}

	// 좋아요 취소
	public int deleteLike(int board_no, String id) {

		int result = 0;

		String sql = "delete from my_안지윤_music_like " + "where board_no = ? " + "and id = ?";

		try {

			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, board_no);
			ps.setString(2, id);

			result = ps.executeUpdate();

		} catch (Exception e) {

			System.out.println("deleteLike 오류!");
			e.printStackTrace();

		} finally {

			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}

}