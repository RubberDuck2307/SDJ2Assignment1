package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import viewmodel.SimpleVinylViewModel;
import viewmodel.VinylViewModel;

public class VinylViewController
{

  @FXML private TableColumn <SimpleVinylViewModel, Integer> yearColumn;
  @FXML private TableColumn <SimpleVinylViewModel, String> statusColumn;
  @FXML private Label errorLabel;
  @FXML private TableColumn <SimpleVinylViewModel, String> artistColumn;
  @FXML private TableView <SimpleVinylViewModel> VinylTable;
  @FXML private TableColumn <SimpleVinylViewModel, String> titleColumn;
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
