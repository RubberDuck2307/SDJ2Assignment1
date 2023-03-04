package view;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import utility.StringIntegerConverter;
import viewmodel.VinylDetailViewModel;
import viewmodel.VinylViewModel;

import java.lang.reflect.Field;

public class VinylDetailViewController
{
  @FXML private Button removeButton;
  @FXML private TextField title;
  @FXML private TextField artist;
  @FXML private TextField year;
  @FXML private TextField state;
  @FXML private Label errorLabel;
  @FXML private Button reserveButton;
  @FXML private Button borrowReturnButton;
  @FXML private TextField reservedField;
  private Region root;
  private VinylDetailViewModel viewModel;
  private ViewHandler viewHandler;
  private BooleanProperty reserved;
  private BooleanProperty borrowed;

  private BooleanProperty isAboutToBeDeleted;

  // Do not try to read this code it mess
  public void init(ViewHandler viewHandler, VinylDetailViewModel viewModel,
      Region root)
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    reserved = new SimpleBooleanProperty();
    borrowed = new SimpleBooleanProperty();
    isAboutToBeDeleted = new SimpleBooleanProperty();
    reserved.bindBidirectional(viewModel.reservedProperty());
    borrowed.bindBidirectional(viewModel.borrowedProperty());
    reservedField.setText("");
    reservedField.textProperty().bindBidirectional(viewModel.reservedStringProperty());

    title.textProperty().bindBidirectional(viewModel.getTitleProperty());
    artist.textProperty().bindBidirectional(viewModel.getArtistProperty());
    Bindings.bindBidirectional(year.textProperty(), viewModel.getYearProperty(),
        new StringIntegerConverter(0));
    state.textProperty().bindBidirectional(viewModel.getStateProperty());
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
    viewModel.init();
    reserved.addListener( (observable, oldValue, newValue) -> reserved());
    viewModel.buttonTextProperty().addListener((observable, oldValue, newValue) -> changeText(newValue));
    viewModel.deletedProperty().addListener((observable, oldValue, newValue) -> cancelPressed());
    isAboutToBeDeleted.bind(viewModel.isAboutToDeletedProperty());
    isAboutToBeDeleted.addListener(observable -> reserved());

  }

  public void changeText(String newValue){
    System.out.println(newValue);
    borrowReturnButton.setText(newValue);
  }
  public void reset()
  {
    viewModel.reset();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reserved(){
    reserveButton.setDisable(reserved.getValue() || isAboutToBeDeleted.getValue());
  }





  @FXML public void reservePressed()
  {
    viewModel.reserve(reservedField.getText());
  }

  @FXML public void borrowReturnButtonPressed()
  {
    if (state.textProperty().getValue().equals("Borrowed")
        || state.textProperty().getValue().equals("Reserved and borrowed"))
    {
      viewModel.returnVinyl();
    }
    else
    {
      viewModel.borrow();
    }
  }

  @FXML public void cancelPressed()
  {
    viewHandler.openView("list");
  }

  @FXML public void removePressed()
  {
    viewModel.remove();
  }

}
