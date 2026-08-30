package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.MusicDto;

public class MusicDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private static MusicDao dao = new MusicDao();

    private MusicDao() {

    }

    public static MusicDao getDao() {
        return dao;
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
    
    
    
    
    
    
    
    
}