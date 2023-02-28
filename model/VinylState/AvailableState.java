package model.VinylState;

import model.Vinyl;

public class AvailableState implements VinylState{


    @Override
    public void Borrow(Vinyl vinyl) {
        vinyl.setState(new BorrowedState());
    }

    @Override
    public void Reserve(Vinyl vinyl, String name) {
        vinyl.setReservationName(name);
        vinyl.setState(new ReservedState());
    }

    @Override
    public void Return(Vinyl vinyl) {
        throw new RuntimeException("The vinyl is not borrowed");
    }
}
