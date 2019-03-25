import java.util.ArrayList;
public class Orchard
{
    private String[][] plants;
    
    public Orchard(String[][] plants)
    {
        this.plants = plants;
    }
    
    public boolean willFruit(Position pos)
    {
        int row = pos.getRow();
        int col = pos.getCol();
        for (int i=0; i<plants.length; i++) {
            for (int j=0; j<plants[0].length; j++) {
                if (plants[i][j].equals("male") &&
                    plants[row][col].equals("female") &&
                    Math.abs(row-i) < 3 &&
                    Math.abs(col-j) < 3)
                    return true;
            }
        }
        return false;
    }
    
    public ArrayList<Position> nonFruitingPlants() {
        ArrayList noFruit = new ArrayList<Position>();
        for (int i=0; i<plants.length; i++) {
            for (int j=0; j<plants[i].length; j++) {
                Position current = new Position(i,j);
                if (plants[i][j].equals("female"))
                    noFruit.add(willFruit(current));
            }
        }
        return noFruit;
    }
}
