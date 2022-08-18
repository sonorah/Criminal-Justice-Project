/**
 *. Class to represent the characteristics of
 *. a defendant group read from a dataset
 *
 *  @author Sonora Halili and Frankie Fan
 *. @version Spring 2022
 */

import java.io.File;  // the File class
import java.util.*;
import java.io.FileNotFoundException;  // to handle file-related errors


public class DefendantGroup {
  /** Creates a DefendantGroup object (input file) where each line is read into an object of type Defendant and added in an ArrayList called Defendants. */

  public static ArrayList <Defendant> Defendants = new ArrayList <Defendant>();

  public  DefendantGroup(String filename) {
    //Reads in the file and converts each line into Defendant. Code provided in assignment.
    
    Scanner file = null;
    try {
      file = new Scanner(new File("compas-scores.csv"));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    }

    while (file.hasNextLine()) {
      String line = file.nextLine();
      Defendant d = new Defendant (line);
      Defendants.add(d);
    }
    
    file.close();
  }

  public void addDefendant(Defendant d) {
    // Method that adds defendant d to the ArrayList Defendants
    Defendants.add(d);
  }

  public static  Defendant getDefendant(int i) { 
    // Method that gets defendant indexed i from the ArrayList Defendants
    return Defendants.get(i);
  }

  public void removeDefendant(int i) {
    // Method that removes defendant indexed i from the ArrayList Defendants
    Defendants.remove(i);
  }



  public static void  proPublica() {
    /** Method that replicates the table provided in the propublica article; code provided in assignment */
    // variables to count particular categories
    // note that medium and high risk are counted here as high
    int wly = 0; // White, low risk, has reoffended
    int wln = 0; // White, low risk, has not reoffended
    int bly = 0; // Black, low risk, has reoffended
    int bln = 0; // Black, low risk, has not reoffended
    int why = 0; // White, high risk, has reoffended
    int whn = 0; // White, high risk, has not reoffended
    int bhy = 0; // Black, high risk, has reoffended
    int bhn = 0; // Black, high risk, has not reoffended

    // loop to count sums
    for (int i = 0; i < Defendants.size(); i++) {
      Defendant d = getDefendant(i);
      

      if (d.isWhite()&&d.isLowRisk()&&d.hasReoffended()) {
        wly++;
      } else if (d.isWhite()&&d.isLowRisk()&&!d.hasReoffended()) {
        wln++;
      } else if (d.isBlack()&&d.isLowRisk()&&d.hasReoffended()) {
        bly++;
      } else if (d.isBlack()&&d.isLowRisk()&&!d.hasReoffended()) {
        bln++;
      } else if (d.isWhite()&&!d.isLowRisk()&&d.hasReoffended()) {
        why++;
      } else if (d.isWhite()&&!d.isLowRisk()&&!d.hasReoffended()) {
        whn++;
      } else if (d.isBlack()&&!d.isLowRisk()&&d.hasReoffended()) {
        bhy++;
      } else if (d.isBlack()&&!d.isLowRisk()&&!d.hasReoffended()) {
        bhn++;
      }
    
    }

    // print the results
    System.out.println("White, high risk, didn't reoffend: "+whn*100.0/(whn+wln)+" %");
    System.out.println("Black, high risk, didn't reoffend: "+bhn*100.0/(bhn+bln)+" %");
    System.out.println("White, low risk, did reoffend: "+wly*100.0/(wly+why)+" %");
    System.out.println("Black, low risk, did reoffend: "+bly*100.0/(bly+bhy)+" %");
  }
}

