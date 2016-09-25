/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.util;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 *
 * @author Mon
 */
public class SharedPrefs {
//    Preferences sharedPrefs = Preferences.userNodeForPackage(SharedPrefs.class);
    Preferences sharedPrefs = Preferences.userRoot().node(this.getClass().getName());
            
    
    final String PREF_UNAME = "username";
    final String PREF_PASSWORD = "password";
    final String PREF_IPADDRESS = "ip_address";
    public void setUsername(String username) {
        sharedPrefs.put(PREF_UNAME, username);
    }
    public String getUsername() {
        String username = sharedPrefs.get(PREF_UNAME, "");
        return username;
    }
    public void setPassword(String password) {
        sharedPrefs.put(PREF_PASSWORD, password);
    }
    public String getPassword() {
        String password = sharedPrefs.get(PREF_PASSWORD, "");
        return password;
    }
    public void setIpAddress(String ipAddress) {
        sharedPrefs.put(PREF_IPADDRESS, ipAddress);
    }
    public String getIpAddress() {
        String ipAddress = sharedPrefs.get(PREF_IPADDRESS, "");
        return ipAddress;
    }
    public void removeIpAddress() {
        sharedPrefs.remove(PREF_IPADDRESS);
    }
    public void removeUnamePass() {
        sharedPrefs.remove(PREF_UNAME);
        sharedPrefs.remove(PREF_PASSWORD);
    }
    public void clearPrefs() throws BackingStoreException {
        sharedPrefs.clear();
    }
}
