package com.how2java.springboot.helper;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordHelper {
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private static final String hashAlgorithmName = "md5";

    private static final int hashIterations = 1024;

    private static final boolean storedCredentialsHexEncoded = true;

    public static String createSalt() {
        return randomNumberGenerator.nextBytes().toHex();
    }

    public static String createCredentials(String credentials, String salt) {
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials,
                salt, hashIterations);
        return storedCredentialsHexEncoded ? simpleHash.toHex() : simpleHash.toBase64();
    }
    public static boolean checkCredentials(String credentials, String salt, String encryptCredentials) {
        return encryptCredentials.equals(createCredentials(credentials, salt));
    }
   /* public static void main(String[] args) {
        //盐
        String salt = createSalt();
        System.out.println("盐:"+salt);
        System.out.println(salt.length());
        //凭证+盐加密后得到的密码
        String credentials = createCredentials("123456", salt);
        System.out.println("加盐后的密码:"+credentials);
        System.out.println(credentials.length());
        boolean b = checkCredentials("123456", salt, credentials);
        System.out.println(b);
    }*/
}
