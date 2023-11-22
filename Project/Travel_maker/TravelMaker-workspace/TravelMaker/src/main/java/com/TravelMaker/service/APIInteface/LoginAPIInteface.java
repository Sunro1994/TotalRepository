package com.TravelMaker.service.APIInteface;

import java.util.HashMap;

public interface LoginAPIInteface {

    public String getTokenForJoin(String code);
    public String getTokenForLogin(String code);


    public HashMap<String, String> getInfoForJoin(String token);
    public HashMap<String, String> getInfoForLogin(String token);


    public void logout(String access_token);
}
