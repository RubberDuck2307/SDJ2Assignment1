package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import model.Model;
import model.VinylState.VinylState;

public class VinylViewModel
{
    private ObservableList<SimpleVinylViewModel> list;
    private ObjectProperty <SimpleVinylViewModel> selectedVinylProperty;
    private StringProperty error;

  public VinylViewModel(Model model)
  {

  }
  public void addVinyl(){

  }


}
