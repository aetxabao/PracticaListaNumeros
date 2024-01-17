module com.masanz.prog.ut5.practicalistanumeros {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.masanz.prog.ut5.pln to javafx.fxml;
    exports com.masanz.prog.ut5.pln;
}