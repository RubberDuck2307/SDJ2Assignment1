package model.VinylState;

import model.Vinyl;

public class ReservedBorrowedState implements VinylState{

    @Override
    public String getName() {
        return "Reserved and borrowed";
    }

    @Override
    public void Borrow(Vinyl vinyl) {

        throw new RuntimeException("model.Vinyl is already borrowed");

    }

    @Override
    public void Reserve(Vinyl vinyl, String name) {

        throw new RuntimeException("model.Vinyl is already reserved");

    }

    @Override
    public boolean remove(Vinyl vinyl) {
        vinyl.setDeleteFlag(true);
        return false;
    }

    @Override
    public void Return(Vinyl vinyl) {

        vinyl.setState(new ReservedState());
    }
}
