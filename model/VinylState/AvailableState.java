package model.VinylState;

import model.Vinyl;

public class AvailableState implements VinylState{


    @Override
    public String getName() {
        return "Available";
    }

    @Override
    public void borrow(Vinyl vinyl) {
        vinyl.setState(new BorrowedState());
    }

    @Override
    public void reserve(Vinyl vinyl, String name) {
        vinyl.setReservationName(name);
        vinyl.setState(new ReservedState());
    }

    @Override
    public void returnVinyl(Vinyl vinyl) {
        throw new RuntimeException("The vinyl is not borrowed");
    }

    @Override
    public boolean remove(Vinyl vinyl) {
        return true;
    }
}
