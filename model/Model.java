package model;

import java.util.ArrayList;

public interface Model
{

    public ArrayList<Vinyl> getVinylArraylist();
    public Vinyl getVinylById(int id);
    public Vinyl getVinylByIndex(int index);

    public Vinyl getVinylByTitle(String title);

    public void removeVinylById(int id);

    public void removeVinylByTitle(String title);

    public void addVinyl(Vinyl vinyl);
}
