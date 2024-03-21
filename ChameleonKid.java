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

		Location back = getLocation().getAdjacentLocation(getDirection() + 180);
		ArrayList<Actor> temp = new ArrayList<Actor>();
		if(gr.get(front) == null)
			temp.add(gr.get(front));
		if(gr.get(back) == null)
			temp.add(gr.get(back));
		return temp;
	}
}
