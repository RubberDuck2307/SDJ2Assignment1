package view;

import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import model.Vinyl;
import model.VinylState.VinylState;
import utility.StringIntegerConverter;
import viewmodel.SimpleVinylViewModel;
import viewmodel.VinylViewModel;

import java.util.Comparator;
import java.util.SimpleTimeZone;

public class VinylViewController
{

  @FXML private TableColumn <SimpleVinylViewModel, Integer> yearColumn;
  @FXML private TableColumn <SimpleVinylViewModel, String> statusColumn;
  @FXML private TableColumn <SimpleVinylViewModel, String> artistColumn;
  @FXML private TableView <SimpleVinylViewModel> vinylTable;
  @FXML private TableColumn <SimpleVinylViewModel, String> titleColumn;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private VinylViewModel viewModel;
  public void init (ViewHandler viewHandler, VinylViewModel viewModel,
      Region root)
  {

    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;
    viewModel.changeProperty().addListener(observable -> sort());
    titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
    artistColumn.setCellValueFactory(cellData -> cellData.getValue().getArtistProperty());
    statusColumn.setCellValueFactory(cellData -> cellData.getValue().getStateProperty());
    yearColumn.setCellValueFactory(cellData -> cellData.getValue().getYearProperty());
    vinylTable.setItems(viewModel.getAll());


    Comparator<String> columnComparator =
            Comparator.comparing(String::toLowerCase);

    titleColumn.setComparator(columnComparator);
    vinylTable.getSortOrder().add(titleColumn);

    errorLabel.textProperty().bind(viewModel.getErrorProperty());

  }
  public Region getRoot()
  {
    return root;
  }


  public void addButtonPressed(ActionEvent actionEvent)
  {
    viewHandler.openView("add");
  }
 public void sort(){
   vinylTable.sort();
}

  public void reset(){
    vinylTable.getSelectionModel().select(null);
    viewModel.reset();
    //do nothing
  }

  public void openWindow(MouseEvent mouseEvent) {
    if (vinylTable.getSelectionModel().getSelectedItem() != null) {
      SimpleVinylViewModel vinyl = vinylTable.getSelectionModel().getSelectedItem();
      viewModel.setViewState(vinyl);
      viewHandler.openView("detail");
    }
  }
}
