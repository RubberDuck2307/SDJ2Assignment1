package view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import viewmodel.VinylViewModel;


public class VinylViewController
{

  @FXML private TableColumn <VinylViewModel, Integer> yearColumn;
  @FXML private TableColumn <VinylViewModel, String> statusColumn;
  @FXML private Label errorLabel;
  @FXML private TableColumn <VinylViewModel, String> artistColumn;
  @FXML private TableView <VinylViewModel> VinylTable;
  @FXML private TableColumn <VinylViewModel, String> titleColumn;
  private Region root;
  private ViewHandler viewHandler;
  private VinylViewModel viewModel;
  public void init (ViewHandler viewHandler, VinylViewModel viewModel,
      Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;
  }
  public Region getRoot()
  {
    return root;
  }


  public void editButtonPressed(ActionEvent actionEvent)
  {
  }

  public void reset(){
    //do nothing
  }
}
