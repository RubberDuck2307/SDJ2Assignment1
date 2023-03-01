package view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import utility.StringIntegerConverter;
import viewmodel.SimpleVinylViewModel;
import viewmodel.VinylViewModel;

public class VinylViewController
{

  @FXML private TableColumn <SimpleVinylViewModel, Integer> yearColumn;
  @FXML private TableColumn <SimpleVinylViewModel, String> statusColumn;
  @FXML private Label errorLabel;
  @FXML private TableColumn <SimpleVinylViewModel, String> artistColumn;
  @FXML private TableView <SimpleVinylViewModel> vinylTable;
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
    titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
    artistColumn.setCellValueFactory(cellData -> cellData.getValue().getArtistProperty());
    statusColumn.setCellValueFactory(cellData -> cellData.getValue().getStateProperty());
    yearColumn.setCellValueFactory(cellData -> cellData.getValue().getYearProperty());
    vinylTable.setItems(viewModel.getAll());

  }
  public Region getRoot()
  {
    return root;
  }


  public void addButtonPressed(ActionEvent actionEvent)
  {

    viewHandler.openView("detail");
  }

  public void reset(){
    //do nothing
  }
}
