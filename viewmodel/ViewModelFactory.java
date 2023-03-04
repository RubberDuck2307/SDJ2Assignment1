package viewmodel;

import model.Model;

public class ViewModelFactory
{
  private VinylDetailViewModel vinylDetailViewModel;
  private VinylViewModel vinylViewModel;
  private AddVinylViewModel addVinylViewModel;

  private ViewState viewState;
  public ViewModelFactory(Model model){
    viewState = new ViewState();
    this.vinylViewModel=new VinylViewModel(model, viewState);
    this.vinylDetailViewModel=new VinylDetailViewModel(model, viewState);
    this.addVinylViewModel=new AddVinylViewModel(model, viewState);
  }

  public VinylDetailViewModel getVinylDetailViewModel()
  {
    return vinylDetailViewModel;
  }

  public VinylViewModel getVinylViewModel()
  {
    return vinylViewModel;
  }

  public AddVinylViewModel getAddVinylViewModel()
  {
    return addVinylViewModel;
  }
}
