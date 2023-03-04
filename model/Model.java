package model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface Model extends PropertyChangeSubject
{

    public ArrayList<Vinyl> getVinylArraylist();
    public Vinyl getVinylById(int id);
    public Vinyl getVinylByIndex(int index);

    public Vinyl getVinylByTitle(String title);

    public void removeVinylById(int id);

    public void removeVinylByTitle(String title);

    public void addVinyl(Vinyl vinyl);
    public void changeToReserved(Vinyl vinyl, String name);
    public void changeToBorrowed(Vinyl vinyl);
    public void changeToBorrowed(Vinyl vinyl, String name);
    public void returnVinyl(Vinyl vinyl);

    public int vinylListSize();
}
