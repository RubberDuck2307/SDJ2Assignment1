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

    public Vinyl(String title, String artist, int year, String reservationName, int id, VinylState state)
    {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.state = new AvailableState();
        this.reservationName = reservationName;
        this.id = id;
        this.state = state;
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
}
