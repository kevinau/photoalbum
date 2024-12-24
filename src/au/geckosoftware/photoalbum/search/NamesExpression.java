package au.geckosoftware.photoalbum.search;

import java.util.ArrayList;
import java.util.List;

public class NamesExpression {

  public enum Conjunction { OR, AND };
  
  private final List<String> nameParts = new ArrayList<>();
  private final List<String> finalName = new ArrayList<>();
  private Conjunction conjunction = Conjunction.OR;
  
  
  public void addNamePart(String value) {
    nameParts.add(value);
  }
  
  
  public void addFinalName(String value) {
    finalName.add(value);
  }
  
  
  public List<String> getNameParts() {
    return nameParts;
  }
  
  
  public List<String> getFinalName() {
    return finalName;
  }
  
  
  public void setConjunction(Conjunction conjunction) {
    this.conjunction = conjunction;
  }


  public Conjunction getConjunction() {
    return conjunction;
  }
  
  
  @Override
  public String toString() {
    return "NameList [" + conjunction + ", " + nameParts + ", " + finalName + "]";
  }

}
