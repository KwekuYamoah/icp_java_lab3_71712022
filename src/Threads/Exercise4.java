package Threads;

class Exercise4 implements Runnable {
    private Counter myCountObject; //Stores a reference to a single counter object

    public  Exercise4(Counter count){
        myCountObject = count;
    }


    public void run(){
        myCountObject.increaseCounter ();
        myCountObject.decreaseCounter ();
    }



    public static void main(String[] args) {
        Counter testCounter = new Counter ();
        Exercise4[] threadsForCount = new Exercise4[1000]; //The size of the array represents the iterations for the threads.

        System.out.println ("Initial value:" + testCounter.getCounter ());
        for(int i = 0; i < threadsForCount.length; i++){
            threadsForCount[i] = new Exercise4 (testCounter);
            new Thread (threadsForCount[i]).start ();
        }

        System.out.println ("After value:" + testCounter.getCounter ());
    }
}
