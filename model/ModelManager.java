package model;

import model.VinylState.AvailableState;
import model.VinylState.BorrowedState;
import model.VinylState.ReservedState;

import javax.swing.plaf.nimbus.State;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model, PropertyChangeSubject{

    private VinylList vinylList;
    private PropertyChangeSupport property;

    public ModelManager(){
        vinylList = new VinylList();
        property = new PropertyChangeSupport(this);
    }

    @Override
    public ArrayList<Vinyl> getVinylArraylist() {
        return vinylList.getVinylList();
    }

    @Override
    public Vinyl getVinylById(int id) {
        return vinylList.getVinylByID(id);
    }

    @Override
    public Vinyl getVinylByTitle(String title) {
        return getVinylByTitle(title);
    }

    @Override
    public void removeVinylById(int id) {
        property.firePropertyChange("remove",null,getVinylById(id));
        vinylList.removeVinylByID(id);

    }

    @Override
    public void removeVinylByTitle(String title) {
        removeVinylByTitle(title);
        property.firePropertyChange("remove", null, getVinylByTitle(title));
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);

    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }

    @Override
    public void addVinyl(Vinyl vinyl) {
        vinylList.addVinyl(vinyl);
        property.firePropertyChange("add",null, vinyl);
    }

    @Override public void changeToReserved(Vinyl vinyl)
    {
        vinyl.setState(new ReservedState());
    }

    @Override public void changeToBorrowed(Vinyl vinyl)
    {
        vinyl.borrow();
    }

    @Override public void returnVinyl(Vinyl vinyl)
    {
        vinyl.setState(new AvailableState());
    }
}
