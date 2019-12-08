package sweeps;
import sweeps.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Profile implements Serializable{

    private byte[] hash;
    private ArrayList<Entity> owned;

    public Profile(byte[] hash){
        this.hash = hash;
        owned = new ArrayList<>();
    }

    public byte[] getHash(){
        return hash;
    }
    public ArrayList<Entity> getOwned(){
        return owned;
    }

    public Entity getEntityByID(int id){
        Entity n = null;

        for(Entity i : owned){
            if(i.getID() == id) n = i;

        }
        if( n != null && n.getEnergy() <= 0) owned.remove(n);

        return n;
    }

}
