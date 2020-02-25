package Threads;

class Exercise5 implements Runnable {
    private int option;
    public static Counter counter = new Counter();


    public Exercise5(int opt) {
        this.option = opt;
    }

    public synchronized void run() {
        synchronized (counter) {
            if (this.option == 1) {
                for (int i = 0; i < 1000; i++) {

                    if (counter.getCounter () + 1 < counter.getMax ()) {
                        counter.setMin (counter.getCounter () + 1);
                    }

                    counter.setCounter (counter.getCounter () + 1);
                }
                System.out.println();
                System.out.println ("The increment thread ended. The value of the counter: " + counter.getCounter ());
                System.out.println ("The maximum value of the counter: " + counter.getMax ());
                System.out.println ("The minimum value of the counter: " + counter.getMin ());


            }

            else {
                for (int i = 0; i < 1000; i++) {

                    if (counter.getCounter () - 1 < counter.getMax ()) {
                        counter.setMin (counter.getCounter () - 1);
                    }

                    counter.setCounter (counter.getCounter () - 1);

                }

                System.out.println ("The decrement thread ended. The value of the counter: " + counter.getCounter ());
                System.out.println ("The maximum value of the counter: " + counter.getMax ());
                System.out.println ("The minimum value of the counter: " + counter.getMin ());
            }
        }
    }

    public static void main(String[] args) {
        Exercise5 testIncrease = new Exercise5 (1);
        Exercise5 testDecrease = new Exercise5 (2);

        Thread threadIncrease = new Thread ( testIncrease);
        Thread threadDecrease = new Thread ( testDecrease);
        threadIncrease.setName("Increment Thread");

        threadDecrease.setName("Decrement Thread");

        threadIncrease.start ();
        threadDecrease.start ();


    }



}

