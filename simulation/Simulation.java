package simulation;

import model.Model;
import model.Vinyl;
import viewmodel.VinylDetailViewModel;

import java.util.ArrayList;

public class Simulation {
    private Model model;
    Bidder bob;
    Bidder wendy;

    public Simulation(Model model) {
        model.addVinyl(new Vinyl("You shall not pass", "Gandalf the grey", 1999, 1));
        model.addVinyl(new Vinyl("Simplicity is beautiful", "Mr Honza", 2000, 2));
        model.addVinyl(new Vinyl("What does he have in his filthy little pockets", "Gollum", 1999, 3));
        model.addVinyl(new Vinyl("I have no idea", "GG", 2012, 4));
        model.addVinyl(new Vinyl("We have an idea", "The artist", 1800, 5));
        model.addVinyl(new Vinyl("What the hell is happening", "Random polish guy", 2150,6));
        model.addVinyl(new Vinyl("Lets have a coffee", "average coffee enjoyer", 2000,7));
        model.addVinyl(new Vinyl("I like ice cream", "Ruler", 1111, 8));
        model.addVinyl(new Vinyl("You are so pretty", "Your mum, probably", 1231,9 ));
        model.addVinyl(new Vinyl("The last one", "Bigbrainer", 1234, 10));
        this.model = model;
        bob = new Bidder(model, 10000);
        Thread thread = new Thread(bob);
        thread.setName("Bob");
        thread.start();

        wendy = new Bidder(model, 15000);
        Thread thread2 = new Thread(wendy);
        thread2.setName("Wendy");
        thread2.start();

    }

    public void stop() {
        bob.stop();
        wendy.stop();
    }


}
