package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VinylViewController
{

  public TableColumn yearColumn;
  public TableColumn statusColumn;
  @FXML private TableColumn artistColumn;
  @FXML private TableView VinylTable;
  @FXML private TableColumn titleColumn;


  public void editButtonPressed(ActionEvent actionEvent)
  {
  }
}
