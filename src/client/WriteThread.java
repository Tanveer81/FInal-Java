package client;

import util.NetworkUtil;
import util.Person;

/**
 * Created by emon on 11/28/2015.
 */
public class WriteThread implements Runnable {
    Main main;
    private Thread thr;
    private NetworkUtil nc;
    Person p;

    public WriteThread(NetworkUtil nc,Main main) {
        this.nc = nc;
        this.p=p;
        this.thr = new Thread(this);
        thr.start();
        this.main=main;
    }

    public void run() {
        try {
            while(true) {
                if(main.a) {
                    nc.write(p);
                }
            }
        } catch(Exception e) {
            System.out.println (e+"writeThread");
        }
        nc.closeConnection();
    }
}
