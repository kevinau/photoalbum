package au.geckosoftware.photoalbum.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameList {

  private String[] tags;
  
  public NameList (String... tags) {
    this.tags = tags;
    Arrays.sort(tags);
    System.out.println(Arrays.asList(tags));
  }
  
  
  public String getTag (int i) {
    return tags[i];
  }
  
  
  public List<String> getTags (List<String> parts, String finalName) {
    int[] next = new int[1];
    int index = parts.size();
    
    List<String> found = new ArrayList<>();
    
    String p = getTag(parts, index, next);
    while (p != null) {
      found.add(0, p);
      
      index = next[0];
      p = getTag(parts, index, next);
    }
    
    if (finalName != null) {
      p = getTag(finalName);
      found.add(p);
    }
    return found;
  }

  
  private String getTag (List<String> parts, int index, int[] next) {
    if (index <= 0) {
      // No more names to find
      return null;
    }
    if (parts.size() == 1) {
      int p = Arrays.binarySearch(tags, parts.get(0));
      if (p >= 0) {
        next[0] = 0;
        return tags[p];
      }
      // Found name is not in the list
      throw new IllegalArgumentException("'" + parts.get(0) + "' is not a known name");
    } else {
      StringBuilder builder = new StringBuilder();
      int n = parts.size();
      int[] lengths = new int[n];
      
      int i = 0;
      for (String s : parts) {
        if (!builder.isEmpty()) {
          builder.append(' ');
        }
        lengths[i++] = builder.length();
        builder.append(s);
        if (i >= index) {
          break;
        }
      }
      
      next[0] = index;
      String tag = builder.toString();
      while (next[0] > 0) {
        next[0]--;
        int p = Arrays.binarySearch(tags, tag.substring(lengths[next[0]]));
        if (p >= 0) {
          return tags[p];
        }
      }
      // Found name is not in the list
      throw new IllegalArgumentException("'" + tag.substring(lengths[n - 1]) + "' is not a known name");
    }
  }
  
  
  private String getTag (String finalName) {
    int p = Arrays.binarySearch(tags, finalName);
    if (p >= 0) {
      return tags[p];
    }
    // Name is not in the list
    throw new IllegalArgumentException("'" + finalName + "' is not a known name");
  }
  
}
