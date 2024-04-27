package ca.rashrasa.mazevisualizer.solving.algorithms;

import ca.rashrasa.mazevisualizer.solving.SolutionSequence;
import ca.rashrasa.mazevisualizer.building.Maze;

public interface SearchAlgorithm {
    SolutionSequence getSolution(Maze maze);
}
