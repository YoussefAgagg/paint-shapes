module org.github.youssefagagg {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.github.youssefagagg.paint;
    opens com.github.youssefagagg.paint to javafx.fxml;
}
