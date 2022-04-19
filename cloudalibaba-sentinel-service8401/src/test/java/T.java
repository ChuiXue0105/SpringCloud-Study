/**
 * @author 丁鹏
 * @version $ Id: T, v 0.1 2022/04/15 18:42 peng.ding Exp $
 */
public class T {

    private static int count = 0;
    private final static Object lock = new Object();

    public static void main(String[] args) {
//        Thread even = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (count <= 100) {
//                    synchronized (lock) {
//                        System.out.println("偶数线程" + count++);
//                        lock.notifyAll();
//                        try {
//                            // 如果还没有结束，则让出当前的锁并休眠
//                            if (count <= 100) {
//                                lock.wait();
//                            }
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        });

//        Thread odd = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (count <= 100) {
//                    synchronized (lock) {
//                        System.out.println("奇数线程" + count++);
//                        lock.notifyAll();
//                        try {
//                            // 如果还没有结束，则让出当前的锁并休眠
//                            if (count <= 100) {
//                                lock.wait();
//                            }
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        });
//
//        even.start();
//        // 确保偶数线程先获得锁
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        odd.start();


        new Thread(new TurningRunner(),"窗口1买票").start();
        // 确保偶数线程先获得锁
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(new TurningRunner(),"窗口2买票").start();
        new Thread(new TurningRunner(),"窗口3买票").start();

    }

    static class TurningRunner implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                // 获取锁
                synchronized (lock) {
                    // 拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    // 唤醒其它线程
                    lock.notifyAll();
                    try {
                        if (count <= 100) {
                            // 如果还没有结束，则让出当前的锁并休眠
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


