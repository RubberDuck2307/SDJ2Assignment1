package viewmodel;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import model.Vinyl;

import java.util.Objects;
import java.util.SimpleTimeZone;

public class SimpleVinylViewModel
{
  private SimpleObjectProperty<Integer> year;
  private StringProperty state;
  private StringProperty title;

  private StringProperty artist;

  private int id;
  public SimpleVinylViewModel(Vinyl vinyl)
  {
    this.id = vinyl.getId();
    this.year = new SimpleObjectProperty<Integer> (vinyl.getYear());
    this.state = new SimpleStringProperty(vinyl.getState().getName());
    this.artist = new SimpleStringProperty(vinyl.getArtist());
    this.title = new SimpleStringProperty(vinyl.getTitle());
  }

  public Integer getYear() {
    return year.get();
  }

  public SimpleObjectProperty<Integer> yearProperty() {
    return year;
  }

  public void setYear(Integer year) {
    this.year.set(year);
  }

  public String getState() {
    return state.get();
  }

  public void setState(String state) {
    this.state.set(state);
  }

  public String getTitle() {
    return title.get();
  }

  public StringProperty titleProperty() {
    return title;
  }

  public void setTitle(String title) {
    this.title.set(title);
  }

  public String getArtist() {
    return artist.get();
  }

  public void setArtist(String artist) {
    this.artist.set(artist);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public StringProperty stateProperty()
  {
    return state;
  }


  public StringProperty artistProperty()
  {
    return artist;
  }

  public ObservableValue<String> getTitleProperty()
  {
    return title;
  }

  public ObservableValue<String> getArtistProperty()
  {
    return artist;
  }

  public ObservableValue<Integer> getYearProperty()
  {
    return year;
  }

  public ObservableValue<String> getStateProperty()
  {
    return state;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != getClass()){
      return false;
    }
    SimpleVinylViewModel vinyl = (SimpleVinylViewModel) obj;
    return vinyl.id == id && title.getValue().equals(vinyl.title.getValue()) && artist.getValue().equals(vinyl.artist.getValue()) && Objects.equals(year.getValue(), vinyl.year.getValue()) && state.getValue().equals(vinyl.state.getValue());

  }
}
