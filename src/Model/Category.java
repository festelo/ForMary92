package Model;

/**
 * Created by eee on 14.05.2017.
 */
public class Category {
    private int ID;
    private String Name;

    public int getID() {
        return ID;
    }
    public void setID(int fID) {
        ID = fID;
    }

    public String getName() {
        return Name;
    }
    public void setName(String fName) {
        Name = fName;
    }

    public Category(){}
    public Category(int id){ ID = id;}
}
