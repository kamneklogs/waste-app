package model;
import java.util.ArrayList;
public class Product{

    private String id, name, description;
    private ArrayList<Residue> myResidues;

    public Product(String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
        myResidues = new ArrayList<Residue>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Residue> getMyResidues() {
        return myResidues;
    }

    public void setMyResidues(ArrayList<Residue> myResidues) {
        this.myResidues = myResidues;
    }

    

}