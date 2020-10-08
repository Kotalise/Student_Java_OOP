import java.util.HashMap;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;

    public HashMap<Location, Waypoint> openPoint = new HashMap<Location, Waypoint>();
    public HashMap<Location, Waypoint> closedPoint = new HashMap<Location, Waypoint>();


    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        System.out.println("Getting min open waypoint");
        Waypoint minOpenWaypoint = null;
        float min = Float.MAX_VALUE;
        if (openPoint.size() != 0){
            for (Waypoint value : openPoint.values()){
                float cost = value.getTotalCost();
                if (cost < min){
                    min = cost;
                    minOpenWaypoint = value;
                }
            }
            System.out.println("Got min open waypoint: " + minOpenWaypoint);
            return minOpenWaypoint;
        }
        else
            return null;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        boolean isInSet = openPoint.containsKey(newWP.getLocation());
        if (!isInSet){
            System.out.println("New open waypoint");
            openPoint.put(newWP.getLocation(), newWP);
            return true;
        }
        else{
            Waypoint prevWaypoint = openPoint.get(newWP.getLocation());
            if (prevWaypoint.getPreviousCost() > newWP.getPreviousCost()){
                System.out.println("Better open waypoint");
                openPoint.put(newWP.getLocation(), newWP);
                return true;
            }
        }
        System.out.println("Open waypoint wasn't added");
        return false;
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        System.out.println("Size of openPoint: " + openPoint.size());
        return openPoint.size();
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        System.out.println("Closing waypoint. Size of closedPoint: " + closedPoint.size());
        Waypoint p = openPoint.remove(loc);
        closedPoint.put(loc, p);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        System.out.println("Is waypoint closed? " + closedPoint.containsKey(loc));
        return closedPoint.containsKey(loc);
    }
}