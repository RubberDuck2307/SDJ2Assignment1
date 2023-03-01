package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;
import model.Vinyl;
import view.ViewState;
import view.VinylDetailViewController;

public class VinylDetailViewModel {
    private StringProperty titleProperty;
    private StringProperty artistProperty;
    private StringProperty stateProperty;
    private IntegerProperty yearProperty;
    private StringProperty errorProperty;
    private ViewState viewState;
    private Model model;

    public VinylDetailViewModel(Model model, ViewState viewState) {
        this.model = model;
        this.titleProperty = new SimpleStringProperty();
        this.artistProperty = new SimpleStringProperty();
        this.stateProperty = new SimpleStringProperty();
        this.yearProperty = new SimpleIntegerProperty();
        this.errorProperty = new SimpleStringProperty();
        this.viewState = viewState;
    }

    public void reset() {
        init();
    }

    public void init() {
        Vinyl vinyl = model.getVinylById(viewState.getVinylId());
        titleProperty.setValue(vinyl.getTitle());
        artistProperty.setValue(vinyl.getArtist());
        yearProperty.setValue(vinyl.getYear());
        stateProperty.setValue(vinyl.getState().getName());

    }

    public StringProperty getTitleProperty() {
        return titleProperty;
    }

    public IntegerProperty getYearProperty() {
        return yearProperty;
    }

    public StringProperty getArtistProperty() {
        return artistProperty;
    }

    public StringProperty getStateProperty() {
        return stateProperty;
    }

    public StringProperty getErrorProperty() {
        return errorProperty;
    }
}
