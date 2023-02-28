import javafx.stage.Stage;
import model.Model;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication
{
  public void start(Stage primaryStage)
  {
    Model model = new AuctionModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);
  }
}
