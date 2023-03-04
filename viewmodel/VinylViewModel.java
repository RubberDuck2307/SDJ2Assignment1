package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.Vinyl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class VinylViewModel implements PropertyChangeListener {
    private ObservableList<SimpleVinylViewModel> list;
    private ObjectProperty<SimpleVinylViewModel> selectedVinylProperty;
    private StringProperty error;
    private ViewState viewState;
    private Model model;
    private BooleanProperty change;

    public VinylViewModel(Model model, ViewState viewState) {
        change = new SimpleBooleanProperty();
        this.viewState = viewState;
        this.model = model;
        list = FXCollections.observableArrayList();
        error = new SimpleStringProperty();
        model.addListener(this);
        getFromModel();
    }

    private void getFromModel() {
        list.clear();
        ArrayList<Vinyl> vinylArrayList = model.getVinylArraylist();
        for (Vinyl vinyl : vinylArrayList) {
            list.add(new SimpleVinylViewModel(vinyl));
        }
    }

    public void reset() {

    }

    public StringProperty getErrorProperty() {
        return error;
    }

    public ObservableList<SimpleVinylViewModel> getAll() {
        return list;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            if (evt.getPropertyName().equals("add")) {
                list.add(new SimpleVinylViewModel((Vinyl) evt.getNewValue()));
            }
            if (evt.getPropertyName().equals("remove")) {
                list.remove(new SimpleVinylViewModel((Vinyl) evt.getNewValue()));
            }
            if (evt.getPropertyName().equals("statusChange")){
                list.remove(new SimpleVinylViewModel((Vinyl) evt.getOldValue()));
                list.add(new SimpleVinylViewModel((Vinyl) evt.getNewValue()));
            }
            change.setValue(!change.getValue());
        });


    }

    public void setViewState(SimpleVinylViewModel vinylModel) {

        viewState.setVinylId(vinylModel.getId());
    }

    public ObservableList<SimpleVinylViewModel> getList() {
        return list;
    }

    public void setList(ObservableList<SimpleVinylViewModel> list) {
        this.list = list;
    }

    public boolean isChange() {
        return change.get();
    }

    public BooleanProperty changeProperty() {
        return change;
    }

    public void setChange(boolean change) {
        this.change.set(change);
    }
}
