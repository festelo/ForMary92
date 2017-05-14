package Resources;

/**
 * Created by eee on 14.05.2017.
 */
public class Courier {
    private int ID;
    private String Name;
    private String Phone;
    public boolean isWorking;

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

    public String getWorkingText() { if(isWorking) return "Да"; else return "Нет";  }

    public String getPhone() {
        return Phone;
    }
    public void setPhone(String fPhone) {
        Phone = fPhone;
    }
}
