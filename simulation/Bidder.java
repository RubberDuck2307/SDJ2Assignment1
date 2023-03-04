package simulation;

import model.Model;
import model.Vinyl;
import model.VinylList;

import java.util.ArrayList;
import java.util.Random;

public class Bidder implements Runnable {


    private Model model;
    private boolean running;
    private VinylList borrowed;

    private int waiting;

    public Bidder(Model model, int waiting) {
        this.model = model;
        running = true;
        borrowed = new VinylList();
        this.waiting = waiting;

    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(waiting);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            if (running) {
                Vinyl vinyl = model.getVinylByIndex(random.nextInt(model.vinylListSize()));
                int x = random.nextInt(3);
                switch (x) {
                    case 0: {
                        System.out.println(Thread.currentThread().getName() + " is trying to reserve " + vinyl.getTitle());
                        try {
                            model.changeToReserved(vinyl, Thread.currentThread().getName());
                            System.out.println(Thread.currentThread().getName() + " reserved " + vinyl.getTitle());
                        } catch (Exception e) {
                            System.out.println(vinyl.getTitle() + " is already reserved ");
                        }
                        break;
                    }
                    case 1: {
                        System.out.println(Thread.currentThread().getName() + " is trying to borrow " + vinyl.getTitle());
                        try {
                            model.changeToBorrowed(vinyl, Thread.currentThread().getName());
                            borrowed.addVinyl(vinyl);
                            System.out.println(vinyl.getTitle() + " is borrowed");
                        } catch (Exception e) {
                            System.out.println(vinyl.getTitle() + " cannot be borrowed");
                        }
                        break;

                    }
                    case 2: {
                        try {
                            if (borrowed.getSize() > 0) {
                                vinyl = borrowed.getVinylByIndex(0);
                                System.out.println(Thread.currentThread().getName() + " is trying to return " + vinyl.getTitle());
                                model.returnVinyl(vinyl);
                                borrowed.removeVinylByIndex(0);
                                System.out.println(vinyl.getTitle() + " is returned");
                            }
                            else System.out.println(Thread.currentThread().getName() + " has nothing to return");
                        } catch (Exception e) {
                            System.out.println(vinyl.getTitle() + " cannot be returned");
                        }
                        break;
                    }
                }
                try {
                    Thread.sleep(waiting);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " Is finished");
    }
}
