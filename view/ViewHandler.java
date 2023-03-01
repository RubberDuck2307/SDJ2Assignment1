package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;
import viewmodel.VinylDetailViewModel;
import viewmodel.VinylViewModel;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;
  private VinylDetailViewController vinylDetailViewController;
  private VinylViewController vinylViewController;
  private AddVinylViewController addVinylViewController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("list");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "list":{
        root = loadVinylView("VinylView.fxml");
        break;
      }
      case "detail":{
        root = loadVinylDetailView("VinylDetailView.fxml");
        break;
      }
      case "add":{
        root = loadAddVinylView("AddVinylView.fxml");
        break;
      }
    }
    currentScene.setRoot(root);
    String title = "list";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadVinylView(String fxmlFile)
  {
    if (vinylViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        vinylViewController = loader.getController();
        vinylViewController
            .init(this, viewModelFactory.getVinylViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      vinylViewController.reset();
    }
    return vinylViewController.getRoot();
  }
  private Region loadAddVinylView(String fxmlFile)
    {
      if (addVinylViewController == null)
      {
        try
        {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource(fxmlFile));
          Region root = loader.load();
          addVinylViewController = loader.getController();
          addVinylViewController
              .init(this, viewModelFactory.getAddVinylViewModel(), root);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
      else
      {
        addVinylViewController.reset();
      }
      return addVinylViewController.getRoot();
    }

  private Region loadVinylDetailView(String fxmlFile)
  {
    if (vinylDetailViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        vinylDetailViewController = loader.getController();
        vinylDetailViewController
            .init(this, viewModelFactory.getVinylDetailViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      vinylDetailViewController.reset();
    }
    return vinylDetailViewController.getRoot();
  }
}
