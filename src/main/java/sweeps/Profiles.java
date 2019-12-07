package sweeps;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

public class Profiles {
    private static ArrayList<Profile> profiles = new ArrayList<>();

    public static boolean authenticate(String key) throws NoSuchAlgorithmException {
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");

        byte[] hash = hasher.digest(key.getBytes());
        for(Profile i : profiles){
            if(Arrays.equals(i.getHash(), hash))return true;
        }
        return false;
    }

    public static String makeAPIKey() throws NoSuchAlgorithmException {
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");

        String salt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789";

        String key = "";

        while(authenticate(key)||key.equals("")) {
            for (int i = 0; i < 24; i++) {
                key += salt.charAt((int) Math.round(Math.random() * (salt.length() - 1)));
            }
        }

        profiles.add(new Profile(hasher.digest(key.getBytes())));

        return key;
    }

    public static Profile getProfile(String key) throws NoSuchAlgorithmException {
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");

        byte[] hash = hasher.digest(key.getBytes());
        for (Profile i : profiles) {
            if (Arrays.equals(i.getHash(), hash)) return i;
        }
        return new Profile("".getBytes());
    }

}
