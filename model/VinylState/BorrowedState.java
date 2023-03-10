package model.VinylState;

import model.Vinyl;

public class BorrowedState implements VinylState{

    @Override
    public String getName() {
        return "Borrowed";

    }

    @Override
    public void borrow(Vinyl vinyl) {
        throw new RuntimeException("The vinyl is already borrowed");
    }

    @Override
    public void reserve(Vinyl vinyl, String name) {

        vinyl.setReservationName(name);
        vinyl.setState(new ReservedBorrowedState());

    }

    @Override
    public boolean remove(Vinyl vinyl) {
        vinyl.setDeleteFlag(true);
        return false;
    }

    @Override
    public void returnVinyl(Vinyl vinyl) {
        vinyl.setState(new AvailableState());
    }
}
