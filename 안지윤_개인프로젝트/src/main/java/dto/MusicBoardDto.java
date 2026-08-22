package dto;

public class MusicBoardDto {

    private int board_no;
    private String id;
    private int music_no;
    private String recommend_reason;
    private String board_content;
    private String reg_date;
    private int hit;

    private String title;
    private String artist;
    private String album_image;

    // 좋아요 수
    private int like_count;


    public MusicBoardDto() {

    }


    public MusicBoardDto(
            int board_no,
            String id,
            int music_no,
            String recommend_reason,
            String board_content,
            String reg_date,
            int hit) {

        this.board_no = board_no;
        this.id = id;
        this.music_no = music_no;
        this.recommend_reason = recommend_reason;
        this.board_content = board_content;
        this.reg_date = reg_date;
        this.hit = hit;
    }


    public int getBoard_no() {
        return board_no;
    }

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getMusic_no() {
        return music_no;
    }

    public void setMusic_no(int music_no) {
        this.music_no = music_no;
    }


    public String getRecommend_reason() {
        return recommend_reason;
    }

    public void setRecommend_reason(String recommend_reason) {
        this.recommend_reason = recommend_reason;
    }


    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }


    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }


    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    public String getAlbum_image() {
        return album_image;
    }

    public void setAlbum_image(String album_image) {
        this.album_image = album_image;
    }


    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

}