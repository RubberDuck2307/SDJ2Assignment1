package viewmodel;

import model.Vinyl;

public class ViewState {

    private int vinyl;

    public ViewState(){
        vinyl = 0;
    }


    public int getVinylId() {
        return vinyl;
    }

    public void setVinylId(int vinyl) {
        this.vinyl = vinyl;
    }
}
