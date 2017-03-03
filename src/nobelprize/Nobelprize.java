package nobelprize;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import org.json.*;

/**
 * @author Chris Mattinson <mattinsonc@mymacewan.ca>
 * @author Raahym Asif <asifr@mymacewan.ca>
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
    public static void main(String[] args) throws MalformedURLException, IOException, JSONException {
        launch(args);
        URL nobelprize = new URL("http://api.nobelprize.org/v1/prize.json");
        URLConnection nobelconnection = nobelprize.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(nobelconnection.getInputStream()));
    
        String inputlines;
        int numyears;
              
        
        
        while ((inputlines = in.readLine()) != null){
            JSONObject myjson = new JSONObject(inputlines);
            JSONArray the_json_array = myjson.getJSONArray("prizes");
            int size = the_json_array.length();
            ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
                for (int i = 0; i < size; i++){
                    JSONObject another_json_object = the_json_array.getJSONObject(i);
                    
                    arrays.add(another_json_object);
                }
            JSONObject[] jsons = new JSONObject[arrays.size()];
            arrays.toArray(jsons);
            
        }
        System.out.println(another_json_object); // see its giving an error here cuz idk how to print he map
        //System.out.println(inputlines);
        in.close();
    }
    
}
