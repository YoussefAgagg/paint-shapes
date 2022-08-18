module org.github.youssefagagg {
    requires javafx.controls;
    requires javafx.fxml;


    exports org.github.youssefagagg.paint;
    opens org.github.youssefagagg.paint to javafx.fxml;
}
