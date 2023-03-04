package model.VinylState;

import model.Vinyl;

public interface VinylState {


    public String getName();

    public void borrow(Vinyl vinyl);

    public void reserve(Vinyl vinyl, String name);

    public void returnVinyl(Vinyl vinyl);

    public boolean remove(Vinyl vinyl);
}
