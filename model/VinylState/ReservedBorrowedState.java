package model.VinylState;

import model.Vinyl;

public class ReservedBorrowedState implements VinylState{

    @Override
    public void Borrow(Vinyl vinyl) {

        throw new RuntimeException("model.Vinyl is already borrowed");

    }

    @Override
    public void Reserve(Vinyl vinyl, String name) {

        throw new RuntimeException("model.Vinyl is already reserved");

    }

    @Override
    public void Return(Vinyl vinyl) {

        vinyl.setState(new ReservedState());
    }
}
