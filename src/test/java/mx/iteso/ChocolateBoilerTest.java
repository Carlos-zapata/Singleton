package mx.iteso;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple ChocolateBoiler.
 */
public class ChocolateBoilerTest{

    private ChocolateBoiler chocolateBoiler1;
    private ChocolateBoiler chocolateBoiler2;


    @Before
    public void setUp(){
        chocolateBoiler1 = ChocolateBoiler.getInstance();
        chocolateBoiler2 = ChocolateBoiler.getInstance();

    }

    @org.junit.Test
    public void testisEmpty(){
        assertEquals(true, chocolateBoiler1.isEmpty());
        assertEquals(true, chocolateBoiler2.isEmpty());
    }

    @org.junit.Test
    public void testisBoiled(){
        assertEquals(false, chocolateBoiler1.isBoiled());
        assertEquals(false, chocolateBoiler2.isBoiled());
    }

    @org.junit.Test
    public void testFill(){
        chocolateBoiler1.fill();
        chocolateBoiler1.fill();
        assertEquals(false, chocolateBoiler1.isEmpty());
        //assertEquals(false, chocolateBoiler2.isEmpty());
    }

    @org.junit.Test
    public void testDrain(){
        chocolateBoiler1.drain();
        assertEquals(true, chocolateBoiler1.isEmpty());
        //assertEquals(false, chocolateBoiler2.isEmpty());
    }

    public class Thread implements Runnable
    {


        public void run()
        {
            ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
            if (chocolateBoiler.isEmpty())
            {
                chocolateBoiler.fill();
            }
            else if (!chocolateBoiler.isBoiled())
            {
                chocolateBoiler.boil();
            }
            else if (chocolateBoiler.isBoiled())
            {
                chocolateBoiler.drain();
            }
        }

    }


    @org.junit.Test
    public void HilosTest()
    {
        Thread thread1 = new Thread();
        Thread thread2 =  new Thread();
        Thread thread3 = new Thread();

        thread1.run();
        thread2.run();
        thread3.run();

        chocolateBoiler1.fill();
        chocolateBoiler2.fill();

        assertEquals(chocolateBoiler1.isEmpty(),chocolateBoiler2.isEmpty());


    }
}
