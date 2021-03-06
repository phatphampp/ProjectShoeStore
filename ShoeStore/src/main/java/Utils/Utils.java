/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import model.AccountModel;
import model.CartInfo;

/**
 *
 * @author ACER
 */
public class Utils {
    private static AccountModel accountLogined = null;
    public static final CartInfo CartInfoInSession = new CartInfo();
    public static String MD5(String md5) {
        try {
             java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
             byte[] array = md.digest(md5.getBytes());
             StringBuffer sb = new StringBuffer();
             for (int i = 0; i < array.length; ++i) {
               sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
             return sb.toString();
         } catch (java.security.NoSuchAlgorithmException e) {
         }
         return null;
     }
    public static void setAccountInSession(AccountModel acc){
        accountLogined = acc;
    }
    public static AccountModel getAccountInSession(){
        return accountLogined;
    }

    public static void removeAccountInSession() {
        accountLogined = null;
    }
}
