package Threads;

/**
 * This version of the question 3 allows
 * threads to alternate more frequently
 */
class Exercise3b implements Runnable {
    private String message;

    public Exercise3b(String message) {
        this.message = message;
    }

    public void run(){
        for(int x=1; x<=10;x++) {
            System.out.println(Thread.currentThread ().getName () +" " + x +" : " + message);
            restThreads (500);

        }
    }

    public void restThreads(int milliseconds){
        try{Thread.sleep (milliseconds);}

        catch (InterruptedException e) {
            System.out.println(e.getMessage ());
            System.exit (0);
        }

    }

    public static void main(String[] args) {
        //Creating Hello and Goodbye threads
        Exercise3 testHello = new Exercise3 ("hello");
        Thread testThreadHello = new Thread (testHello);

        Exercise3 testGoodBye = new Exercise3 ("goodbye");
        Thread testThreadBye = new Thread (testGoodBye);

        //Setting the name and priorities of my threads
        testThreadHello.setName ("Hello Thread");
        testThreadBye.setName ("Goodbye Thread");

        //Starting threads
        System.out.println ("Starting Hello Thread.....");
        testThreadHello.start ();
        System.out.println ("Starting Goodbye Thread.....");
        testThreadBye.start ();

    }
}
