package model.VinylState;

import model.Vinyl;

public interface VinylState {

    public void Borrow(Vinyl vinyl);

    public void Reserve(Vinyl vinyl,String name);

    public void Return(Vinyl vinyl);

}
