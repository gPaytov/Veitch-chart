
package saa;

import java.util.List;

public interface Form {

   List<Form> returnAll(Coordinates co, int[][][] map);
   List<Coordinates> getCoordinates();
   int howBig();
   
}