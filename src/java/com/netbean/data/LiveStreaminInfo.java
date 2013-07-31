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
public class LiveStreaminInfo {
    
    public static ArrayList<LiveStreaminInfo> listLiveStream = new ArrayList<LiveStreaminInfo>();
    
    public static ArrayList<LiveStreaminInfo> getlistLiveStream(){
        if(listLiveStream == null) 
            listLiveStream = new ArrayList<LiveStreaminInfo>();
        return listLiveStream;
    }
    
    public static boolean addLiveStream(LiveStreaminInfo lsInfo){
        if(listLiveStream.isEmpty()){
            listLiveStream.add(lsInfo);
            return true;
        }else{
            for(LiveStreaminInfo info: listLiveStream){
                if(info.streamId == lsInfo.streamId){
                    info.status = true;
                    return false;
                }
            }
            
            listLiveStream.add(lsInfo);
            return true;
        }
    }
    
    public static boolean removeLiveStream(int streamId){
        if(listLiveStream.isEmpty()){
            return false;
        }else{
            for(LiveStreaminInfo info: listLiveStream){
                if(info.streamId == streamId){
                    info.status = false;
                    listLiveStream.remove(info);
                    return true;
                }
            }
            return false;
        }
    }
    
    public static ArrayList<LiveStreaminInfo> getLiveStreamByUser(int userId){
        ArrayList<LiveStreaminInfo> listuserStream = new ArrayList<LiveStreaminInfo>();
        for(LiveStreaminInfo info: listLiveStream){
            if(info.userid == userId){
                listuserStream.add(info);
            }
        }
        return listuserStream;
    }
    
    public static LiveStreaminInfo getLiveStreamById( int id){
        for(LiveStreaminInfo info: listLiveStream){
            if(info.streamId != id){
                return info;
            }
        }
        return null;
    }
    
    public static ArrayList<LiveStreaminInfo> getLiveStreamByOtherUser(int userId){
        ArrayList<LiveStreaminInfo> listuserStream = new ArrayList<LiveStreaminInfo>();
        for(LiveStreaminInfo info: listLiveStream){
            if(info.userid != userId){
                listuserStream.add(info);
            }
        }
        return listuserStream;
    }
    
    public int streamId;
    public String streamName;
    public int port;
    public String streamAddress;
    public int userid;
    public String username;
    public boolean status;
}
