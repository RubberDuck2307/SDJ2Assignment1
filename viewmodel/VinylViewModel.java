package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import model.Model;

public class VinylViewModel
{
    private ObservableList<SimpleVinylViewModel> list;
    private ObjectProperty <SimpleVinylViewModel> selectedVinylProperty;
    private StringProperty error;

  public VinylViewModel(Model model)
  {
    this.list = list;
    this.selectedVinylProperty = selectedVinylProperty;
    this.error = error;
  }
}
