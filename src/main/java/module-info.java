module ca.rashrasa.mazevisualizer {
    requires javafx.controls;
    requires javafx.fxml;

    opens ca.rashrasa.mazevisualizer to javafx.fxml;
    exports ca.rashrasa.mazevisualizer;
    exports ca.rashrasa.mazevisualizer.solving.algorithms;
    opens ca.rashrasa.mazevisualizer.solving.algorithms to javafx.fxml;
    exports ca.rashrasa.mazevisualizer.solving;
    opens ca.rashrasa.mazevisualizer.solving to javafx.fxml;
    exports ca.rashrasa.mazevisualizer.building;
    opens ca.rashrasa.mazevisualizer.building to javafx.fxml;
}