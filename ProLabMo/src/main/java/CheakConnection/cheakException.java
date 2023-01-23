package CheakConnection;

import javafx.scene.control.Alert;

public class cheakException {
    public static void errorMessageID() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Ooops the ID  exist");
        alert.showAndWait();

    }
    public static void errorMessageIDDoc() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Ooops the ID doctor  exist");
        alert.showAndWait();

    }
    public static void errorMessageValueBig() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Ooops the value is very big");
        alert.showAndWait();

    }
    public static void errorMessageIDPat() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Ooops the ID doctor exist");
        alert.showAndWait();

    }
    public static void errorMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Ooops  Please enter Agian \n The dept_id not exisit");
        alert.showAndWait();

    }

    public static void errorMessagePI() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Ooops  Please enter Agian \n The patient id not exisit");
        alert.showAndWait();

    }
    public static void errorMessageDI() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Ooops  Please enter Agian \n The doctor id not exisit");
        alert.showAndWait();

    }

}
