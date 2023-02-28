package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;
import view.VinylDetailViewController;

public class VinylDetailViewModel
{
  private StringProperty titleProperty;
  private StringProperty artistProperty;
  private StringProperty stateProperty;
  private IntegerProperty yearProperty;
  private StringProperty errorProperty;

  private Model model;

  public VinylDetailViewModel(Model model){
    this.model=model;
    this.titleProperty=new SimpleStringProperty();
    this.artistProperty=new SimpleStringProperty();
    this.stateProperty=new SimpleStringProperty();
    this.yearProperty=new SimpleIntegerProperty();
  }

  public void reset(){
    titleProperty.set("");
    artistProperty.set("");
    yearProperty.set(0);
    stateProperty.set("");
  }

  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  public IntegerProperty getYearProperty()
  {
    return yearProperty;
  }

  public StringProperty getArtistProperty()
  {
    return artistProperty;
  }

  public StringProperty getStateProperty()
  {
    return stateProperty;
  }

  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }
}
