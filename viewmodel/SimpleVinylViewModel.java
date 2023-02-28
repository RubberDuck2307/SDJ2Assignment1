package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Vinyl;

public class SimpleVinylViewModel
{
  private IntegerProperty year;
  private StringProperty state;

  private StringProperty artist;

  public SimpleVinylViewModel(Vinyl vinyl)
  {
    this.year = new SimpleIntegerProperty (vinyl.getYear());
    this.state = new SimpleStringProperty(vinyl.getState().getName());
    this.artist = new SimpleStringProperty(vinyl.getArtist());
  }



  public IntegerProperty yearProperty()
  {
    return year;
  }


  public StringProperty stateProperty()
  {
    return state;
  }


  public StringProperty artistProperty()
  {
    return artist;
  }
}
