package saa;

import java.util.LinkedList;
import java.util.Collections;
import java.util.List;


public class Map {
    

    public static int[][][] generateMap(List<Integer> ones, List<Integer> n) {
        int var;
        if (n.isEmpty()) {
            var = mapType(ones);
        } else {
            var = mapType(ones, n);
        }
        int[][][] arr = {{{0}, {0}}, {{0}, {0}}};
        if (var == 1) {

            return mapType1(arr, ones, n);
        }
        if (var == 2) {

            return mapType2(arr, ones, n);
        }
        if (var == 3) {

            return mapType3(arr, ones, n);
        }
        if (var == 4) {

            return mapType4(arr, ones, n);
        }
        if (var == 5) {

            return mapType5(arr, ones, n);
        }
          if (var == 6) {

            return mapType6(arr, ones, n);
        }

        return arr;
    }
 
    
    
       public static int[][][] generateMap(List<Integer> ones, List<Integer> n, boolean bool) {
        int var;
        if (n.isEmpty()) {
            var = mapType(ones);
        } else {
            var = mapType(ones, n);
        }
        int[][][] arr = {{{0}, {0}}, {{0}, {0}}};
        if (var == 1) {

            return mapType1(arr, new LinkedList<Integer>(), new LinkedList<Integer>());
        }
        if (var == 2) {

            return mapType2(arr, new LinkedList<Integer>(), new LinkedList<Integer>());
        }
        if (var == 3) {

            return mapType3(arr, new LinkedList<Integer>(), new LinkedList<Integer>());
        }
        if (var == 4) {

            return mapType4(arr, new LinkedList<Integer>(), new LinkedList<Integer>());
        }
        if (var == 5) {

            return mapType5(arr, new LinkedList<Integer>(), new LinkedList<Integer>());
        }
          if (var == 6) {

            return mapType6(arr, new LinkedList<Integer>(), new LinkedList<Integer>());
        }

        return arr;
    }

    static int mapType(List<Integer> ones, List<Integer> n) {
        int variable = 0;

        if (Collections.max(ones) <= 1 && Collections.max(n) <= 1) {
            variable = 1;
        } else if (Collections.max(ones) <= 3 && Collections.max(n) <= 3) {
            variable = 2;
        } else if (Collections.max(ones) <= 7 && Collections.max(n) <= 7) {
            variable = 3;
        } else if (Collections.max(ones) <= 15 && Collections.max(n) <= 15) {
            variable = 4;
        } else if (Collections.max(ones) <= 31 && Collections.max(n) <= 31) {
            variable = 5;
        } else if (Collections.max(ones) <= 63 && Collections.max(n) <= 63) {
            variable = 6;
        }
        return variable;
    }

    static int mapType(List<Integer> ones) {
        int variable = 0;

        if (Collections.max(ones) <= 1) {
            variable = 1;
        } else if (Collections.max(ones) <= 3) {
            variable = 2;
        } else if (Collections.max(ones) <= 7) {
            variable = 3;
        } else if (Collections.max(ones) <= 15) {
            variable = 4;
        } else if (Collections.max(ones) <= 31) {
            variable = 5;
        } else if (Collections.max(ones) <= 63) {
            variable = 6;
        }
        return variable;
    }

    private static int[][][] mapType1(int[][][] arr, List<Integer> ones, List<Integer> n) {
        arr = new int[1][1][2];
        for (int o : ones) {
            switch (o) {
                case 0:
                    arr[0][0][1] = 1;
                    break;
                case 1:
                    arr[0][0][0] = 1;
                    break;
            }
        }
        for (int i : n) {
            switch (i) {
                case 0:
                    arr[0][0][1] = 2;
                    break;
                case 1:
                    arr[0][0][0] = 2;
                    break;
            }
        }
        return arr;
    }

    private static int[][][] mapType2(int[][][] arr, List<Integer> ones, List<Integer> n) {

        arr = new int[1][2][2];
        for (int o : ones) {
            switch (o) {
                case 3:
                    arr[0][0][0] = 1;
                    break;
                case 1:
                    arr[0][0][1] = 1;
                    break;
                case 2:
                    arr[0][1][0] = 1;
                    break;
                case 0:
                    arr[0][1][1] = 1;
                    break;
            }
        }
        for (int i : n) {
            switch (i) {
                case 3:
                    arr[0][0][0] = 2;
                    break;
                case 1:
                    arr[0][0][1] = 2;
                    break;
                case 2:
                    arr[0][1][0] = 2;
                    break;
                case 0:
                    arr[0][1][1] = 2;
                    break;
            }
        }
        return arr;
    }

    private static int[][][] mapType3(int[][][] arr, List<Integer> ones, List<Integer> n) {

        arr = new int[1][2][4];
        for (int o : ones) {
            switch (o) {
                case 6:
                    arr[0][0][0] = 1;
                    break;
                case 7:
                    arr[0][0][1] = 1;
                    break;
                case 3:
                    arr[0][0][2] = 1;
                    break;
                case 2:
                    arr[0][0][3] = 1;
                    break;
                case 4:
                    arr[0][1][0] = 1;
                    break;
                case 5:
                    arr[0][1][1] = 1;
                    break;
                case 1:
                    arr[0][1][2] = 1;
                    break;
                case 0:
                    arr[0][1][3] = 1;
                    break;
            }
        }
        for (int i : n) {
            switch (i) {
                case 6:
                    arr[0][0][0] = 2;
                    break;
                case 7:
                    arr[0][0][1] = 2;
                    break;
                case 3:
                    arr[0][0][2] = 2;
                    break;
                case 2:
                    arr[0][0][3] = 2;
                    break;
                case 4:
                    arr[0][1][0] = 2;
                    break;
                case 5:
                    arr[0][1][1] = 2;
                    break;
                case 1:
                    arr[0][1][2] = 2;
                    break;
                case 0:
                    arr[0][1][3] = 2;
                    break;
            }
        }
        return arr;
    }

    private static int[][][] mapType4(int[][][] arr, List<Integer> ones, List<Integer> n) {
        arr = new int[1][4][4];
        for (int o : ones) {
            switch (o) {
                case 12:
                    arr[0][0][0] = 1;
                    break;
                case 14:
                    arr[0][0][1] = 1;
                    break;
                case 6:
                    arr[0][0][2] = 1;
                    break;
                case 4:
                    arr[0][0][3] = 1;
                    break;
                case 13:
                    arr[0][1][0] = 1;
                    break;
                case 15:
                    arr[0][1][1] = 1;
                    break;
                case 7:
                    arr[0][1][2] = 1;
                    break;
                case 5:
                    arr[0][1][3] = 1;
                    break;
                case 9:
                    arr[0][2][0] = 1;
                    break;
                case 11:
                    arr[0][2][1] = 1;
                    break;
                case 3:
                    arr[0][2][2] = 1;
                    break;
                case 1:
                    arr[0][2][3] = 1;
                    break;
                case 8:
                    arr[0][3][0] = 1;
                    break;
                case 10:
                    arr[0][3][1] = 1;
                    break;
                case 2:
                    arr[0][3][2] = 1;
                    break;
                case 0:
                    arr[0][3][3] = 1;
                    break;
            }
        }
        for (int i : n) {
            switch (i) {
                case 12:
                    arr[0][0][0] = 2;
                    break;
                case 14:
                    arr[0][0][1] = 2;
                    break;
                case 6:
                    arr[0][0][2] = 2;
                    break;
                case 4:
                    arr[0][0][3] = 2;
                    break;
                case 13:
                    arr[0][1][0] = 2;
                    break;
                case 15:
                    arr[0][1][1] = 2;
                    break;
                case 7:
                    arr[0][1][2] = 2;
                    break;
                case 5:
                    arr[0][1][3] = 2;
                    break;
                case 9:
                    arr[0][2][0] = 2;
                    break;
                case 11:
                    arr[0][2][1] = 2;
                    break;
                case 3:
                    arr[0][2][2] = 2;
                    break;
                case 1:
                    arr[0][2][3] = 2;
                    break;
                case 8:
                    arr[0][3][0] = 2;
                    break;
                case 10:
                    arr[0][3][1] = 2;
                    break;
                case 2:
                    arr[0][3][2] = 2;
                    break;
                case 0:
                    arr[0][3][3] = 2;
                    break;
            }
        }
        return arr;
    }

    private static int[][][] mapType5(int[][][] arr, List<Integer> ones, List<Integer> n) {
        int f = 0;
                    arr = new int[2][4][4];

        for (int d = 0; d < 2; d++) {

            for (int o : ones) {
                switch (o - f) {
                    case 12:
                        arr[d][0][0] = 1;
                        break;
                    case 14:
                        arr[d][0][1] = 1;
                        break;
                    case 6:
                        arr[d][0][2] = 1;
                        break;
                    case 4:
                        arr[d][0][3] = 1;
                        break;
                    case 13:
                        arr[d][1][0] = 1;
                        break;
                    case 15:
                        arr[d][1][1] = 1;
                        break;
                    case 7:
                        arr[d][1][2] = 1;
                        break;
                    case 5:
                        arr[d][1][3] = 1;
                        break;
                    case 9:
                        arr[d][2][0] = 1;
                        break;
                    case 11:
                        arr[d][2][1] = 1;
                        break;
                    case 3:
                        arr[d][2][2] = 1;
                        break;
                    case 1:
                        arr[d][2][3] = 1;
                        break;
                    case 8:
                        arr[d][3][0] = 1;
                        break;
                    case 10:
                        arr[d][3][1] = 1;
                        break;
                    case 2:
                        arr[d][3][2] = 1;
                        break;
                    case 0:
                        arr[d][3][3] = 1;
                        break;
                }
            }
           f=16;
        }
        f=0;
        
         for (int a = 0; a < 2; a++) {

            for (int p : n) {
                switch (p - f) {
                    case 12:
                        arr[a][0][0] = 2;
                        break;
                    case 14:
                        arr[a][0][1] = 2;
                        break;
                    case 6:
                        arr[a][0][2] = 2;
                        break;
                    case 4:
                        arr[a][0][3] = 2;
                        break;
                    case 13:
                        arr[a][1][0] = 2;
                        break;
                    case 15:
                        arr[a][1][1] = 2;
                        break;
                    case 7:
                        arr[a][1][2] = 2;
                        break;
                    case 5:
                        arr[a][1][3] = 2;
                        break;
                    case 9:
                        arr[a][2][0] = 2;
                        break;
                    case 11:
                        arr[a][2][1] = 2;
                        break;
                    case 3:
                        arr[a][2][2] = 2;
                        break;
                    case 1:
                        arr[a][2][3] = 2;
                        break;
                    case 8:
                        arr[a][3][0] = 2;
                        break;
                    case 10:
                        arr[a][3][1] = 2;
                        break;
                    case 2:
                        arr[a][3][2] = 2;
                        break;
                    case 0:
                        arr[a][3][3] = 2;
                        break;
                }
            }
           f=16;
        }
        return arr;
    }
     private static int[][][] mapType6(int[][][] arr, List<Integer> ones, List<Integer> n) {
        int f = 0;
                    arr = new int[4][4][4];

        for (int d = 0; d < 4; d++) {

            for (int o : ones) {
                switch (o - f) {
                    case 12:
                        arr[d][0][0] = 1;
                        break;
                    case 14:
                        arr[d][0][1] = 1;
                        break;
                    case 6:
                        arr[d][0][2] = 1;
                        break;
                    case 4:
                        arr[d][0][3] = 1;
                        break;
                    case 13:
                        arr[d][1][0] = 1;
                        break;
                    case 15:
                        arr[d][1][1] = 1;
                        break;
                    case 7:
                        arr[d][1][2] = 1;
                        break;
                    case 5:
                        arr[d][1][3] = 1;
                        break;
                    case 9:
                        arr[d][2][0] = 1;
                        break;
                    case 11:
                        arr[d][2][1] = 1;
                        break;
                    case 3:
                        arr[d][2][2] = 1;
                        break;
                    case 1:
                        arr[d][2][3] = 1;
                        break;
                    case 8:
                        arr[d][3][0] = 1;
                        break;
                    case 10:
                        arr[d][3][1] = 1;
                        break;
                    case 2:
                        arr[d][3][2] = 1;
                        break;
                    case 0:
                        arr[d][3][3] = 1;
                        break;
                }
            }
           f=f+16;
        }
        f=0;
        
         for (int a = 0; a < 4; a++) {

            for (int p : n) {
                switch (p - f) {
                    case 12:
                        arr[a][0][0] = 2;
                        break;
                    case 14:
                        arr[a][0][1] = 2;
                        break;
                    case 6:
                        arr[a][0][2] = 2;
                        break;
                    case 4:
                        arr[a][0][3] = 2;
                        break;
                    case 13:
                        arr[a][1][0] = 2;
                        break;
                    case 15:
                        arr[a][1][1] = 2;
                        break;
                    case 7:
                        arr[a][1][2] = 2;
                        break;
                    case 5:
                        arr[a][1][3] = 2;
                        break;
                    case 9:
                        arr[a][2][0] = 2;
                        break;
                    case 11:
                        arr[a][2][1] = 2;
                        break;
                    case 3:
                        arr[a][2][2] = 2;
                        break;
                    case 1:
                        arr[a][2][3] = 2;
                        break;
                    case 8:
                        arr[a][3][0] = 2;
                        break;
                    case 10:
                        arr[a][3][1] = 2;
                        break;
                    case 2:
                        arr[a][3][2] = 2;
                        break;
                    case 0:
                        arr[a][3][3] = 2;
                        break;
                }
            }
           f=f+16;
        }
        return arr;
    }
     


}
