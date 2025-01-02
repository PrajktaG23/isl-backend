//package com.platform.isl_backend.Service;
//
//import java.util.Base64;
//import java.security.SecureRandom;
//
//public class SecretKeyGenerator {
//    public static void main(String[] args) {
//        SecureRandom random = new SecureRandom();
//        byte[] key = new byte[32]; // 256 bits
//        random.nextBytes(key);
//        String secretKey = Base64.getEncoder().encodeToString(key);
//        System.out.println("Generated SECRET_KEY: " + secretKey);
//    }
//}
//
