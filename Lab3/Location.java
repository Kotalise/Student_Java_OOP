public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Location) {
            Location other = (Location) obj;

            if (xCoord == other.xCoord &&
                    yCoord == other.yCoord)
            {
                return true;
            }
        }

        return false;
    }

    public int hashCode()
    {
        int prime = 19;
        int result = 1;
        // Use another prime value to combine
        result = prime * result + xCoord;
        result = prime * result + yCoord;

        return result;
    }
}