package Resources;

/**
 * Created by eee on 14.05.2017.
 */
public class Product {
    private int ID;
    private Category Category;
    private String Name;
    private String Consist;
    private double Price;
    private Measure Measure;

    public void setID(int fId) { ID = fId; }
    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }
    public void setName(String fName) {
        Name = fName;
    }

    public String getConsist() {
        return Consist;
    }
    public void setConsist(String fName) {
        Consist = fName;
    }

    public double getPrice() {
        return Price;
    }
    public void setPrice(double fPrice) {
        Price = fPrice;
    }

    public Category getCategory() {return Category;}
    public void setCategory(Category fCategory) {Category = fCategory;}

    public String getCategoryName() { if(Category == null) return "Ошибка"; else return Category.getName(); }

    public Measure getMeasure() {return Measure;}
    public void setMeasure(Measure fMeasure) {Measure = fMeasure;}
}
