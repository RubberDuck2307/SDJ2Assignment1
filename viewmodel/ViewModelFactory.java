package viewmodel;

import model.Model;

public class ViewModelFactory
{
  private VinylDetailViewModel vinylDetailViewModel;
  private VinylViewModel vinylViewModel;

  public ViewModelFactory(Model model){
    this.vinylViewModel=new VinylViewModel(model);
    this.vinylDetailViewModel=new VinylDetailViewModel(model);
  }

  public VinylDetailViewModel getVinylDetailViewModel()
  {
    return vinylDetailViewModel;
  }

  public VinylViewModel getVinylViewModel()
  {
    return vinylViewModel;
  }
}
