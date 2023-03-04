package model.VinylState;

import model.Vinyl;

public interface VinylState {


    public String getName();

    public void Borrow(Vinyl vinyl);

    public void Reserve(Vinyl vinyl,String name);

    public void Return(Vinyl vinyl);

    public boolean remove(Vinyl vinyl);
}
