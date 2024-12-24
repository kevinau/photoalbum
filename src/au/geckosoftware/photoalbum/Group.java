package au.geckosoftware.photoalbum;

import java.util.ArrayList;
import java.util.List;

public class Group implements ITerm {

  private final String name;
  
  private final List<ITerm> terms = new ArrayList<>();

  public Group (String name) {
    this.name = name;
  }
  
  @Override
  public String getName() {
    return name;
  }
  
}
