package com.debiotech.scheduler.v3.manager;

// import statement  
import java.io.*;

// The ThreadJoin class is the child class of the class Thread  
class ThreadJoin extends Thread
{
    // overriding the run method
    public void run()
    {
        for (int j = 0; j < 2; j++)
        {
            try
            {
// sleeping the thread for 300 milli seconds  
                Thread.sleep(1000);
                System.out.println("The current thread name is: " + Thread.currentThread().getName());
            }
// catch block for catching the raised exception  
            catch(Exception e)
            {
                System.out.println("The exception has been caught: " + e);
            }
            System.out.println( j );
        }
    }
}

