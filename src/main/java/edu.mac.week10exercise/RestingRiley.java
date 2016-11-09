package edu.mac.week10exercise;

/**
 * Created by nataliya.knudson on 11/9/2016.
 */
public class RestingRiley {
    public static void main(String a[])
    {
        House house = new House();

        Riley riley = new Riley(house);
        ChildrenGenerator cg = new ChildrenGenerator(house);

        Thread host = new Thread(riley);
        Thread thcg = new Thread(cg);
        thcg.start();
        host.start();
    }
}
