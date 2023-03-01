package model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface Model extends PropertyChangeSubject
{

    public ArrayList<Vinyl> getVinylArraylist();
    public Vinyl getVinylById(int id);

    public Vinyl getVinylByTitle(String title);

    public void removeVinylById(int id);

    public void removeVinylByTitle(String title);

    public void addVinyl(Vinyl vinyl);
    public void changeToReserved(Vinyl vinyl);
    public void changeToBorrowed(Vinyl vinyl);
    public void returnVinyl(Vinyl vinyl);
}
