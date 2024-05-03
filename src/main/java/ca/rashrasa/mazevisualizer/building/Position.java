package ca.rashrasa.mazevisualizer.building;

/**
 * Immutable position object with integer x and y values.
 */
public class Position {
    private final int x;
    private final int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int x(){
        return this.x;
    }
    public int y(){
        return this.y;
    }

    public boolean isAdjacentTo(Position p){
        return  (this.x()==p.x()+1 && this.y()==p.y()) ||
                (this.x()==p.x()-1 && this.y()==p.y()) ||
                (this.x()==p.x() && this.y()==p.y()+1) ||
                (this.x()==p.x() && this.y()==p.y()-1);
    }
    public String toString(){
        return "(" + this.x() + ", " + this.y() + ")";
    }
}
