package saa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Equation {

    List<Form> forms;
    private int[][][] map;
    int mapType;
    Decoder d;


    public Equation(List<Form> forms, int[][][] map, int mapType) {
        this.forms = forms;
        this.map = map;
        this.mapType = mapType;
        d = new Decoder(mapType);

    }

    public Equation(int[][][] map, int mapType) {
        this.forms = new LinkedList<>();
        this.map = map;
        this.mapType = mapType;
        d = new Decoder(mapType);

    }
    

    private int[][][] updateMap(Form f, int[][][] map) {
        for (Coordinates c : f.getCoordinates()) {
            map[c.getA()][c.getB()][c.getC()] = 2;
        }
        return map;
    }

    private void addForm(Form f, int[][][] map) {
        this.forms.add(f);
        this.map = map;
    }

    public void updateEquation(Form f, int[][][] map, List<Integer> ones, List<Integer> n) {
        int[][][] map1 = Map.generateMap(ones, n, true);
        int a = 0;
        int b;
        int c;
        for (int x[][] : map) {
            b = 0;
            for (int[] y : x) {
                c = 0;
                for (int z : y) {
                    if (z == 1 || z == 2) {
                        map1[a][b][c] = map[a][b][c];
                    }
                    c++;
                }
                b++;
            }
            a++;
        }

        addForm(f, updateMap(f, map1));
    }

    public boolean isComplete() {
        for (int[][] arr2 : map) {
            for (int[] arr3 : arr2) {
                for (int arr4 : arr3) {
                    if (arr4 == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        for (Form f : forms) {
            s = s.concat(" + " + d.decode(f));
        }

        return s.substring(3);
    }
    public List<String> getFormsAsSortedList(){
        List<String> s = new ArrayList<String>();
           for (Form f : forms) {
            s.add(d.decode(f));
            Collections.sort(s);
        }
           return s;
    }
    public String getSortedEquation(){
        String s = "";
        for (String f : getFormsAsSortedList()) {
            s = s.concat(" + " + f);
        }

        return s.substring(3);
    } 

    public int[][][] getMap() {
        
        return map;
    }

    public void printMap() {
        for (int[][] arr2 : map) {
            for (int[] arr3 : arr2) {
                for (int arr4 : arr3) {
                    System.out.print(arr4);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }

    public List<Form> getForms() {

        if (forms.isEmpty()) {
            return new LinkedList<Form>();
        }
        return forms;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.forms);
        hash = 79 * hash + Arrays.deepHashCode(this.map);
        hash = 79 * hash + this.mapType;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equation other = (Equation) obj;
        if (this.mapType != other.mapType) {
            return false;
        }
        boolean flag = false;
        for (Form f1 : this.forms) {
            flag = false;
            for (Form f2 : other.forms) {
                if (f1.equals(f2)) {
                    flag = true;
                }
            }
            if (flag == false) {
                return flag;
            }
        }

        return true;
    }
    public int howBig(){
        int sum = 0;
        for(Form f : forms){
            sum += f.howBig();
        }
        return sum;
    }

}
