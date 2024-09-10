class H2O {

    Semaphore hydrogenSemaphore;
    Semaphore oxygenSemaphore;

    public H2O() {
        this.hydrogenSemaphore = new Semaphore(2);
        this.oxygenSemaphore = new Semaphore(0);

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire(); // Acquire one permit, allowing up to 2 hydrogen threads to proceed.
        releaseHydrogen.run(); // Outputs "H".
        oxygenSemaphore.release(); // Releases one permit to oxygenSemaphore.
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire(2); // Acquires 2 permits, waiting for two hydrogen threads to run first.
        releaseOxygen.run(); // Outputs "O".
        hydrogenSemaphore.release(2); // Releases 2 permits, allowing the next two hydrogen threads to proceed.
    }

}