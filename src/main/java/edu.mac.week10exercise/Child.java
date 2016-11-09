package edu.mac.week10exercise;

/**
 * Created by nataliya.knudson on 11/9/2016.
 */
public class Child implements Runnable {
    String name;

    House house;

    public Child(House house)
    {
        this.house = house;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public void run()
    {
        goForCandy();
    }
    private synchronized void goForCandy()
    {
        house.add(this);
    }
}
