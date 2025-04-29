import java.util.ArrayList;

public class Map{

    //Attributes of Map
    private ArrayList<ArrayList<Place>> map;

    /**
     * Constructor for Map
     */
    public Map(){
        this.map = new ArrayList<ArrayList<Place>>();
    
    }

    //Methods
    
    /**
     * Method to add a Place(s) to the map
     * @param places arraylist of places being added to the map
     */
    public void addToMap(ArrayList<Place> places){
        this.map.add(places);
    }

    /**
     * YOU NEED TO FIX THISSSSSSS
     * gets the row of the location in the map (which list is it located in)
     * @param place the place in question
     * @return the row
     */
    public int getRow(Place place){

        for (int i =0;i<this.map.size();i++){
            ArrayList<Place> rowNum = this.map.get(i);
            for (int k = 0;k<rowNum.size();k++){
                if (rowNum.get(k) == place) {
                    return i;
                }
            } 
        }
        return 9;
    }

    /**
     * YOU NEED TO FIX THISSSS TOOOOOO
     * gets the column of the location in the map
     * @param place the place in question
     * @return
     */
    public int getColumn(Place place){
        for (int i =0;i<this.map.size();i++){
            ArrayList<Place> rowNum = this.map.get(i);
            for (int k = 0;k<rowNum.size();k++){
                if (rowNum.get(k) == place) {
                    return k;
                }
            } 
        }
        return 9;
    }
        
    /**
     * Gets the location given the coordinates on the map
     * @param row the locations arraylist
     * @param column the locations location in the sublist
     * @return the Place of the row and column
     */
    public Place getLocation(int row, int column){
        ArrayList<Place> mapRow = map.get(row);
        return mapRow.get(column);
    }

    /**
     * Method to print the Map, only for testing
     */
    public void printMap(){
        System.out.println("");
        for (int i = 0; i < map.size(); i++){
            ArrayList<Place> rowNum = map.get(i);

            for (int k= 0; k< rowNum.size();k++){
                System.out.print(rowNum.get(k).getName()+", ");
            }
            System.out.println();
        }
        System.out.println();
    }
}