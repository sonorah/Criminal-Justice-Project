/**
 *. An interface with four utility methods to be 
 *. implemented in DefendantGroup class.
 */
 
interface ProPublica {

  public boolean isWhite(); 
  //should return true if defedant is white

  public boolean isBlack();
  //should return true if defedant is black

  public boolean hasReoffended();
  //should return true if defedant has re-offended


  public boolean isLowRisk();
  //should return true if defedant was labeled as low risk after the initial offense
  
}