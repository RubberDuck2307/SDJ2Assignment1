package view;

import javafx.beans.binding.Bindings;
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
  @FXML private TextField title;
  @FXML private TextField artist;
  @FXML private TextField year;
  @FXML private TextField state;
  @FXML private Label errorLabel;
  @FXML private Button reserveButton;
  @FXML private Button borrowReturnButton;
  @FXML private Button removeAddButton;
  @FXML private TextField reservedField;
  private Region root;
  private VinylDetailViewModel viewModel;
  private ViewHandler viewHandler;
  public void init(ViewHandler viewHandler, VinylDetailViewModel viewModel, Region root){
    this.root=root;
    this.viewHandler=viewHandler;
    this.viewModel=viewModel;
    title.textProperty().bind(viewModel.getTitleProperty());
    artist.textProperty().bind(viewModel.getArtistProperty());
    Bindings.bindBidirectional(year.textProperty(),viewModel.getYearProperty(), new StringIntegerConverter(0));
    state.textProperty().bind(viewModel.getStateProperty());
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
    viewModel.init();

    if (state.textProperty().getValue().equals("Borrowed") || state.textProperty().getValue().equals("Reserved and borrowed") ){
      borrowReturnButton.setText("Return");
    }

  }

  public void reset(){
    viewModel.reset();
  }
  public Region getRoot()
  {
    return root;
  }

  @FXML public void reservePressed(){

  }

  @FXML public void borrowReturnButtonPressed(){}
  @FXML public void cancelPressed(){
    viewModel.reset();
    viewHandler.openView("list");
  }

  @FXML public void removePressed(){}
}
