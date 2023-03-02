import model.Model;
import model.Vinyl;
import model.VinylState.VinylState;

public class Test implements Runnable
{
  private Model model;

  public Test(Model model){
    this.model=model;
  }

  @Override public void run()
  {
      Vinyl vinyl=model.getVinylByIndex((int) Math.floor(Math.random()*10));

  }
}
