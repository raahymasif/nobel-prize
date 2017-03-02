package nobelprize;


import com.sun.deploy.util.StringUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.*;
import java.io.*;

/**
 *
 * @author Chris Mattinson <mattinsonc@mymacewan.ca>
 *          Raahym Asif <asifr@mymacewan.ca>
 */
public class Nobelprize extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Nobel Prize");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        launch(args);
        URL nobelprize = new URL("http://api.nobelprize.org/v1/prize.json");
        URLConnection nobelconnection = nobelprize.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(nobelconnection.getInputStream()));
    
        String inputlines;
        int numyears;
        while ((inputlines = in.readLine()) != null){
            System.out.println(inputlines);
        }
        in.close();
    }
    
}
