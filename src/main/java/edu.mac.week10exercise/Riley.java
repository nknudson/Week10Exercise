package edu.mac.week10exercise;

/**
 * Created by nataliya.knudson on 11/9/2016.
 */
public class Riley implements Runnable  {
    House house;

    public Riley(House house)
    {
        this.house = house;
    }
    public void run()
    {
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Riley started..");
        while(true)
        {
            house.giveCandy();
        }
    }
}
