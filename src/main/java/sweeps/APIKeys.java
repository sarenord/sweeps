package sweeps;

import javax.crypto.KeyGenerator;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class APIKeys {
    private static ArrayList<byte[]> keyHashes = new ArrayList<>();

    public static boolean authenticate(String key) throws NoSuchAlgorithmException {
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");

        byte[] hash = hasher.digest(key.getBytes());
        for(byte[] i : keyHashes){
            if(Arrays.equals(i, hash))return true;
        }
        return false;
    }

    public static String makeAPIKey() throws NoSuchAlgorithmException {
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");

        String salt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789";

        String key = "";

        for(int i = 0; i < 24; i++){
            key += salt.charAt((int)Math.round(Math.random()*(salt.length()-1)));
        }

        keyHashes.add(hasher.digest(key.getBytes()));

        return key;

    }

}
