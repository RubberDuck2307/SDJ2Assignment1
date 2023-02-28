package viewmodel;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import model.Vinyl;

public class SimpleVinylViewModel
{
  private SimpleObjectProperty<Integer> year;
  private StringProperty state;
  private StringProperty title;

  private StringProperty artist;

  public SimpleVinylViewModel(Vinyl vinyl)
  {
    this.year = new SimpleObjectProperty<Integer> (vinyl.getYear());
    this.state = new SimpleStringProperty(vinyl.getState().getName());
    this.artist = new SimpleStringProperty(vinyl.getArtist());
    this.title = new SimpleStringProperty(vinyl.getTitle());
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


}
