package Threads;

public class Exercise4b implements Runnable {
    Counter mainCounter = new Counter ();
    private int option;

    public  Exercise4b( int option){
        this.option = option;
    }

    public void run(){
        synchronized (mainCounter) {
            if (option == 1) {
                for (int i = 1; i <= 1000; i++) {
                    mainCounter.increaseCounter ();
                }
                System.out.println ("The increment thread has ended " + getValue ());
            } else if (option == 2) {
                for (int i = 1; i <= 1000; i++) {
                    mainCounter.decreaseCounter ();
                }
                System.out.println ("The decrement thread has ended " + getValue ());
            } else {
                System.out.println ("The threads works on the options of 1 and 2, increase and decrease");
            }
        }

    }

    public int getValue(){
        return mainCounter.getCounter ();
    }

    public static void main(String[] args){

        Exercise4b testIncrease = new Exercise4b (1);
        Exercise4b testDecrease = new Exercise4b (2);

        Thread threadIncrease = new Thread ( testIncrease);
        Thread threadDecrease = new Thread ( testDecrease);

        threadIncrease.start ();
        threadDecrease.start ();

        System.out.println ("The value after looping for increment is " + testIncrease.getValue ());

        System.out.println ("The value after looping for decrement is " + testDecrease.getValue ());


        System.exit (0);

    }

}
