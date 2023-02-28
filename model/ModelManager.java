package model;

import java.util.ArrayList;

public class ModelManager implements Model{

    VinylList vinylList = new VinylList();

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
         removeVinylById(id);
    }

    @Override
    public void removeVinylByTitle(String title) {
        removeVinylByTitle(title);
    }
}
