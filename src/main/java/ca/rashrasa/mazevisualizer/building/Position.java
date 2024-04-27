package ca.rashrasa.mazevisualizer.building;

public class Position {
    private final int x;
    private final int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int x(){
        return x;
    }
    public int y(){
        return y;
    }
}
