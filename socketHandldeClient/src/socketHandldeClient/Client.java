package socketHandldeClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException; 

public class Client {
  
    public static void main(String[] args)
    {
        new Thread(new SimpleClient()).start();
    }
    static class SimpleClient implements Runnable {
 
        @Override public void run()
        {
            Socket socket = null;
            
            try {
                socket = new Socket("localhost", 3333);
                PrintWriter outWriter = new PrintWriter(
                    socket.getOutputStream(), true);
                System.out.println("Hey I am waitng ");
                Thread.sleep(15000);
                
                outWriter.println("Sever application are you there?");
            }
            catch (SocketException e) {
                e.printStackTrace();
            }
 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
 
            catch (UnknownHostException e) {
                e.printStackTrace();
            }

            catch (IOException e) {
                e.printStackTrace();
            }
 
            finally {
                try {
                    if (socket != null)
                        socket.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}