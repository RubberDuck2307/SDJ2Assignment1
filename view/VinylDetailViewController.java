package view;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import utility.StringIntegerConverter;
import viewmodel.VinylDetailViewModel;
import viewmodel.VinylViewModel;

public class VinylDetailViewController
{
  @FXML private TextField title;
  @FXML private TextField artist;
  @FXML private TextField year;
  @FXML private TextField state;
  @FXML private Label errorLabel;
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
    year.textProperty().bind(viewModel.getStateProperty());
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
  }

  public void reset(){}
  public Region getRoot()
  {
    return root;
  }

  @FXML public void reserveButtonPressed(){

  }

  @FXML public void borrowReturnButtonPressed(){}
  @FXML public void cancelButtonPressed(){}
}
