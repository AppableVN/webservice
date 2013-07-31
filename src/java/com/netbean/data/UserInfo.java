/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbean.data;

import java.util.ArrayList;

/**
 *
 * @author Dragonboy
 */

public class UserInfo {
    
    
    public static ArrayList<UserInfo> listusers = new ArrayList<UserInfo>();
    
    public static ArrayList<UserInfo> getListUser(){
        if(listusers == null)
            listusers = new ArrayList<UserInfo>();
        return listusers;
    }
    
    public static UserInfo getUserInfoById(int userId){
        if(listusers.isEmpty()) return null;
        else{
            for(UserInfo info: listusers){
                if(info.userid == userId){
                    return info;
                }
            }
            return null;
        }
    }
    
    public static UserInfo getUserInfoByName(String userName){
        if(listusers.isEmpty()) return null;
        else{
            for(UserInfo info: listusers){
                if(info.username.compareTo(userName) == 0){
                    return info;
                }
            }
            return null;
        }
    }
    
    public static boolean updateUserLogout(String userid){
        boolean result = true;
        if(listusers.size() == 0){
            return true;
        }else{
            for(UserInfo user: listusers){
                if(user.userid == Integer.valueOf(userid)){
                    listusers.remove(user);
                    return true;
                }
            }
            result = false;
        }
        return result;
    }
    
    public static boolean updateUserLogin(String userName){
        boolean result = true;
        if(listusers.size() == 0){
            UserInfo newUser = new UserInfo();
            newUser.username = userName;
            newUser.userid = userName.hashCode();
            newUser.state = true;
            listusers.add(newUser);
            result = true;
        }else{
            boolean isExist = false;
            for(UserInfo user: listusers){
                if(user.username.compareTo(userName) == 0){
                    isExist = true;
                    if(user.state = false){
                        user.state = true;
                        result = true;
                        break;
                    }else{
                        result = false;
                        break;
                    }
                }
            }
            if(!isExist){
                UserInfo newUser = new UserInfo();
                newUser.username = userName;
                newUser.userid = userName.hashCode();
                newUser.state = true;
                listusers.add(newUser);
                result = true;
            }
        }
        return result;
    }
    
    
    public int userid;
    public String username;
    public boolean state;
}
