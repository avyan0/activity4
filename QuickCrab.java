import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Critter;
import java.util.ArrayList;

import java.awt.Color;

public class QuickCrab extends CrabCritter{
	
	public ArrayList<Location> getLocationsInDirections(int[] dirs){
		ArrayList<Location> locs = new ArrayList<Location>();
		Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        for(int i = 0; i < dirs.length; i++){
			Location next = loc.getAdjacentLocation(getDirection()+dirs[i]);
			Location second = next.getAdjacentLocation(getDirection()+dirs[i]);
			if(gr.isValid(next) && gr.isValid(second) && gr.get(next) == null && gr.get(second) == null)
				locs.add(second);
		}
		if(locs.size() == 0)
        	return super.getLocationsInDirections(dirs);
        else
        	return locs;
	}
}
