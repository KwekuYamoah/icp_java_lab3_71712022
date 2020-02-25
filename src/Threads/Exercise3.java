package Threads;

/**
 * This version of the question 3 allows
 * the “hello” thread run first, and the “goodbye” thread run after
 * the “hello” thread has finished
 */
class Exercise3 implements Runnable {
    private String message;

    public Exercise3(String message) {
        this.message = message;
    }

    public void run(){
        for(int x=1; x<=10;x++) {
            System.out.println(Thread.currentThread ().getName () +" " + x +" : " + message);
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
        testThreadHello.setPriority (10);
        testThreadBye.setPriority (1);

        //Starting threads
        System.out.println ("Starting Hello Thread.....");
        testThreadHello.start ();

        try{
            testThreadHello.join ();
        }
        catch (InterruptedException e) {
            System.out.println ("Thread interrupted ");
        }

        System.out.println ("Starting Goodbye Thread.....");
        testThreadBye.start ();

    }
}
