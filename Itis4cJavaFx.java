import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Itis4cJavaFX extends Application {	
  public void start(Stage stage) 
    throws Ricordami.OrarioGiaPassato, Ricordami.OrarioNonValido {
    Label message = new Label("ITIS 4C JavaFX App!");
    message.setFont( new Font(40) );
    Button helloButton = new Button("Benvenuto");
    helloButton.setOnAction( evt -> message.setText("Benvenuti a lezione!") );
    Button timeLeftButton = new Button("Quanto manca?");
    Ricordami acasa = new Ricordami(13, 49);
    timeLeftButton.setOnAction( evt -> {
      try {
        message.setText("Sono rimasti " + acasa.getMinutiRimasti() + " minuti.");
      } catch (Exception e) {
        throw new RuntimeException(e); 
      }
    });
    Button goodbyeButton = new Button("Arrivederci");
    goodbyeButton.setOnAction( evt -> message.setText("Alla prossima lezione!") );
    Button quitButton = new Button("Uscita");
    quitButton.setOnAction( evt -> Platform.exit() );
    HBox buttonBar = new HBox( 20, helloButton, timeLeftButton, goodbyeButton, quitButton );
    buttonBar.setAlignment(Pos.CENTER);
    BorderPane root = new BorderPane();
    root.setCenter(message);
    root.setBottom(buttonBar);
    Scene scene = new Scene(root, 650, 200);
    stage.setScene(scene);
    stage.setTitle("Utilizziamo JavaFX");
    stage.show();    
  } 
  public static void main(String[] args) {
    launch(); 
  }
}
