package server;

import util.NetworkUtil;
import util.Person;

/**
 * Created by emon on 11/29/2015.
 */
public class WriteThreadServer implements Runnable {

    private Thread thr;
    private NetworkUtil nc;
    Person P2;
    Main main;

    public WriteThreadServer(NetworkUtil nc,Main main) {
        this.nc = nc;
        this.main=main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while(true) {
                P2=main.P;
                if(P2.getName().equals("Person")&&P2.getPassword().equals("Password")){
                    P2.setValidlogin(true);
                }
                nc.write(P2);
            }
        } catch(Exception e) {
            System.out.println (e);
        }
       nc.closeConnection();
    }
}
