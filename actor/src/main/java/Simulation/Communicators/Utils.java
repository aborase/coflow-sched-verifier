package Simulation.Communicators;

import Simulation.Data.Reducer;
import Simulation.Data.SimTask;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by stanislavmushits on 23/11/15.
 */
public class Utils {
    public static void safePrintln(String s) {
        synchronized (System.out) {
            System.out.println(s);
        }
    }

    public static Socket connectTo(String host, int port, int timeout) throws IOException {
        Socket socket = null;
        boolean scanning=true;
        while(scanning)
        {
            try
            {
                socket = new Socket();
                socket.connect(new InetSocketAddress(host, port), timeout);
                scanning=false;
            }
            catch(ConnectException e) {
                System.out.println("Connect to "+host+":"+port+" failed, waiting and trying again");
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
        return socket;
    }

    public static String getData(long size){
        return new String("a");
    }
}