package com.ninjashore.blocking;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by eng5 on 4/27/17.
 */
public class SingleThread {

    public  static  void main(String... args){

        System.out.println("Process ID : " + getPID());

        try {
            // Create Socket
            ServerSocket ss = new ServerSocket(11111);

            while(true){

               Thread t =  new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Thread ID : " + Thread.currentThread().getId());
                    }
                });

                t.start();

            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }


    public static long getPID() {
        String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        if (processName != null && processName.length() > 0) {
            try {
                return Long.parseLong(processName.split("@")[0]);
            }
            catch (Exception e) {
                return 0;
            }
        }

        return 0;
    }
}
