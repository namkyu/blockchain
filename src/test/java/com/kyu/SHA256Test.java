package com.kyu;

import com.google.common.hash.Hashing;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

/**
 * @Project : blockchain
 * @Date : 2017-12-14
 * @Author : nklee
 * @Description :
 */
public class SHA256Test {

    private String ORIGINAL_STRING = "nklee";

    @Test
    public void test_basic() throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(ORIGINAL_STRING.getBytes(StandardCharsets.UTF_8));
        System.out.println("encoded hash : " + encodedHash);
        System.out.println("hexadecimal : " + bytesToHex(encodedHash));
    }

    @Test
    public void test_guava() {
        String sha256hex = Hashing.sha256()
                .hashString(ORIGINAL_STRING, StandardCharsets.UTF_8)
                .toString();
        System.out.println(sha256hex);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Test
    public void test_StringBuilder() {
        StringBuilder builder = new StringBuilder();
        builder.append(0);
        builder.append("78d6a87ba993bced05851a3f610dfb07366aa57f02a813d382873b51eab0601f");
        builder.append(java.time.LocalDateTime.now().toString());
        builder.append("{ amount: 4 }");
        System.out.println(builder.toString());
    }

    @Test
    public void ListTest() {
        List<String> list = Arrays.asList("1", "2");
        System.out.println(list.get(1));
    }
}
