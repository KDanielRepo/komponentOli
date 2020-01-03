import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Komponent extends Application {

    Button and;
    Button or;
    TextArea a;
    TextArea b;
    TextArea wynik;
    Label p1;
    Label p2;
    String l1;
    String l2;
    String wynBin="";
    Boolean wybor;


    public String oblicz() {
        l1=a.getText();
        l2=b.getText();
        if (l1.length() < 5 && l2.length() < 5) {
            for (int i = 0; i < l1.length(); i++) {
                if (wybor) {
                    System.out.println(l1.substring(i,i+1));//and
                    System.out.println(l2.substring(i,i+1));
                    if ("1".equals(l1.substring(i,i+1)) && "1".equals(l2.substring(i,i+1))) {
                        wynBin=wynBin+"1";
                        //obliczenie anda
                    } else {
                        wynBin=wynBin+"0";
                        // co jesli zle
                    }
                } else {                                                                                                 //or
                    if (l1.substring(i,i+1).equals("1") || l2.substring(i,i+1).equals("1")) {
                        wynBin=wynBin+"1";
                        //obliczenie or
                    } else {
                        wynBin=wynBin+"0";
                        // co jesli zle
                    }
                }
            }

        } else {
            System.out.println("Za duże liczby!");
        }
        return wynBin;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane wyglad = new BorderPane();
        VBox box1 = new VBox();
        VBox box2 = new VBox();
        VBox box3 = new VBox();

        p1 = new Label("Podaj liczbe A");
        p1.setPrefSize(100, 50);
        a = new TextArea("1001");
        a.setPrefSize(100, 50);
        p2 = new Label("Podaj liczbe B");
        p2.setPrefSize(100, 50);
        b = new TextArea("1010");
        b.setPrefSize(100, 50);

        and = new Button("AND");
        and.setPrefSize(100, 100);
        and.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                wybor=true;
                wynBin="";
                wynik.setText(oblicz());
            }
        });
        or = new Button("OR");
        or.setPrefSize(100, 100);
        or.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                wybor = false;
                wynBin="";
                wynik.setText(oblicz());
            }
        });

        wynik = new TextArea("Wynik to: " +wynBin);
        wynik.setPrefSize(100, 200);


        box1.getChildren().add(p1);
        box1.getChildren().add(a);
        box1.getChildren().add(p2);
        box1.getChildren().add(b);

        box2.getChildren().add(and);
        box2.getChildren().add(or);

        box3.getChildren().add(wynik);
        wynik.setEditable(false);

        wyglad.setLeft(box1);
        wyglad.setCenter(box2);
        wyglad.setRight(box3);
        wyglad.setPrefSize(600, 400);
        Scene scena = new Scene(wyglad);
        primaryStage.setScene(scena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(Komponent.class, args);
    }
}
//900x500