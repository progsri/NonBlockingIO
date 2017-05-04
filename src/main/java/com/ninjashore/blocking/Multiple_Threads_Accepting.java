package com.ninjashore.blocking;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by eng5 on 4/27/17.
 */
public class Multiple_Threads_Accepting {

    public static void main(String... args) {


        try {

            System.out.println("Process ID : " + getPID());
            // Create Socket
            ServerSocket ss = new ServerSocket(11111);

            while (true) {

               Socket socket =  ss.accept();

                System.out.println("Accepted Connection " + socket.getPort() );

               Thread t = new Thread(new Runnable() {
                   @Override
                   public void run() {

                       try {

                           System.out.println("Thread created " + Thread.currentThread().getName());
                           InputStream in = socket.getInputStream();
                           OutputStream ou = socket.getOutputStream();

                           int data;

                           while ((data = in.read()) != -1) {
                               ou.write(data);
                           }
                       }catch ( Exception ex){
                           System.out.println(ex);
                       }

                   }
               });

               t.start();

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("END");
    }


    public static long getPID() {
        String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        if (processName != null && processName.length() > 0) {
            try {
                return Long.parseLong(processName.split("@")[0]);
            } catch (Exception e) {
                return 0;
            }
        }

        return 0;
    }
}
