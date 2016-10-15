package team4.code_for_good;

/**
 * Created by vkottler on 10/15/2016.
 */

public class Product {

    private int id, pointVal;
    private String name;

    public Product(int id, String name, int pointVal) {
        this.id = id;
        this.name = name;
        this.pointVal = pointVal;
    }

    public int getId() { return id; }
    public int getPointVal() { return pointVal; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return id + ": " + name + " " + pointVal;
    }

}
