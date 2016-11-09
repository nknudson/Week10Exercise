package edu.mac.week10exercise;
import java.util.concurrent.TimeUnit;

/**
 * Created by nataliya.knudson on 11/9/2016.
 */
public class ChildrenGenerator implements Runnable {
    House house;

    public ChildrenGenerator(House house)
    {
        this.house = house;
    }

    public void run()
    {
        while(true)
        {
            Child child = new Child(house);

            Thread theChild = new Thread(child);
            child.setName("Child "+ theChild.getId());
            theChild.start();

            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
}
