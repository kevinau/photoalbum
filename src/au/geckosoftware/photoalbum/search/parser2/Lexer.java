package au.geckosoftware.photoalbum.search.parser2;

import java.io.*;

class Lexer {
  private static final int KEYWORDS = 11;
  
  private final char[] ex;
  private int index;
  
  private String name;

  // Constructor that creates a lexical analyzer object given string

  public Lexer(String expr) {
    this.ex = expr.toCharArray();
    this.index = 0;
  }

  // Returns the next token in the input stream

  public Token getNextToken() throws IOException {
    if (index >= ex.length) {
      return Token.EOF;
    }
    
    if (ex[index] == ' ') {
      index++;
    }
    if (Character.isLetter(ex[index])) {
      name = getName();
      if (name.equals("and")) {
        return null;
      }
      return Token.NAME;
    } else {
      switch (ex[index]) {
      case '(' :
        index++;
        return Token.LEFT_PAREN;
      case ')' :
        index++;
        return Token.RIGHT_PAREN;
      case ':' :
        index++;
        return Token.COLON;
      default :
        throw new RuntimeException("Invaid charater at " + (index + 1));
      }
    }
  }
  
  private String parseName () {
    StringBuilder builder = new StringBuilder();
    
    int i = index;
    builder.append(ex[i++]);

    while (i < ex.length && (Character.isLetterOrDigit(ex[i]) || ex[i] == ' ' || ex[i] == '\'' || ex[i] == '-')) {
      builder.append(ex[i++]);
    }
    index = i;
    
    return builder.toString();
  }
  // Returns the lexeme associated with the current token


  public String getName() {
    return name;
  }

}
