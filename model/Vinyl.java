package model;

import model.VinylState.AvailableState;
import model.VinylState.VinylState;

public class Vinyl {

    private String title;

    private String artist;

    private int year;

    private VinylState state;

    private String reservationName;
    private int id;

    private boolean deleteFlag;
    public Vinyl(String title, String artist, int year, int id)
    {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.state = new AvailableState();
        this.id = id;
        deleteFlag = false;
        reservationName = "";
    }

    public Vinyl(String title, String artist, int year)
    {
        deleteFlag = false;
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.state = new AvailableState();
        id = -1;
        reservationName = "";

    }

    public Vinyl(String title, String artist, int year, VinylState state, String reservationName, int id, boolean deleteFlag) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.state = state;
        this.reservationName = reservationName;
        this.id = id;
        this.deleteFlag = deleteFlag;
    }

    public VinylState getState() {
        return state;
    }

    public void setState(VinylState state) {
        this.state = state;
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

    public void borrow(String name){;
        if (name.equals(reservationName) || reservationName.equals("")){
            state.borrow(this);

        }
        else throw new RuntimeException("Someone else has reserved this vinyl");

    }
    public void borrow(){
        state.borrow(this);
    }
    public void reserve(String name){
        state.reserve(this, name);
    }
    public void returnItem(){
        state.returnVinyl(this);
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

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public boolean remove(){
       return state.remove(this);
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Vinyl copy(){
        return new Vinyl(title,artist,year,state,reservationName,id,deleteFlag);
    }



    @Override public String toString()
    {
        return "Vinyl{" + "title='" + title + '\'' + ", artist='" + artist
            + '\'' + ", year=" + year + ", state=" + state
            + ", reservationName='" + reservationName + '\'' + ", id=" + id
            + '}';
    }
}
