package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;
import view.ViewState;

public class AddVinylViewModel
{
  private StringProperty titleProperty;
  private StringProperty artistProperty;
  private StringProperty stateProperty;
  private IntegerProperty yearProperty;
  private StringProperty errorProperty;
  private ViewState viewState;
  private Model model;

  public AddVinylViewModel(Model model, ViewState viewState){
    this.model=model;
    this.titleProperty=new SimpleStringProperty();
    this.artistProperty=new SimpleStringProperty();
    this.stateProperty=new SimpleStringProperty();
    this.yearProperty=new SimpleIntegerProperty();
    this.errorProperty = new SimpleStringProperty();
    this.viewState = viewState;
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
