package com.example.nuhavarier.shopping_app.shared_preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by avi on 12/1/18.
 */

public class PrefHelper implements PreferenceConstants {
    private static PrefHelper _instance;
    private static Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private PrefHelper(){
        sharedPreferences = context.getSharedPreferences(SHARED_PRE_LOGIN_REGISTRATION,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static PrefHelper getInstance(Context iContext){
        context = iContext;
        if (_instance == null){
            _instance = new PrefHelper();
        }
        return _instance;
    }

    public boolean getIsUserLoggedIn(){
        return sharedPreferences.getBoolean(IS_USER_LOGGED_IN,false);
    }

    public void setIsUserLoggedIn(boolean isUserLoggedIn){
        editor.putBoolean(IS_USER_LOGGED_IN, isUserLoggedIn);
        editor.commit();
    }

    public String getUserTitle() {
        return sharedPreferences.getString(USER_TITLE,null);
    }

    public void setUserTitle(String userTitle) {
        editor.putString(USER_TITLE,userTitle);
        editor.commit();
    }

    public String getUserName() {
        return sharedPreferences.getString(USER_NAME,null);
    }

    public void setUserName(String userName) {
        editor.putString(USER_NAME,userName);
        editor.commit();
    }

    public String getUserEmail() {
        return sharedPreferences.getString(USER_EMAIL,null);
    }

    public void setUserEmail(String userEmail) {
        editor.putString(USER_EMAIL,userEmail);
        editor.commit();
    }

    public String getUserPhone() {
        return sharedPreferences.getString(USER_PHONE,null);
    }

    public void setUserPhone(String userPhone) {
        editor.putString(USER_PHONE,userPhone);
        editor.commit();
    }

    public String getUserImage() {
        return sharedPreferences.getString(USER_IMAGE,null);
    }

    public void setUserImage(String userImage) {
        editor.putString(USER_IMAGE,userImage);
        editor.commit();
    }

    public String getUserPasssword() {
        return sharedPreferences.getString(USER_PASSWORD,null);
    }

    public void setUserPasssword(String userPasssword) {
        editor.putString(USER_PASSWORD,userPasssword);
        editor.commit();
    }

    public void setIsUserLoggedInWithFG(boolean isUserLoggedInWithFG){
        editor.putBoolean(FG_LOGIN,isUserLoggedInWithFG);
        editor.commit();

    }

    public boolean getIsUserLoggedInWithFG(){
        return sharedPreferences.getBoolean(FG_LOGIN,false);
    }

    public void setUserId(String id){
        editor.putString(USER_ID,id);
        editor.commit();
    }

    public String getUserId(){
        return sharedPreferences.getString(USER_ID,null);
    }

    public void setUserAutoId(String autoId){
        editor.putString(USER_AUTO_ID,autoId);
        editor.commit();
    }

    public String getUserAutoId(){
        return sharedPreferences.getString(USER_AUTO_ID,null);
    }

    public void setLastSelectedAddress(String lastSelectedAddress){
        editor.putString(LAST_SELECTED_ADDRESS,lastSelectedAddress);
        editor.commit();
    }

    public String getLastSelectedAddress(){
        return sharedPreferences.getString(LAST_SELECTED_ADDRESS,null);
    }

    public void setRestaurantAddress(String restaurantAddress){
        editor.putString(RESTAURANT_ADDRESS,restaurantAddress);
        editor.commit();
    }

    public String getRestaurantAddress(){
        return sharedPreferences.getString(RESTAURANT_ADDRESS,null);
    }

    public void setIsPickup(boolean isPickup){
        editor.putBoolean(IS_PICKUP,isPickup);
        editor.commit();
    }

    public boolean getIsPickup(){
        return sharedPreferences.getBoolean(IS_PICKUP,false);
    }

    public String getWithWhich(){
        return sharedPreferences.getString(WITH_WHICH,null);
    }

    public void setWithWhich(String withWhich){
        editor.putString(WITH_WHICH,withWhich);
        editor.commit();
    }

    public void setUserReward(Integer reward){
        editor.putInt(USER_REWARDS,reward);
        editor.commit();
    }

    public Integer getUserReward(){
        return sharedPreferences.getInt(USER_REWARDS,0);
    }

    public void setOffers(Integer offers){
        editor.putInt(OFFERS,offers);
        editor.commit();
    }

    public Integer getOffers(){
        return sharedPreferences.getInt(OFFERS,0);
    }

    public String getDeviceId(){
        return sharedPreferences.getString(DEVICE_ID,null);
    }

    public void setDeviceId(String deviceId){
        editor.putString(DEVICE_ID,deviceId);
        editor.commit();
    }

    public void removeUser(){
        if (sharedPreferences.contains(USER_TITLE))editor.remove(USER_TITLE);
        if (sharedPreferences.contains(USER_ID))editor.remove(USER_ID);
        if (sharedPreferences.contains(USER_NAME))editor.remove(USER_NAME);
        if (sharedPreferences.contains(USER_EMAIL))editor.remove(USER_EMAIL);
        if (sharedPreferences.contains(USER_PHONE))editor.remove(USER_PHONE);
        if (sharedPreferences.contains(USER_IMAGE))editor.remove(USER_IMAGE);
        if (sharedPreferences.contains(USER_PASSWORD))editor.remove(USER_PASSWORD);
        if (sharedPreferences.contains(FG_LOGIN))editor.remove(FG_LOGIN);
        if (sharedPreferences.contains(USER_AUTO_ID))editor.remove(USER_AUTO_ID);
        if (sharedPreferences.contains(LAST_SELECTED_ADDRESS))editor.remove(LAST_SELECTED_ADDRESS);
        if (sharedPreferences.contains(IS_PICKUP))editor.remove(IS_PICKUP);
        if (sharedPreferences.contains(WITH_WHICH))editor.remove(WITH_WHICH);

        editor.putBoolean(IS_USER_LOGGED_IN,false);
        editor.commit();
    }

}
