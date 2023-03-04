import model.Model;
import model.Vinyl;
import viewmodel.VinylDetailViewModel;

import java.util.ArrayList;

public class Simulation implements Runnable
{
  private Model model;

  public Simulation(Model model)
  {
    this.model = model;
  }

  @Override public void run()
  {
    ArrayList<Vinyl> borrowed = new ArrayList<>();
    while (true)
    {
      Vinyl vinyl = model.getVinylByIndex((int) Math.floor(Math.random() * 10));
      int x = (int) Math.floor(Math.random() * 3);
      switch (x)
      {
        case 0:
        {
          vinyl.reserve("Wendy");
        }
        case 1:
        {
          vinyl.borrow();
          borrowed.add(vinyl);
        }
        case 2:
        {
          int y = borrowed.size();
          if (borrowed.size() > 0)
          {
            borrowed.get(0).returnVinyl();
            borrowed.remove(0);
          }
        }
      }
    } try
  {
    Thread.sleep(3000);
  }
  catch (InterruptedException e)
  {
    throw new RuntimeException(e);
  }
  }
}
