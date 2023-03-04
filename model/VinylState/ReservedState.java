package model.VinylState;

import model.Vinyl;

public class ReservedState implements VinylState{

    @Override
    public String getName() {
        return "Reserved";
    }

    @Override
    public void borrow(Vinyl vinyl) {

        vinyl.setReservationName(null);
        vinyl.setState(new BorrowedState());
    }

    @Override
    public void reserve(Vinyl vinyl, String name) {

        throw new RuntimeException("The vinyl is already reserved");
    }

    @Override
    public boolean remove(Vinyl vinyl) {
        vinyl.setDeleteFlag(true);
        return false;
    }


    @Override
    public void returnVinyl(Vinyl vinyl) {

        throw new RuntimeException("The vinyl is not borrowed");

    }
}
