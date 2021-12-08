package One;

import java.util.HashMap;

public class IDanPasswords {

    HashMap<Integer,Integer> logininfo = new HashMap<Integer,Integer>();


    IDanPasswords(){
        logininfo.put(1,0);
    }

     protected HashMap getLoginInfo(){
        return logininfo;
     }
}
