package One;

import java.util.HashMap;

public class Remove_Node_IDanPasswords {

    HashMap<String,String> logininfo = new HashMap<String,String>();

    void IDanPasswords(){
        logininfo.put("Bro","pizza");
        logininfo.put("Brometheus" , "Password");
        logininfo.put("BroCode","abc123");
    }

    protected HashMap getLoginInfo(){
        return logininfo;
    }
}
