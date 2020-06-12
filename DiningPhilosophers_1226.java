import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers_1226 {

    private static ReentrantLock[] lockList = {
        new ReentrantLock(),
        new ReentrantLock(),
        new ReentrantLock(),
        new ReentrantLock(),
        new ReentrantLock()
    };
    private Semaphore eatLimit = new Semaphore(4);

    public DiningPhilosophers_1226() {
        
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        
        int leftFork = philosopher % 5;
        int rightFork = (philosopher + 1) % 5;
        eatLimit.acquire();
        
        lockList[rightFork].lock();
        lockList[leftFork].lock();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        lockList[rightFork].unlock();
        lockList[leftFork].unlock();

        eatLimit.release();
    }
}