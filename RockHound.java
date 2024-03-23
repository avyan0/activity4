import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import java.awt.Color;
import java.util.ArrayList;

public class RockHound extends Critter{
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (!(a instanceof Critter))
                a.removeSelfFromGrid();
        }
    }
}
