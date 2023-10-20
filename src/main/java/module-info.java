module net.conecta4.conecta_4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.conecta4.conecta_4 to javafx.fxml;
    exports net.conecta4.conecta_4;
}