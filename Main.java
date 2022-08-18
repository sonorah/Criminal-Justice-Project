import java.util.Scanner; 
import java.io.*;


public class Main {
  /* Main contains the main method. It calls all the test codes for contructors, setters, file reader, booleans, and also the proPublic() method on a defendant group we built. */
  
  public static void main(String[] args) {
     testConstructor();//calls the constructor test
     testSetters(); //calls the setter test
     testStringConstructor();//calls the string constructor test
     testBooleans(); //calls the booleans test (which are inherented from the interface ProPublica, and then changed to utility functions that return boolean values)
     testFileReader();//calls the file reader test
     DefendantGroup dg = new DefendantGroup("compas-scores.csv"); //builds a new DefendantGroup dg that reads in the row of the csv file
     dg.proPublica(); //applies the method proPublica on dg
  }

  
  
  public static void testConstructor() {
    /* test the constructor Defendant*/
    Defendant TestName = new Defendant ("Male","Hispanic",'F',"Lewd/Lasc Battery Pers 12+/<16",4,"Low",true, "Possess Cannabis/20 Grams Or Less","(M1)"); 
    //set up a new defendant for test
    System.out.println(TestName);
    /* test the getter method for the sex field: .equals will return no output if the strings are equal otherwise, it will throw an Exception
    */
    TestCode.beginTest("Contructor");
    TestCode.subTest("Constructor Race",TestName.getRace().equals("Hispanic"));
    TestCode.concludeTest();
        
  }


  public static void testSetters() {
    /* test the setter method for all the fields: *.equals will return no output if the strings are equal otherwise, it will throw an Exception
    */

    //setting the value of each field of a defendant for test
    String sex = "Female";
    String race = "Hispanic";
    char charge_degree = 'F';
    String charge_desc = "Lewd/Lasc Battery Pers 12+/<16";
    int decile_score = 4;
    String score_text = "Low";
    boolean two_year_recid = true ;
    String r_charge_desc = "Possess Cannabis/20 Grams Or Less";
    String r_charge_degree = "(M1)";

    //set up a new defendant TestName for test, notice that the sex of the defendant is different from the one above, so we are essentially overwriting the information
    Defendant TestName = new Defendant ("Male","Hispanic",'F',"Lewd/Lasc Battery Pers 12+/<16",4,"Low",true, "Possess Cannabis/20 Grams Or Less","(M1)");
    TestName.setSex(sex);
    //set the value of sex of TestName to the sex from the information above their original value
    TestName.setRace(race);
    //set the value of race of TestName to the race from the information above their original value
    TestName.setChargeDegree(charge_degree);
    //set the value of charge_degree of TestName to the charge_degree from the information above their original value
    TestName.setChargeDesc(charge_desc);
    //set the value of charge_desc of TestName to the charge_desc from the information above their original value
    TestName.setDecileScore(decile_score);
    //set the value of decile_score of TestName to the decile_score from the information above their original value
    TestName.setScoreText(score_text);
    //set the value of score_text of TestName to the score_text from the information above their original value
    TestName.setTwoYearRecid(two_year_recid);
    //set the value of two_year_recid of TestName to the two_year_recid from the information above their original value
    TestName.setRChargeDesc(r_charge_desc);//set the value of r_charge_desc of TestName to the r_charge_desc from the information above their original value
    TestName.setRChargeDegree(r_charge_degree);//set the value of r_charge_degree of TestName to the r_charge_degree from the information above their original value

    /** test to see if the setter methods have successfully overwrite the information of TestName with the values that were provided above; if the fields are all euqal, then it shows the getters are functioning */
    TestCode.beginTest("Setters");
    TestCode.subTest("Setter Sex",TestName.getSex().equals(sex)); 
    TestCode.subTest("Setter Race",TestName.getRace().equals(race));
    TestCode.subTest("Setter Charge Degree",TestName.getChargeDegree()== (charge_degree));
    TestCode.subTest("Setter Charge Description",TestName.getChargeDesc().equals(charge_desc));
    TestCode.subTest("Setter Decile Score",TestName.getDecileScore() == (decile_score));
    TestCode.subTest("Setter Score Text",TestName.getScoreText().equals(score_text));
    TestCode.subTest("Setter TwoYearRecid",TestName.getTwoYearRecid() == (two_year_recid));
    TestCode.subTest("Setter RChargeDesc",TestName.getRChargeDesc().equals(r_charge_desc));
    TestCode.subTest("Setter RChargeDegree",TestName.getRChargeDegree().equals(r_charge_degree));
    
    TestCode.concludeTest();
  }




  public static void testFileReader() { 
    /* Test the file reader method that reads in the lines from file "compas-scores.csv" */
    Scanner file = null;
    try {
      file = new Scanner(new File("compas-scores.csv"));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);

    } while (file.hasNextLine()) {
      String line = file.nextLine();
      Defendant F = new Defendant (line);
      System.out.println(F);
    }
    file.close();
  }
  
  public static void testBooleans() {
    /** Test the isWhite(), isBlack(), hasReoffended(), isLowRisk(), and isHighRisk() methods
    */
   
    //set up a new Defendant, TestName, for test
    Defendant TestName = new Defendant ("Male","Caucasian",'F',"Insurance Fraud",3,"Low",true,"Battery","(M1)");
    
    //with the information above, we made the judgements below according to the boolean value each utility function returns. If the functions are working, they should be coherent with our judegemnts(predictions). 
    TestCode.beginTest("Bools");
    TestCode.subTest("IsWhite",TestName.isWhite() == true);
    TestCode.subTest("IsBlack",TestName.isBlack() == false);
    TestCode.subTest("HasReoffended()",TestName.hasReoffended() == true);
    TestCode.subTest("isLowRisk",TestName.isLowRisk() == true);
    TestCode.concludeTest();
  }

  public static void testStringConstructor() {
    /** Test the getter methods for the StringConstructor
    */

    //set up a new Defendant, d, for test, with extraccting all of their information from a string
    String row1 =  new String ("Male,Other,F,Aggravated Assault w/Firearm,1,Low, false");
    Defendant d = new Defendant(row1);
    TestCode.beginTest("StringContructor");
    //if the getter methods work for the constructor, it should return the exact same information for each field as set above
    TestCode.subTest("Constructor Sex",d.getSex().equals("Male"));
    TestCode.subTest("Constructor Race",d.getRace().equals("Other"));
    TestCode.concludeTest();
    //System.out.println(d);
  }

}