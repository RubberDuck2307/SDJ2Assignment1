package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.ModelManager;
import model.Vinyl;
import model.VinylState.ReservedBorrowedState;
import model.VinylState.VinylState;
import view.ViewState;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class VinylViewModel implements PropertyChangeListener {
    private ObservableList<SimpleVinylViewModel> list;
    private ObjectProperty<SimpleVinylViewModel> selectedVinylProperty;
    private StringProperty error;
    private ViewState viewState;
    private Model model;

    public VinylViewModel(Model model, ViewState viewState) {
        this.viewState = viewState;
        this.model = model;
        list = FXCollections.observableArrayList();
        error=new SimpleStringProperty();
        model.addListener(this);
        getFromModel();
    }

    private void getFromModel() {
        list.clear();
        ArrayList<Vinyl> vinylArrayList = model.getVinylArraylist();
        for (Vinyl vinyl : vinylArrayList) {
            list.add(new SimpleVinylViewModel(vinyl));
        }
        System.out.println(list);
    }

    public void reset(){
        getFromModel();
    }

    public StringProperty getErrorProperty()
    {
        return error;
    }

    public ObservableList<SimpleVinylViewModel> getAll() {
        return list;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getNewValue());
        if (evt.getPropertyName().equals("add")) {
            list.add(new SimpleVinylViewModel((Vinyl) evt.getNewValue()));
        }
        if (evt.getPropertyName().equals("remove")) {
            list.remove(new SimpleVinylViewModel((Vinyl) evt.getNewValue()));
            System.out.println(list);
            //Todo: what to put here???
            /*int remove = list.size() - 1;
            Platform.runLater(() ->list.remove(model.getVinylById(
                (Integer) evt.getNewValue())));
            System.out.println("Toto je: "+evt.getNewValue());*/
        }
    }

    public void setViewState(SimpleVinylViewModel vinylModel) {

        viewState.setVinylId(vinylModel.getId());
    }
}
