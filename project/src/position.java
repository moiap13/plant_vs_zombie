public class position
{
    public position(int x, int y)  // Class constructor
    {
        this.x = x;
        this.y = y;
    }
    public position(position pos)  // Class constructor
    {
        this.x = pos.x;
        this.y = pos.y;
    }

    // Getter
    public int getX() { return x; }
    public int getY() { return y; }

    // Setter
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    private int x;
    private int y;
}