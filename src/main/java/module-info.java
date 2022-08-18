module org.github.youssefagagg {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.github.youssefagagg to javafx.fxml;
    exports org.github.youssefagagg;
}
