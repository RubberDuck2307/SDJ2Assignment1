package viewmodel;

import javafx.beans.property.*;
import model.Model;
import model.ModelManager;
import model.Vinyl;
import view.ViewState;
import view.VinylDetailViewController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VinylDetailViewModel implements PropertyChangeListener
{
  private StringProperty titleProperty;
  private StringProperty artistProperty;
  private StringProperty stateProperty;
  private IntegerProperty yearProperty;
  private StringProperty errorProperty;
  private ViewState viewState;
  private Model model;
private BooleanProperty reserved;
private BooleanProperty borrowed;

private StringProperty buttonText;
  public VinylDetailViewModel(Model model, ViewState viewState)
  {
    this.model = model;
    buttonText = new SimpleStringProperty();
    this.titleProperty = new SimpleStringProperty();
    this.artistProperty = new SimpleStringProperty();
    this.stateProperty = new SimpleStringProperty();
    this.yearProperty = new SimpleIntegerProperty();
    this.errorProperty = new SimpleStringProperty();
    this.viewState = viewState;
    this.reserved = new SimpleBooleanProperty();
    this.borrowed = new SimpleBooleanProperty();
    model.addListener(this);
  }

  public boolean isReserved()
  {
    return reserved.get();
  }

  public String getButtonText()
  {
    return buttonText.get();
  }

  public StringProperty buttonTextProperty()
  {
    return buttonText;
  }

  public BooleanProperty reservedProperty()
  {
    return reserved;
  }

  public boolean isBorrowed()
  {
    return borrowed.get();
  }

  public BooleanProperty borrowedProperty()
  {
    return borrowed;
  }

  public void reset()
  {
    init();
  }

  public void init()
  {

    Vinyl vinyl = model.getVinylById(viewState.getVinylId());
    titleProperty.setValue(vinyl.getTitle());
    artistProperty.setValue(vinyl.getArtist());
    yearProperty.setValue(vinyl.getYear());
    stateProperty.setValue(vinyl.getState().getName());
    setBooleans();
    setButtonText();
  }


  public void reserve()
  {
    model.changeToReserved(model.getVinylById(viewState.getVinylId()));
    System.out.println(model.getVinylById(viewState.getVinylId()));
    System.out.println(model.getVinylById(viewState.getVinylId()).getState());
  }

  public void borrow()
  {
    model.changeToBorrowed(model.getVinylById(viewState.getVinylId()));
    System.out.println(model.getVinylById(viewState.getVinylId()));
    System.out.println(model.getVinylById(viewState.getVinylId()).getState());
  }

  public void returnVinyl()
  {
    model.returnVinyl(model.getVinylById(viewState.getVinylId()));
    System.out.println(model.getVinylById(viewState.getVinylId()));
    System.out.println(model.getVinylById(viewState.getVinylId()).getState());
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

  public void remove()
  {
    model.removeVinylById(viewState.getVinylId());
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("statusChange")){

      stateProperty.setValue(((Vinyl)evt.getNewValue()).getState().getName());
      setBooleans();
      setButtonText();
      System.out.println("It is changed");
      System.out.println(stateProperty.getValue());
    }
  }

  public void setBooleans(){
    if(stateProperty.getValue().equals("Borrowed")){
      borrowed.setValue(true);
      reserved.setValue(false);
    }
    else if(stateProperty.getValue().equals("Available")){
      borrowed.setValue(false);
      reserved.setValue(false);
    }    else if(stateProperty.getValue().equals("Reserved")){
      borrowed.setValue(false);
      reserved.setValue(true);
    } else if(stateProperty.getValue().equals("Reserved and borrowed")){
      borrowed.setValue(true);
      reserved.setValue(true);
    }
  }

  public void setButtonText(){
    System.out.println("Funguju");
    if (stateProperty.getValue().equals("Borrowed") || stateProperty.getValue().equals("Reserved and borrowed") ){
      buttonText.setValue("Return");
      System.out.println("Ted uz tam má být ");
    }
    else{
      buttonText.setValue("Borrow");
    }

  }
}
