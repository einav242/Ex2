package One;

import java.util.HashMap;

public class myGraph {

    HashMap<Integer,Integer> logininfo = new HashMap<Integer,Integer>();


    myGraph(){
        logininfo.put(1,0);
    }

     protected HashMap getLoginInfo(){
        return logininfo;
     }
}
