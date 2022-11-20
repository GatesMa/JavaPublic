package demo;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * MainTest
 *
 * @author by gatesma.
 */
public class MainTest {

    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {

        System.out.println("hello world!");

        LocalDate start = LocalDate.of(2022, 10, 21);
        LocalDate end = LocalDate.of(2022, 11, 15);
        int days = Period.between(start, end).getDays();
        System.out.println(days);

        System.out.println(start.minusDays(days * 2L));
        ;


    }

    // public static void main(String[] args) throws InterruptedException {
    //     Runnable runnable = () -> {
    //         for (int i = 0; i < 1000000000; i++) {
    //             num.getAndAdd(1);
    //         }
    //         System.out.println(Thread.currentThread().getName() + "执行结束!");
    //     };
    //     System.out.println("start");
    //     Thread t1 = new Thread(runnable);
    //     Thread t2 = new Thread(runnable);
    //     t1.start();
    //     t2.start();
    //     Thread.sleep(1000);
    //     System.out.println("num = " + num);
    // }


}