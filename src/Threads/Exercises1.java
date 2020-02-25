package Threads;

class Exercise1 implements Runnable{
    private String message = "hello";

    public void run(){
        for(int x=1; x<=5;x++) {
            System.out.println( message);
        }
    }

    public static void main(String[] args){
        Exercise1 test = new Exercise1 ();
        Thread testThread = new Thread (test);

        testThread.start ();

        try{
            testThread.join ();
        } catch (InterruptedException e) {
            System.out.println (e.getMessage ());
        }

        System.out.println ("goodbye");
        System.exit (0);
    }
}
