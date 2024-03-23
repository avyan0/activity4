import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import java.awt.Color;
import java.util.ArrayList;

public class BlusterCritter extends Critter {
    private int c;
    public BlusterCritter(int x){
        c=x;
    }
    public BlusterCritter(){
        c=2;
    }
    public ArrayList<Actor> getActors(){
        ArrayList temp = new ArrayList<Actor>();
        Grid gr = getGrid();
        int row = getLocation().getRow();
        int col = getLocation().getCol();
        int maxr = gr.getNumRows();
        int maxc = gr.getNumCols();

        for(int i = -2; i < 3; i++){
            for(int j = -2; j < 3; j++){
                int r = row + i;
                int c = col + j;
                if(!(r== 0 && c==0)){
                    if(r>0 && r<maxr && c>0 && c<maxc){
                        if(gr.get(new Location(r,c)) != null)
                            temp.add(gr.get(new Location(r,c)));
                    }
                }
            }
        }
        return temp;
    }

    public void processActors(ArrayList<Actor> actors){
        if(c>actors.size()){
            Color c = getColor();
             int red = (int)(c.getRed() * .5);
             int green = (int)(c.getGreen() * .5);
             int blue = (int)(c.getBlue() * .5);
             setColor(new Color(red,green,blue));
        }
        else if(c<actors.size()){
            Color c = getColor();
             int red = Math.min(255,(int)(c.getRed() *1.5));
             int green = Math.min(255,(int)(c.getGreen() *1.5));
             int blue = Math.min(255,(int)(c.getBlue() *1.5));
             setColor(new Color(red,green,blue));
        }
    }
}
