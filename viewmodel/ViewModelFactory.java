package viewmodel;

import model.Model;

public class ViewModelFactory
{
  private VinylDetailViewModel vinylDetailViewModel;
  private VinylViewModel vinylViewModel;

  public ViewModelFactory(Model model){
    this.vinylViewModel=new VinylViewModel(model);
    this.vinylDetailViewModel=new VinylDetailViewModel();
  }

  public VinylDetailViewModel getVinylDetailViewModel()
  {
    return vinylDetailViewModel;
  }
// bobek
  public VinylViewModel getVinylViewModel()
  {
    return vinylViewModel;
  }
}
