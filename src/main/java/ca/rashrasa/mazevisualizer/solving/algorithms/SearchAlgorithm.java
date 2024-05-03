package ca.rashrasa.mazevisualizer.solving.algorithms;

import ca.rashrasa.mazevisualizer.building.Maze;
import ca.rashrasa.mazevisualizer.solving.SolutionSequence;

public interface SearchAlgorithm {
    SolutionSequence getSolution(Maze maze);
}
