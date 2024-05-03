package ca.rashrasa.mazevisualizer.solving;

import ca.rashrasa.mazevisualizer.building.Position;

import java.util.HashSet;
import java.util.Set;

public class SolutionSnapshot {
    private Set<Position> exploring;
    private Set<Position> explored;

    public SolutionSnapshot(){
        this.exploring=new HashSet<>();
        this.explored=new HashSet<>();
    }

    public SolutionSnapshot(Set<Position>explored, Set<Position> exploring){
        this.exploring=exploring;
        this.explored=explored;
    }

    public void setExploring(Position p){
        this.explored.remove(p);
        this.exploring.add(p);
    }

    public void setExplored(Position p){
        this.exploring.remove(p);
        this.explored.add(p);
    }

    public Set<Position> getExploring(){
        return exploring;
    }
    public Set<Position> getExplored(){
        return explored;
    }

}
