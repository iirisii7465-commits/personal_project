package dto;

public class MusicDto {

    private int music_no;
    private String title;
    private String artist;
    private String album_image;

    public int getMusic_no() {
        return music_no;
    }

    public void setMusic_no(int music_no) {
        this.music_no = music_no;
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
}