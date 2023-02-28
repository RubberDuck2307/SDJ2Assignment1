public class Vinyl {

    private String title;

    private String artist;

    private int year;

    private boolean lendingState = false;

    private String reservationName;
    private int id;
    public void Vinyl(String title, String artist, int year, boolean lendingState, String reservationName, int id)
    {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.lendingState = lendingState;
        this.reservationName = reservationName;
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }
    public String getArtist()
    {
        return artist;
    }
    public int year()
    {
        return year;
    }
    public boolean getLendingState()
    {
        return lendingState;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isLendingState() {
        return lendingState;
    }

    public void setLendingState(boolean lendingState) {
        this.lendingState = lendingState;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
