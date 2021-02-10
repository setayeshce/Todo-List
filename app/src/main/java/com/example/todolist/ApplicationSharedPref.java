package com.example.todolist;

import android.content.Context;
import android.content.SharedPreferences;


public class ApplicationSharedPref {
    private SharedPreferences sharedPreferences;
    public static final String USERNAME = "username";
    public static final String PHONE = "phone";
    public static final String REMEMBER_ME ="remember_me";

    ApplicationSharedPref(Context context){

     sharedPreferences = context.getSharedPreferences("APP_SHARED",Context.MODE_PRIVATE);

    }

public void  savedUsernameAndPhone(String name,String phone){
        sharedPreferences.edit().putString(USERNAME,name).apply();
        sharedPreferences.edit().putString(PHONE,phone).apply();
}
public String getPhone(){
        return sharedPreferences.getString(PHONE,"");
}
public String getName(){
        return sharedPreferences.getString(USERNAME,"");
}
public void  setRememberMe(boolean rm){
        sharedPreferences.edit().putBoolean(REMEMBER_ME,rm).apply();
}
public boolean  getRememberMe(){
        return sharedPreferences.getBoolean(REMEMBER_ME,false);
}
}
