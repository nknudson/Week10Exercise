package edu.mac.week10exercise;
import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by nataliya.knudson on 11/9/2016.
 */
public class House {

    int numberOfChildren;
    List<Child> listChild;

    public House() {
        numberOfChildren = 10;
        listChild = new LinkedList<Child>();
        System.out.println("Trick-Or-Treating begins");
        System.out.println("Riley watches TV");
    }

    public void giveCandy() {
        Child child;

        synchronized (listChild) {

            while (listChild.size() == 0) {
                System.out.println("Riley watches TV");
                try {
                    listChild.wait();
                } catch (InterruptedException iex) {
                    iex.printStackTrace();
                }
            }
            child = (Child) ((LinkedList<?>) listChild).poll();
            System.out.println( child.getName() + " rings doorbell " );

        }
        long duration = 100;
        try {
            System.out.println("Riley opens a door for : " + child.getName());
            duration = 2;
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
        System.out.println("Riley gives candy : " + child.getName());
    }

    public void add(Child child) {
        System.out.println( child.getName());

        synchronized (listChild) {
            if (listChild.size() >= numberOfChildren) {
                System.out.println("Line is too big for  " + child.getName());
                System.out.println(child.getName() + " Exits...");
                return;
            }

            ((LinkedList<Child>) listChild).offer(child);
            System.out.println( child.getName() + " goes Treak -Or-Treating.");

            if (listChild.size() == 1)
                listChild.notify();
        }
    }
}
