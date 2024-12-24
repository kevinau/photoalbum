package au.geckosoftware.photoalbum;

public class Person implements ITerm {

  private final String name;
  
  public Person (String name) {
    this.name = name;
  }
  
  @Override
  public String getName() {
    return name;
  }
  
}
