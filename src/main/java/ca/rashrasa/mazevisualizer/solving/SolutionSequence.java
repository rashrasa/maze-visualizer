package ca.rashrasa.mazevisualizer.solving;

import ca.rashrasa.mazevisualizer.building.Path;

import java.util.ArrayList;
import java.util.List;

public class SolutionSequence {
    private List<SolutionSnapshot> sequence;
    private Path shortestPath;

    public SolutionSequence(){
        this.sequence=new ArrayList<>();
        this.shortestPath=new Path();
    }

    public void add(SolutionSnapshot s){
        sequence.add(s);
    }

    public void setShortestPath(Path p){
        this.shortestPath=p;
    }

    public Path getShortestPath(){
        return this.shortestPath;
    }

    public boolean isEmpty(){
        return sequence.isEmpty();
    }

    public int size(){
        return sequence.size();
    }

}
