package model.VinylState;

import model.Vinyl;

public class ReservedState implements VinylState{
    @Override
    public void Borrow(Vinyl vinyl) {

        vinyl.setReservationName(null);
        vinyl.setState(new BorrowedState());
    }

    @Override
    public void Reserve(Vinyl vinyl, String name) {

        throw new RuntimeException("The vinyl is already reserved");
    }

    @Override
    public void Return(Vinyl vinyl) {

        throw new RuntimeException("The vinyl is not borrowed");

    }
}
