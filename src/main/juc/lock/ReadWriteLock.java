package juc.lock;

/**
 * @author zero
 * @created 2019/10/05
 */
public class ReadWriteLock {

    private volatile int readCount = 0;
    private volatile int writeCount = 0;

    public void lockRead() throws InterruptedException {
        while (writeCount > 0) {
            synchronized (this) {
                wait();
            }
        }
        readCount++;
    }

    public void releaseRead() throws InterruptedException {
        readCount--;
        notifyAll();
    }

    public void lockWrite() throws InterruptedException {
        while (readCount > 0) {
            synchronized (this) {
                wait();
            }
        }
        writeCount++;
    }

    public void releaseWrite() throws InterruptedException {
        writeCount--;
        notifyAll();
    }
}
