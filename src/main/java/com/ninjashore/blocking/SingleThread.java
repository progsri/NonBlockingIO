package com.ninjashore.blocking;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by eng5 on 4/27/17.
 */
public class SingleThread {

    public static void main(String... args) {
       try {
            System.out.println("Process ID : " + getPID());

            // Creates Socket..
            //
            // verify this Socket is nothing but a combination of source address + source port + destination address + destination port.
            // it is of no use unless some one listens on a socket.

            ServerSocket ss = new ServerSocket(11111);
            ss.accept();
            System.out.println("ACCEPTED");
            while (true) {
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
