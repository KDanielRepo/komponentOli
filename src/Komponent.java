import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Komponent extends Application {

    Button and;
    Button or;
    Button duze;
    Button male;
    Button reset;
    Button kolor_tla;
    Button drkmod;
    Button info;
    TextArea a;
    TextArea b;
    TextArea wynik;
    Label p1;
    Label wynto;
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
                    if ("1".equals(l1.substring(i,i+1)) && "1".equals(l2.substring(i,i+1))) {   //obliczenie anda
                        wynBin=wynBin+"1";
                    } else {
                        wynBin=wynBin+"0";
                    }
                } else {
                    if (l1.substring(i,i+1).equals("1") || l2.substring(i,i+1).equals("1")) {    //obliczenie or
                        wynBin=wynBin+"1";
                    } else {
                        wynBin=wynBin+"0";
                    }
                }
            }

        } else {
            wynBin = ("Źle podane liczby! \n(powinny się mieścić \nw przedziale 1-4 bity)");    //powiadomienie o wpisaniu błędnych liczb
        }
        return wynBin;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane wyglad = new BorderPane();
                                                                                                //rozmiary Buttonów,Labelek i TextArea
        duze = new Button("A");
        duze.setPrefSize(20, 20);
        male = new Button("a");
        male.setPrefSize(20, 20);
        reset = new Button("Reset");
        reset.setPrefSize(50, 20);
        kolor_tla = new Button("Kolor tła");
        kolor_tla.setPrefSize(65, 20);
        drkmod = new Button("Tryb ciemny");
        drkmod.setPrefSize(85,20);
        info = new Button("Pomoc");
        info.setPrefSize(60,20);

        p1 = new Label("Podaj liczbe A:");
        p1.setPrefSize(100, 50);
        a = new TextArea("1001");
        a.setPrefSize(100, 50);
        p2 = new Label("Podaj liczbe B:");
        p2.setPrefSize(100, 50);
        b = new TextArea("1010");
        b.setPrefSize(100, 50);
        and = new Button("AND");
        and.setPrefSize(100, 90);
        wynto = new Label("Wynik to:");
        wynto.setPrefSize(100, 30);
        wynik = new TextArea(wynBin);
        wynik.setPrefSize(130, 160);
                                                                                                //wybór funkcji AND lub OR w zależności od klikniętego buttona
        and.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                wybor=true;
                wynBin="";
                wynik.setText(oblicz());
            }
        });
        or = new Button("OR");
        or.setPrefSize(100, 90);
        or.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                wybor = false;
                wynBin="";
                wynik.setText(oblicz());
            }
        });
                                                                                            //pozycjonowanie wszystkiego oraz dodawanie wyglądu do apk
        HBox hbo1 = new HBox(duze,male,reset,kolor_tla,drkmod,info);

        VBox vbo1 = new VBox();
        vbo1.getChildren().addAll(p1,a,p2,b);
        VBox vbo2 = new VBox();
        vbo2.getChildren().addAll(and,or);
        VBox vbo3 = new VBox();
        vbo3.getChildren().addAll(wynto,wynik);
        wynik.setEditable(false);

        wyglad.setLeft(vbo1);
        vbo1.setPadding(new Insets(80,0,0,130));
        wyglad.setCenter(vbo2);
        vbo2.setPadding(new Insets(100,0,0,20));
        wyglad.setRight(vbo3);
        vbo3.setPadding(new Insets(90,100,0,20));
        wyglad.setPrefSize(600, 400);
        wyglad.setTop(hbo1);
        hbo1.setPadding(new Insets(0,0,0,0));


                                                                                         //tryb ciemny
        drkmod.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                wyglad.setStyle("-fx-background-color: #3d3d3d;");
                a.setStyle("-fx-control-inner-background: #4c4c4c;");
                b.setStyle("-fx-control-inner-background: #4c4c4c;");
                wynik.setStyle("-fx-control-inner-background: #4c4c4c;");
                and.setStyle("-fx-background-color: #4c4c4c;");
                and.setTextFill(Color.WHITE);
                or.setStyle("-fx-background-color: #4c4c4c;");
                or.setTextFill(Color.WHITE);
                p1.setTextFill(Color.WHITE);
                p2.setTextFill(Color.WHITE);
                wynto.setTextFill(Color.WHITE);
                }
        });


        Scene scena = new Scene(wyglad);
        primaryStage.setScene(scena);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(Komponent.class, args);
    }
}
//900x500

