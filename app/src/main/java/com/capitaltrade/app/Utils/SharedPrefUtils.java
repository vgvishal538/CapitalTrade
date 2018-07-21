package com.capitaltrade.app.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {

    private static final String CAPITALTRADE_PREFERENCES = "CapitalTradePrefs";
    public static final String DEALER_reg_no = "reg_no";
    public static final String DEALER_joining_date = "joining_date";
    public static final String DEALER_f_name = "f_name";
    public static final String DEALER_l_name = "l_name";
    public static final String DEALER_mobile = "mobile";
    public static final String DEALER_email = "email";
    public static final String DEALER_dealer_name = "dealer_name";
   public static final String LOGIN_TYPE = "login_type";


    public static void saveDealerLoginData(Context context,String reg_no,String joining_date,
                                     String f_name,String l_name,String mobile,String email,
                                     String dealer_name,String login_type ){

        SharedPreferences sharedPreferences = context.getSharedPreferences(CAPITALTRADE_PREFERENCES,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DEALER_reg_no,reg_no);
        editor.putString(DEALER_joining_date,joining_date);
        editor.putString(DEALER_f_name,f_name);
        editor.putString(DEALER_l_name,l_name);
        editor.putString(DEALER_mobile,mobile);
        editor.putString(DEALER_email,email);
        editor.putString(DEALER_dealer_name,dealer_name);
        editor.putString(LOGIN_TYPE,login_type);
        editor.apply();

    }
    public static void saveFiLoginDate(Context context,String reg_no,String joining_date,String f_name
    , String l_name,String mobile, String login_type){
        SharedPreferences sharedPreferences = context.getSharedPreferences(CAPITALTRADE_PREFERENCES,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DEALER_reg_no,reg_no);
        editor.putString(DEALER_joining_date,joining_date);
        editor.putString(DEALER_f_name,f_name);
        editor.putString(DEALER_l_name,l_name);
        editor.putString(DEALER_mobile,mobile);
        editor.putString(LOGIN_TYPE,login_type);
        editor.apply();
    }

    public static String isLoggedIn(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(CAPITALTRADE_PREFERENCES,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(DEALER_f_name,"");
    }

    public static String getLoginType(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(CAPITALTRADE_PREFERENCES,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(LOGIN_TYPE,"");
    }
    public static String getPersonName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(CAPITALTRADE_PREFERENCES,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(DEALER_f_name,"");
    }

    public static void clearUserData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(CAPITALTRADE_PREFERENCES,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
