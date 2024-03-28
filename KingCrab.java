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

public class KingCrab extends CrabCritter{
	
	public void processActors(ArrayList<Actor> actors){
		for(int i = 0; i < actors.size(); i++){
			Location loc = actors.get(i).getLocation();
			Location next = loc.getAdjacentLocation(getLocation().getDirectionToward(loc));
			if(!moveA(actors.get(i)))
				actors.get(i).removeSelfFromGrid();
		}
	}

	public boolean moveA(Actor ac){
		ArrayList<Location> total = getGrid().getEmptyAdjacentLocations(ac.getLocation());
		for(Location lo : total){
			if(distance(getLocation(), lo)){
				ac.moveTo(lo);
				return true;
			}
		}
		return false;
	}
	
	public boolean distance(Location one, Location two){
		int row = two.getRow()-one.getRow();
		int col = two.getCol()-one.getCol();
		if(row<-1||row>1)
			return true;
		if(col<-1||col>1)
			return true;
		return false;
	}
}
