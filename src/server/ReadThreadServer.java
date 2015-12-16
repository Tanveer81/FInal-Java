package server;

import util.NetworkUtil;
import util.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;


public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    Main main;

    public ReadThreadServer(NetworkUtil nc, Main main) {
        this.nc = nc;
        this.thr = new Thread(this);
        this.main=main;
        thr.start();
    }

    public void run() {
        try {
            while(true) {
                Object o=nc.read();
                if(o!= null) {
                    if(o instanceof util.Person) {
                        Person obj=(Person)o;
                        obj.setNotice(main.mainnotice);
                        main.hashtable.put(obj.getName(), nc);
                        //System.out.println(obj.getName());
                        if(obj.getMood().equals("signup")){
                            //main.usersdata.add(new userData(obj.getName()));
                            //main.homeControl.usersonline.setItems(main.usersdata);
                            int i=main.getCnt();
                            i++;
                            main.addCnt(i);
                            main.addClient(i,obj.getName(),obj.getPassword(),obj.getfName(),obj.getmName(),obj.getPresentAddress(),
                                    obj.getPerAddress(),obj.getVoterId(),obj.getMobileNo(),"2012-02-13");
                            FileOutputStream fos = new FileOutputStream("F:\\PROJECT FINAL\\Police Control Box\\src\\server\\clientPhotos\\"+obj.getName()+".jpg");
                            fos.write(obj.aray);
                            fos.close();
                            //main.w.add(new allUsers(obj.getName(),obj.getVoterId()));
                            //main.noticeControl.Allusers.setItems(main.w);
                        }
                        else if(obj.getMood().equals("login")) {
                            MySQLConnect oc=new MySQLConnect("localhost","PCB","root","Tanveer@81");
                            String query = "select * from client";
                            ResultSet rs = oc.searchDB(query);
                            while(rs.next())
                            {
                                if(rs.getString("vooterID").equals(obj.getName())){
                                        if(rs.getString("passWord").equals(obj.getPassword())){
                                            obj.setName(rs.getString("name"));
                                            obj.setEmail(rs.getString("email"));
                                            obj.setfName(rs.getString("fName"));
                                            obj.setmName(rs.getString("mName"));
                                            obj.setPresentAddress(rs.getString("presentAddress"));
                                            obj.setPerAddress(rs.getString("permanentAddress"));
                                            obj.setVoterId(rs.getString("vooterID"));
                                            obj.setMobileNo(Integer.toString(rs.getInt("mobileNo")));
                                            obj.setDob(rs.getString("dob"));
                                            obj.setValidlogin(true);
                                           //main.usersdata.add(new userData(obj.getName()));
                                            //main.homeControl.usersonline.setItems(main.usersdata);
                                        }
                                        else obj.setValidlogin(false);
                                        if(obj.isValidlogin()==true){main.hashtable.put(obj.getName(), nc);}
                                        break;
                            }
                            }
                        }
                        else if(obj.getMood().equals("post")) {
                            main.addPost(obj.getName(),obj.getPost());
                            main.data.add(new Data(obj.getName(),obj.getPost()));
                            main.homeControl.allPosts.setItems(main.data);
                            System.out.println(obj.aray);
                            //FileOutputStream fos = new FileOutputStream("F:\\PROJECT FINAL\\Police Control Box\\src\\server\\2.mpg");
                            //fos.write(obj.aray);
                            //fos.close();
                        }
                        //obj.setNotice(main.P.getNotice());
                        nc.write(obj);
                    }
                }
                main.hasGot=true;
            }
        } catch(Exception e) {
            System.out.println (e);
        }
        //nc.closeConnection();
    }
}
