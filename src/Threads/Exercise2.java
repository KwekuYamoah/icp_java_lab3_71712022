package Threads;

class Exercise2 implements Runnable {
    private String message;

    public Exercise2(String message) {
        this.message = message;
    }

    public void run(){
        for(int x=1; x<=10;x++) {
            System.out.println(message);
        }
        System.exit (0);
    }

    public static void main(String[] args) {
        //Creating Hello and Goodbye threads
        Exercise2 testHello = new Exercise2 ("hello");
        Thread testThreadHello = new Thread (testHello);

        Exercise2 testGoodBye = new Exercise2 ("goodbye");
        Thread testThreadBye = new Thread (testGoodBye);

        //Setting the name of my threads
        testThreadHello.setName ("Hello Thread");
        testThreadBye.setName ("Goodbye Thread");

        //Starting threads
        System.out.println ("Starting Hello Thread.....");
        testThreadHello.start ();
        System.out.println ("Starting Goodbye Thread.....");
        testThreadBye.start ();

    }
}
