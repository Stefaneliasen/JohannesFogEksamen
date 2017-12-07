package entity;

import java.util.ArrayList;

public class Order {

    private int id;
    private int userId;
    private ArrayList<Material> materials = new ArrayList();
    private String pname;
    private int length;
    private int quantity;
    private int price;
    
    public Order(int id, String pname, int length, int quantity, int price) {
        this.id = id;
        this.pname = pname;
        this.length = length;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Order(int userId, ArrayList<Material> materials) {
        this.materials = materials;
        this.userId = userId;
    }
    public Order (int id, int userId){
        this.id = id;
        this.userId = userId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
