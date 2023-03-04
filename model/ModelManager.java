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
    public synchronized ArrayList<Vinyl> getVinylArraylist() {
        return vinylList.getVinylList();
    }

    @Override
    public synchronized Vinyl getVinylById(int id) {
        return vinylList.getVinylByID(id);
    }

    @Override
    public synchronized Vinyl getVinylByIndex(int index){
        return vinylList.getVinylByIndex(index);
    }

    @Override
    public synchronized Vinyl getVinylByTitle(String title) {
        return getVinylByTitle(title);
    }

    @Override
    public synchronized void removeVinylById(int id) {
        property.firePropertyChange("remove",null,getVinylById(id));
        vinylList.removeVinylByID(id);

    }

    @Override
    public synchronized void removeVinylByTitle(String title) {
        removeVinylByTitle(title);
        property.firePropertyChange("remove", null, getVinylByTitle(title));
    }

    @Override
    public synchronized void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);

    }

    @Override
    public synchronized void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }

    @Override
    public synchronized void addVinyl(Vinyl vinyl) {
        vinylList.addVinyl(vinyl);
        property.firePropertyChange("add",null, vinyl);
    }

    @Override public synchronized void changeToReserved(Vinyl vinyl, String name)
    {
        vinyl.reserve(name);
        property.firePropertyChange("statusChange", false, vinyl);
    }

    @Override public synchronized void changeToBorrowed(Vinyl vinyl)
    {
        vinyl.borrow();
        property.firePropertyChange("statusChange", false, vinyl);
    }

    @Override public synchronized void returnVinyl(Vinyl vinyl)
    {
        vinyl.returnItem();
        property.firePropertyChange("statusChange", false, vinyl);
    }

    public synchronized void changeToBorrowed(Vinyl vinyl, String name){
        vinyl.borrow(name);
        property.firePropertyChange("statusChange", false, vinyl);
    }

    @Override
    public synchronized int vinylListSize() {
        return vinylList.getSize();
    }
}
