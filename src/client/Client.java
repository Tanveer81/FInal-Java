package client;

import util.NetworkUtil;

/**
 * Created by emon on 11/28/2015.
 */
public class Client implements Runnable{
    public NetworkUtil nc;
    Main main;
    Client(Main main){this.main=main;}


    @Override
    public void run() {
            try {
                String serverAddress = "127.0.0.1";
                int serverPort = 33333;
                nc = new NetworkUtil(serverAddress,serverPort);
                main.nc=nc;
                new ReadThread(nc,main);
                //new WriteThread(nc,main);
            } catch(Exception e) {
                System.out.println (e+"client");
            }
        }

}