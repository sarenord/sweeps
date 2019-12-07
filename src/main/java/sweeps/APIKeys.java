package sweeps;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

public class APIKeys {
    private static ArrayList<byte[]> keyHashes;

    public static boolean authenticate(String key) throws NoSuchAlgorithmException {
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");

        byte[] hash = hasher.digest(key.getBytes());
        for(byte[] i : keyHashes){
            if(Arrays.equals(i, hash))return true;
        }
        return false;
    }



}
