import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import java.awt.Color;
import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter{
	public ArrayList<Actor> getActors(){
		Grid<Actor> gr = getGrid();
		Location front = getLocation().getAdjacentLocation(getDirection());
		int c = front.getCol();
		if(front.getRow() < 0)
			front = new Location(0,c);
		else if(front.getRow() >= gr.getNumRows())
			front = new Location(gr.getNumRows()-1,c);
		int r = front.getRow();
		if(front.getCol() < 0)
			front = new Location(r,0);
		else if(front.getCol() >= gr.getNumCols())
			front = new Location(r,gr.getNumCols()-1);

		Location back = getLocation().getAdjacentLocation(getDirection() + 180);
		int c1 = back.getCol();
		if(back.getRow() < 0)
			back = new Location(0,c1);
		else if(back.getRow() >= gr.getNumRows())
			back = new Location(gr.getNumRows()-1,c1);
		int r1 = back.getRow();
		if(back.getCol() < 0)
			back = new Location(r1,0);
		else if(back.getCol() >= gr.getNumCols())
			back = new Location(r1,gr.getNumCols()-1);
		
		ArrayList<Actor> temp = new ArrayList<Actor>();
		if(gr.get(front) != null){
			temp.add(gr.get(front));
		}
		if(gr.get(back) != null){
			temp.add(gr.get(back));
		}
		return temp;
	}
}
