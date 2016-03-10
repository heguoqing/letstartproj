package thread;

/**
 * Created by guoqing on 2016/3/10 0010.
 */
public class ThreadCreator {
    public static void main( String[] args )

    {
        System.out.println( "Creating threads" );
        // create each thread with a new targeted runnable

        Thread thread1 = new Thread( new PrintTask( "task1" ) );

        Thread thread2 = new Thread( new PrintTask( "task2" ) );

        Thread thread3 = new Thread( new PrintTask( "task3" ) );


        System.out.println("Threads created, starting tasks.");


        // start threads and place in runnable state

        thread1.start(); // invokes task1抯 run method

        thread2.start(); // invokes task2抯 run method

        thread3.start(); // invokes task3抯 run method




        while (true)
        {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        System.out.println( "Tasks started, main ends.\n" );

    } // end main
}
