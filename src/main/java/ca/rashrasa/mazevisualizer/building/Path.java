package ca.rashrasa.mazevisualizer.building;

import java.util.ArrayList;
import java.util.List;

/**
 * Mutable sequence of Position elements.
 * Each new position appended must be adjacent to the previous.
 */
public class Path {
    private List<Position> path;

    public Path(){
        this.path=new ArrayList<>();
    }

    public void append(Position p){
        if (this.path.isEmpty()){
            this.path.add(p);
        }
        else if(this.path.get(path.size()-1).isAdjacentTo(p)){
            this.path.add(p);
        }
        else{
            throw new IllegalArgumentException("Cannot append a position which isn't adjacent to the previous position in the sequence.");
        }
    }

    public Position remove(){
        return this.path.removeLast();
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append('{');
        for(Position p : this.path){
            s.append(p.toString());
            s.append(", ");
        }
        s.replace(s.length()-2,s.length(), "}");
        return s.toString();
    }
}
