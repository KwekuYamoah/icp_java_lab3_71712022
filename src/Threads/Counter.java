package Threads;

class Counter {
    private int counter;
    private int max;
    private int min;

    public Counter() {
        this.counter = 0;
        this.max = 0;
        this.min = 0;
    }

    public void increaseCounter() {
        int temp;
        temp = counter;
        temp++;
        counter = temp;
    }

    public void decreaseCounter() {
        int temp;
        temp = counter;
        temp--;
        counter = temp;
    }
    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }
    /**
     * @return the max value
     */
    public int getMax() {
        return max;
    }
    /**
     * @return the min value
     */
    public int getMin() {
        return min;
    }
    /**
     * @param counter the counter to set
     */
    public Counter setCounter(int counter) {
        this.counter = counter;
        return this;
    }
    /**
     * @param max the max value to set
     */
    public Counter setMax(int max) {
        this.max = max;
        return this;
    }
    /**
     * @param min the min value to set
     */
    public Counter setMin(int min) {
        this.min = min;
        return this;
    }
}

