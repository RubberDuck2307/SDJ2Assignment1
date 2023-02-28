package model.VinylState;

import model.Vinyl;

public class BorrowedState implements VinylState{

    @Override
    public String getName() {
        return "Borrowed";
    }

    @Override
    public void Borrow(Vinyl vinyl) {
        throw new RuntimeException("The vinyl is already borrowed");
    }

    @Override
    public void Reserve(Vinyl vinyl, String name) {

        vinyl.setReservationName(name);
        vinyl.setState(new ReservedState());

    }

    @Override
    public void Return(Vinyl vinyl) {
        vinyl.setState(new AvailableState());
    }
}