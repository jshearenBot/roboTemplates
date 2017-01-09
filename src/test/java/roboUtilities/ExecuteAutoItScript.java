package test.java.roboUtilities;

import java.io.IOException;

public class ExecuteAutoItScript {
    public void scriptFileName(String filename){
        try {
            Runtime.getRuntime().exec("autoItScripts\\"+filename);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Running AutoitScript: "+filename);
        }
    }
}
