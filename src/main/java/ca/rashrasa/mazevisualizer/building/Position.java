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
    public Position[] getAdjacent(){
        return new Position[]{
                new Position(this.x+1, this.y),
                new Position(this.x-1, this.y),
                new Position(this.x, this.y+1),
                new Position(this.x, this.y-1)
        };
    }

    public String toString(){
        return "(" + this.x() + ", " + this.y() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(this.getClass()!=obj.getClass()){
            return false;
        }
        Position p = (Position) obj;
        return this.x() == p.x() && this.y() == p.y();
    }
}
