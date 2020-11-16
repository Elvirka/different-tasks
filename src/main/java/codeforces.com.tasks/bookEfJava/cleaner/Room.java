package codeforces.com.tasks.bookEfJava.cleaner;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {

        int numJunkPiles;

        public State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("Clearing room");
            numJunkPiles = 0;
        }
    }

    private State state;
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(true, state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
