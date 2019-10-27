package model;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents the products
 * 
 * @author Camilo Cordoba.
 * @since 1.0
 */
public class Product{

    private String id, name, description;
    private ArrayList<Residue> myResidues;

    public Product(String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
        myResidues = new ArrayList<Residue>();
    }

    /**
     * This method return the potition of a archangel searched by name
     * <b>pre:</b> The param string is a valid string <br>
     * <b>post:</b> position is found. If not found return -1 <br>
     * 
     * @param name is a valid String != null
     * @return int that containing the required potition
     */
    public Residue[] sortMyResidues(){

        Residue[] toSort = null;
        

        if(!(myResidues.isEmpty())){

            toSort = myResidues.toArray(new Residue[myResidues.size()]);

            Arrays.sort(toSort);

        }

        return toSort;
    }


    /**
     * This method return the potition of a archangel searched by name
     * <b>pre:</b> The param string is a valid string <br>
     * <b>post:</b> position is found. If not found return -1 <br>
     * 
     * @param name is a valid String != null
     * @return int that containing the required potition
     */
    public void showSortedByHarmfulEffect(){
        Residue[] toPrint = sortMyResidues();
        int aux = 1;

        for (Residue r : toPrint) {
            System.out.println( " " + aux + ". " + r.getName() + ". Con un efecto nocivo de: " + r.harmfulEffect());
            aux++;
        }

        System.out.println("");

    }

    

    /**
     * This method return the potition of a archangel searched by name
     * <b>pre:</b> The param string is a valid string <br>
     * <b>post:</b> position is found. If not found return -1 <br>
     * 
     * @param name is a valid String != null
     * @return int that containing the required potition
     */
    public String listRName(){
        String listN = "";
        int i = 1;
        for (Residue r : myResidues) {
            
            listN += " " + i + ". " + r.getName() + ".\n";
            i++;
        }

        return listN;
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

}