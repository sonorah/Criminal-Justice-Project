/**
 *. Class to represent the characteristics of
 *. one defendant from a dataset
 *
 *  @author Sonora Halili and Frankie Fan
 *. @version Spring 2022
 */


public class Defendant implements ProPublica {
  // Builds a constructor Defendant, with all the fields listed below

  /** Sex of defendant */
  private String sex;

  /** Race of defendant */
  private String race;

  /** Charge degree*/
  private char charge_degree;

  /**Description of Charge*/
  private String charge_desc;

  /** Decile Score*/
  private int decile_score; 

  /** Score text (low/medium/high)*/
  private String score_text;

  /** Did the defendant commit a crime within the next 2 yrs */
  private boolean two_year_recid;

  /** Description of new charge*/
  private String r_charge_desc;
  
  /** Degree od new Charge*/
  private String r_charge_degree;
  
 

  public Defendant (String Sex, String Race, char ChargeDegree, String ChargeDesc, int DecileScore, String ScoreText, boolean TwoYearRecid, String RChargeDesc, String RChargeDegree) {
    /** Creates a defendant with specified sex, race, charge_degree, charge_desc, decile_score, score_text, two_year_recid, r_charge_desc, r_charge_degree */
    sex = Sex;
    race = Race;
    charge_degree = ChargeDegree;
    charge_desc = ChargeDesc;
    decile_score = DecileScore;
    score_text = ScoreText;
    two_year_recid = TwoYearRecid;
    r_charge_desc = RChargeDesc;
    r_charge_degree = RChargeDegree;
  }
  
  /** Accessor for sex */
  public String getSex() {
    return sex;
  }
  /** Setter for sex*/
  public  void setSex(String sex) {
    this.sex = sex;
  }

  /** Accessor for race */
  public String getRace() {
    return race;
  }
  /**Setter for race*/
  public void setRace(String race) {
    this.race = race;
  }

  /** Accessor for charge_degree */
  public char getChargeDegree() {
    return charge_degree;
  }
  /** Setter for charge_degree*/ 
  public void setChargeDegree(char charge_degree) {
    this.charge_degree = charge_degree;
  }

  
  /** Accessor for charge_desc */
  public String getChargeDesc() {
    return charge_desc;
  }
  /** Setter for charge_desc */
  public void setChargeDesc(String charge_desc) {
    this.charge_desc = charge_desc;
  }

  /** Accessor for decile_score */
  public int getDecileScore() {
    return decile_score;
  }
  /**  Setter for decile_score*/
  public void setDecileScore(int decile_score) {
    this.decile_score = decile_score;
  }
  
 /** Accessor for score_text */
  public String getScoreText() {
    return score_text;
  }
  /** Setter for score_text */
  public void setScoreText(String score_text) {
    this.score_text= score_text;
  }


  /** Accessor for two_year_recid */
  public boolean getTwoYearRecid() {
    return this.two_year_recid;
  }
  public void setTwoYearRecid(boolean two_year_recid) {
  this.two_year_recid = two_year_recid;
  }


  /** Accessor for r_charge_desc */
  public String getRChargeDesc() {
    return r_charge_desc;
  }
  /** Setter for score_text */
  public void setRChargeDesc(String r_charge_desc) {
    this.r_charge_desc = r_charge_desc;
  }  

  /** Accessor for r_charge_degree */
  public String getRChargeDegree() {
    return r_charge_degree;
  }
  /** Setter for score_text */
  public void setRChargeDegree(String r_charge_degree) {
    this.r_charge_degree = r_charge_degree;
  } 

  
  


  /** toString Metod that returns String representation of Defendant Object*/
  public String toString () {
    return ("> For " + getSex() + " ,race " +  getRace() + " defendant charged with degree " + getChargeDegree() + " " + getChargeDesc() + " of risk level " + getDecileScore() + "(" + getScoreText() + "), the case of a re-offense is " + getTwoYearRecid() + ", of degree " + getRChargeDegree()) + ", under the charge of: " + getRChargeDesc() + ".";
  }

  


  
  // Builds a constructor for taking a row from the dataset as a string, and slice the string into an array, with each element being assigned with corresponding field
  public Defendant (String row) {
    // sex,race,c_charge_degree,c_charge_desc,decile_score,score_text,two_year_recid,r_charge_desc,r_charge_degree
    String[] Row = row.split(",");
    
    this.sex = Row[0];
    this.race = Row[1];
    String s1 = Row[2];
    this.charge_degree = s1.charAt(0);//converts a string to character by taking the first character of the string; as the string is actually a single letter, the first character is all of its information
    this.charge_desc = Row[3];
    this.decile_score = Integer.parseInt(Row[4]);
    this.score_text = Row[5];
    this.two_year_recid = Boolean.parseBoolean(Row[6]);

    if (Boolean.parseBoolean(Row[6]) == true) {
    this.r_charge_desc = Row[7];
    String s2 = Row[8];
    char d = s2.charAt(0); //converts a string to character by taking the first character of the string; as the string is actually a single letter, the first character is all of its information
    this.charge_degree = d;
    }
  }
  

  public boolean isWhite() {
    // a utility method that identify whether the defendant is white or not
    if (this.race.equals("Caucasian")) {
      return true;
    } else { return false;
    }
  }
  

  public boolean isBlack() {
    // a utility method that identify whether the defendant is white or not
    if (this.race.equals("African-American")) { 
      return (true);
    } else { return false;
    }
  }

  public boolean hasReoffended() {
    // a utility method that identify whether the defendant has reoffended in two years or not
    if (this.two_year_recid) {
      return (true);
    } else { return false;
    }
  }
  
  
  public boolean isLowRisk() {
    // a utility method that identify whether the defendant has a low risk level or not
    if (this.score_text.equals("Low")) {
      return (true);
    } else { return false;
    }
  }

}



