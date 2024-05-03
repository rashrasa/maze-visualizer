package ca.rashrasa.mazevisualizer.solving.algorithms;

import ca.rashrasa.mazevisualizer.building.Maze;
import ca.rashrasa.mazevisualizer.building.Path;
import ca.rashrasa.mazevisualizer.building.Position;
import ca.rashrasa.mazevisualizer.solving.SolutionSequence;
import ca.rashrasa.mazevisualizer.solving.SolutionSnapshot;

import java.util.*;

public class BFSAlgorithm implements SearchAlgorithm{
    @Override
    public SolutionSequence getSolution(Maze maze) {
        Set<Position> marked = new HashSet<>();
        ArrayList<Path> searchQueue = new ArrayList<>();
        SolutionSequence seq = new SolutionSequence();
        searchQueue.add(new Path().append(maze.getStart()));
        boolean foundEnd = false;

        while(!foundEnd && !searchQueue.isEmpty()){
            Path current = searchQueue.removeFirst();
            for(Position p: current.get(current.size()-1).getAdjacent()){
                seq.add(new SolutionSnapshot(marked, Set.of(p)));
                if(maze.isInBounds(p) && !containsPosition(marked, p) && !maze.isBlocked(p)){
                    searchQueue.add(current.copy().append(p));
                    marked.add(p);
                    if(p.equals(maze.getEnd())){
                        seq.setShortestPath(current.copy().append(p));
                        foundEnd=true;
                        break;
                    }
                }
            }

        }

        return seq;
    }

    public static boolean containsPosition(Collection<Position> p, Position q){
        for (Position r: p){
            if(r.equals(q)){
                return true;
            }
        }
        return false;
    }
}
