package au.geckosoftware.photoalbum.search;

import java.util.List;

import au.geckosoftware.photoalbum.search.parser.SearchExpressionParser;

public class ExpressionTest {

  private SearchExpressionParser parser = new SearchExpressionParser();
  
  private String[] expressions = {
      "ashton",
      "ashton imogen",
      "ashton or imogen",
      "ashton and imogen",
      "ashton imogen chloe harlow",
      "ashton imogen chloe or harlow",
      "ashton imogen chloe and harlow",
      "andré",
      "harlow van de kirk",
  };
  
  
  public ExpressionTest () {
  }
  
  
  public void runTest () throws ExpressionException {
    NameList nameList = new NameList("ashton", "imogen", "chloe", "harlow", "andré", "van de kirk");
    
    for (String expr : expressions) {
      System.out.println("Search: " + expr);
      NamesExpression nameExpr = parser.parseExpression(expr);
      System.out.println(nameExpr);
      
      int[] next = new int[1];
      int index = nameExpr.getNameParts().size();
      
      String p = nameList.getTag(nameExpr.getNameParts(), index, next);
      while (p != null) {
        System.out.println("./............" + p);
        System.out.println("./............" + index + ".." + next[0]);
        index = next[0];
        p = nameList.getTag(nameExpr.getNameParts(), index, next);
      }
      System.out.println();
    }
  }
  
  
  public static void main (String[] args) throws Exception {
    ExpressionTest tester = new ExpressionTest();
    tester.runTest();
  }
  
}
