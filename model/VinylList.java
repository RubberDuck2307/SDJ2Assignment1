package model;

import java.util.ArrayList;

public class VinylList
{
  private ArrayList<Vinyl> vinylList;

  public VinylList()
  {
    vinylList = new ArrayList<Vinyl>();
  }

  public void addVinyl(Vinyl vinyl)
  {
    if (vinyl.getId() == -1){
      int lastElementId = vinylList.get(vinylList.size() -1).getId();
      vinyl.setId(lastElementId + 1);
    }
    vinylList.add(vinyl);
  }

  public void removeVinyl(Vinyl vinyl)
  {
    vinylList.remove(vinyl);
  }

  public void removeVinylByIndex(int index)
  {
    vinylList.remove(index);
  }

  public void removeVinylByID(int ID)
  {
    int index = -1;
    for (int i = 0; i < vinylList.size(); i++)
    {
      if(vinylList.get(i).getId() == ID) index = i;
    }
    vinylList.remove(index);
  }

  public ArrayList<Vinyl> getVinylList()
  {
    return vinylList;
  }

  public Vinyl getVinylByIndex(int index)
  {
    return vinylList.get(index);
  }

  public Vinyl getVinylByTitle(String title)
  {
    int index = -1;
    for (int i = 0; i < vinylList.size(); i++)
    {
      vinylList.get(i).getTitle().equals(title);
      index = i;
    }
    return vinylList.get(index);
  }

  public Vinyl getVinylByID(int ID)
  {
    int index = -1;
    for (int i = 0; i < vinylList.size(); i++)
    {
      if (vinylList.get(i).getId() == ID)
      index = i;
    }
    return vinylList.get(index);
  }

  public int getSize()
  {
    return vinylList.size();
  }

  @Override public String toString()
  {
    return "VinylList{" + "vinylList=" + vinylList + '}';
  }
}
