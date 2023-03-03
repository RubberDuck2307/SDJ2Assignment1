package viewmodel;

import javafx.beans.property.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Model;
import model.ModelManager;
import model.Vinyl;
import view.ViewState;
import view.VinylDetailViewController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;
import java.util.Optional;

public class VinylDetailViewModel implements PropertyChangeListener
{
  private StringProperty titleProperty;
  private StringProperty artistProperty;
  private StringProperty stateProperty;
  private IntegerProperty yearProperty;
  private StringProperty errorProperty;
  private ViewState viewState;
  private Model model;

  private StringProperty reservedString;
private BooleanProperty reserved;
private BooleanProperty borrowed;

private StringProperty buttonText;

private BooleanProperty deleted;

private BooleanProperty isAboutToDeleted;
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
    deleted = new SimpleBooleanProperty();
    reservedString = new SimpleStringProperty();
    isAboutToDeleted = new SimpleBooleanProperty();
    model.addListener(this);
  }

  public String getReservedString() {
    return reservedString.get();
  }

  public StringProperty reservedStringProperty() {
    return reservedString;
  }

  public void setReservedString(String reservedString) {
    this.reservedString.set(reservedString);
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

    deleted.setValue(false);
    Vinyl vinyl = model.getVinylById(viewState.getVinylId());
    titleProperty.setValue(vinyl.getTitle());
    artistProperty.setValue(vinyl.getArtist());
    yearProperty.setValue(vinyl.getYear());
    stateProperty.setValue(vinyl.getState().getName());
    reservedString.setValue("");
    loadIsAboutToDeleted();
    setBooleans();
    setButtonText();
  }


  public void reserve(String name)
  {
    if(Objects.equals(name, "")){
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Empty field");
      alert.setHeaderText("You have to insert a name in order to reserve it. BTW, Alex likes small dicks.");
      alert.showAndWait();
    }
    else{
      model.changeToReserved(model.getVinylById(viewState.getVinylId()), name);
    }

  }

  public void borrow()
  {
    model.changeToBorrowed(model.getVinylById(viewState.getVinylId()));

  }

  public void returnVinyl()
  {
    model.returnVinyl(model.getVinylById(viewState.getVinylId()));
    if (model.getVinylById(viewState.getVinylId()).isDeleteFlag()){
      model.removeVinylById(viewState.getVinylId());
      deleted.setValue(true);
    }
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
    if(model.getVinylById(viewState.getVinylId()).remove()) {
      model.removeVinylById(viewState.getVinylId());
      deleted.setValue(true);
    }
    else {
      isAboutToDeleted.setValue(true);
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Will be deleted");
      alert.setHeaderText("The record will be deleted when the vinyl will be returned and not reserved");
      alert.showAndWait();
    }
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
    if (stateProperty.getValue().equals("Borrowed") || stateProperty.getValue().equals("Reserved and borrowed") ){
      buttonText.setValue("Return");
    }
    else{
      buttonText.setValue("Borrow");
    }

  }

  public boolean isDeleted() {
    return deleted.get();
  }

  public BooleanProperty deletedProperty() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted.set(deleted);
  }

  public boolean isIsAboutToDeleted() {
    return isAboutToDeleted.get();
  }

  public BooleanProperty isAboutToDeletedProperty() {
    return isAboutToDeleted;
  }

  public void setIsAboutToDeleted(boolean isAboutToDeleted) {
    this.isAboutToDeleted.set(isAboutToDeleted);
  }

  public void  loadIsAboutToDeleted(){
    isAboutToDeleted.setValue(model.getVinylById(viewState.getVinylId()).isDeleteFlag());
  }
}
