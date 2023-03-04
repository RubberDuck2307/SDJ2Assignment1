import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.ModelManager;
import model.Vinyl;
import model.VinylList;
import simulation.Simulation;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application
{
  Simulation simulation;
  public void start(Stage primaryStage)
  {
    Model model = new ModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);
    simulation = new Simulation(model);
  }

  @Override
  public void stop() throws Exception {
    simulation.stop();
  }
}
