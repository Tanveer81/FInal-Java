package client;

import util.Person;

/**
 * Created by emon on 12/3/2015.
 */
public class Show implements Runnable {
    public Person obj;
    Main main;

    Show(Person p,Main main) {
        this.obj = p;
        this.main = main;
    }

    @Override
    public void run() {
        while(true) {
            try {
                if(main.s.equals("home")) {main.showHome();main.s="nothing";}
                if(main.s.equals("login")) {main.showLogIn();main.s="nothing";}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}