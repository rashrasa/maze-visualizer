package ca.rashrasa.mazevisualizer.building;

import ca.rashrasa.mazevisualizer.solving.SolutionSequence;
import ca.rashrasa.mazevisualizer.solving.SolutionSnapshot;
import ca.rashrasa.mazevisualizer.solving.algorithms.SearchAlgorithm;

public class MazeSolver {
    private SearchAlgorithm algorithm;
    private Maze maze;
    private SolutionSequence solution;

    public MazeSolver(Maze maze, SearchAlgorithm algorithm){
        this.algorithm = algorithm;
        this.maze = maze;
        this.solution = null;
        this.run();
    }
    private void run(){
        this.solution = this.algorithm.getSolution(this.maze);
    }
    public SolutionSnapshot getSolution(int step){
        return this.solution.get(step);
    }
}
