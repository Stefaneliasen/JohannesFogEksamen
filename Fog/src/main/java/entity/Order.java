package entity;

import java.util.ArrayList;

public class Order {

    private int id;
    private int userId;
    private ArrayList<Material> materials = new ArrayList();

    public Order(int userId, ArrayList<Material> materials) {
        this.materials = materials;
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

}
