package saa;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Decoder {

    private int mapType;

    public Decoder(int mapType) {
        this.mapType = mapType;
    }
//capital letters for normal non-inverse, small letters for inverse

    public String decode(Form f) {
        if (mapType == 1 && f.howBig() == 2) {
            return new String("1");
        }
        String[][][] code = code();
        List<char[]> ones = new LinkedList<>();
        List<Character> toRemove = new LinkedList<>();
        List<Character> finish = new LinkedList<>();
        String finished = new String();
        for (Coordinates c : f.getCoordinates()) {
            ones.add(code[c.getA()][c.getB()][c.getC()].toCharArray());
        }
        if (ones.size() == 1 && f.howBig() == 1 && mapType == 1) {
            return decode2(ones.get(0)[0]);
        }
        char[] base = ones.get(0);
        for (char[] chars : ones) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != base[i]) {
                    toRemove.add(base[i]);
                }
            }

        }
        if (!toRemove.isEmpty()) {
            toRemove = toRemove.stream().distinct().collect(Collectors.toList());
            for (char c : base) {
                if (!toRemove.contains(c)) {
                    finished = finished + decode2(c);

                }

            }
        }
        if (finished.isEmpty() && f.howBig() > 1) {
            return new String("1");
        }
        //if the one doesn't stick to anything around it this returns its full coordinates
        if (finished.isEmpty()) {
            for (char c : base) {              
                    finished = finished + decode2(c);
            }
        }
        return finished;

    }

    public String decode2(char c) {
        if (c == 'a') {
            return "x1'";
        }
        if (c == 'b') {
            return "x2'";
        }
        if (c == 'c') {
            return "x3'";
        }
        if (c == 'd') {
            return "x4'";
        }
        if (c == 'e') {
            return "x5'";
        }
        if (c == 'f') {
            return "x6'";
        }
        if (c == 'A') {
            return "x1";
        }
        if (c == 'B') {
            return "x2";
        }
        if (c == 'C') {
            return "x3";
        }
        if (c == 'D') {
            return "x4";
        }
        if (c == 'E') {
            return "x5";
        }
        if (c == 'F') {
            return "x6";
        }
        return new String();
    }

    public String[][][] code() {

        if (mapType == 1) {

            return mapType1();
        }
        if (mapType == 2) {

            return mapType2();
        }
        if (mapType == 3) {

            return mapType3();
        }
        if (mapType == 4) {

            return mapType4();
        }
        if (mapType == 5) {

            return mapType5();
        }
        if (mapType == 6) {

            return mapType6();
        }
        return new String[1][1][1];
    }

//capital letters for normal non-inverse, small letters for inverse
    private String[][][] mapType1() {
        String[][][] arr = new String[1][1][2];
        arr[0][0][0] = "A";
        arr[0][0][1] = "a";
        return arr;

    }

    private String[][][] mapType2() {
        String[][][] arr = new String[1][2][2];
        arr[0][0][0] = "AB";
        arr[0][0][1] = "aB";
        arr[0][1][0] = "Ab";
        arr[0][1][1] = "ab";
        return arr;

    }

    private String[][][] mapType3() {
        String[][][] arr = new String[1][2][4];
        arr[0][0][0] = "ABc";
        arr[0][0][1] = "ABC";
        arr[0][0][2] = "aBC";
        arr[0][0][3] = "aBc";
        arr[0][1][0] = "Abc";
        arr[0][1][1] = "AbC";
        arr[0][1][2] = "abC";
        arr[0][1][3] = "abc";
        return arr;

    }

    private String[][][] mapType4() {
        String[][][] arr = new String[1][4][4];
        arr[0][0][0] = "ABcd";
        arr[0][0][1] = "ABCd";
        arr[0][0][2] = "aBCd";
        arr[0][0][3] = "aBcd";
        arr[0][1][0] = "ABcD";
        arr[0][1][1] = "ABCD";
        arr[0][1][2] = "aBCD";
        arr[0][1][3] = "aBcD";
        arr[0][2][0] = "AbcD";
        arr[0][2][1] = "AbCD";
        arr[0][2][2] = "abCD";
        arr[0][2][3] = "abcD";
        arr[0][3][0] = "Abcd";
        arr[0][3][1] = "AbCd";
        arr[0][3][2] = "abCd";
        arr[0][3][3] = "abcd";
        return arr;

    }

    private String[][][] mapType5() {
        String[][][] arr = new String[2][4][4];
        arr[0][0][0] = "aBCde";
        arr[0][0][1] = "aBCDe";
        arr[0][0][2] = "abCDe";
        arr[0][0][3] = "abCde";

        arr[0][1][0] = "aBCdE";
        arr[0][1][1] = "aBCDE";
        arr[0][1][2] = "abCDE";
        arr[0][1][3] = "abCdE";

        arr[0][2][0] = "aBcdE";
        arr[0][2][1] = "aBcDE";
        arr[0][2][2] = "abcDE";
        arr[0][2][3] = "abcdE";

        arr[0][3][0] = "aBcde";
        arr[0][3][1] = "aBcDe";
        arr[0][3][2] = "abcDe";
        arr[0][3][3] = "abcde";

        arr[1][0][0] = "ABCde";
        arr[1][0][1] = "ABCDe";
        arr[1][0][2] = "AbCDe";
        arr[1][0][3] = "AbCde";

        arr[1][1][0] = "ABCdE";
        arr[1][1][1] = "ABCDE";
        arr[1][1][2] = "AbCDE";
        arr[1][1][3] = "AbCdE";

        arr[1][2][0] = "ABcdE";
        arr[1][2][1] = "ABcDE";
        arr[1][2][2] = "AbcDE";
        arr[1][2][3] = "AbcdE";

        arr[1][3][0] = "ABcde";
        arr[1][3][1] = "ABcDe";
        arr[1][3][2] = "AbcDe";
        arr[1][3][3] = "Abcde";
        return arr;

    }

    private String[][][] mapType6() {
        String[][][] arr = new String[4][4][4];
        arr[0][0][0] = "abCDef";
        arr[0][0][1] = "abCDEf";
        arr[0][0][2] = "abcDEf";
        arr[0][0][3] = "abcDef";

        arr[0][1][0] = "abCDeF";
        arr[0][1][1] = "abCDEF";
        arr[0][1][2] = "abcDEF";
        arr[0][1][3] = "abcDeF";

        arr[0][2][0] = "abCdeF";
        arr[0][2][1] = "abCdEF";
        arr[0][2][2] = "abcdEF";
        arr[0][2][3] = "abcdeF";

        arr[0][3][0] = "abCdef";
        arr[0][3][1] = "abCdEf";
        arr[0][3][2] = "abcdEf";
        arr[0][3][3] = "abcdef";

        arr[1][0][0] = "aBCDef";
        arr[1][0][1] = "aBCDEf";
        arr[1][0][2] = "aBcDEf";
        arr[1][0][3] = "aBcDef";

        arr[1][1][0] = "aBCDeF";
        arr[1][1][1] = "aBCDEF";
        arr[1][1][2] = "aBcDEF";
        arr[1][1][3] = "aBcDeF";

        arr[1][2][0] = "aBCdeF";
        arr[1][2][1] = "aBCdEF";
        arr[1][2][2] = "aBcdEF";
        arr[1][2][3] = "aBcdeF";

        arr[1][3][0] = "aBCdef";
        arr[1][3][1] = "aBCdEf";
        arr[1][3][2] = "aBcdEf";
        arr[1][3][3] = "aBcdef";

        arr[2][0][0] = "AbCDef";
        arr[2][0][1] = "AbCDEf";
        arr[2][0][2] = "AbcDEf";
        arr[2][0][3] = "AbcDef";

        arr[2][1][0] = "AbCDeF";
        arr[2][1][1] = "AbCDEF";
        arr[2][1][2] = "AbcDEF";
        arr[2][1][3] = "AbcDeF";

        arr[2][2][0] = "AbCdeF";
        arr[2][2][1] = "AbCdEF";
        arr[2][2][2] = "AbcdEF";
        arr[2][2][3] = "AbcdeF";

        arr[2][3][0] = "AbCdef";
        arr[2][3][1] = "AbCdEf";
        arr[2][3][2] = "AbcdEf";
        arr[2][3][3] = "Abcdef";

        arr[3][0][0] = "ABCDef";
        arr[3][0][1] = "ABCDEf";
        arr[3][0][2] = "ABcDEf";
        arr[3][0][3] = "ABcDef";

        arr[3][1][0] = "ABCDeF";
        arr[3][1][1] = "ABCDEF";
        arr[3][1][2] = "ABcDEF";
        arr[3][1][3] = "ABcDeF";

        arr[3][2][0] = "ABCdeF";
        arr[3][2][1] = "ABCdEF";
        arr[3][2][2] = "ABcdEF";
        arr[3][2][3] = "ABcdeF";

        arr[3][3][0] = "ABCdef";
        arr[3][3][1] = "ABCdEf";
        arr[3][3][2] = "ABcdEf";
        arr[3][3][3] = "ABcdef";

        return arr;

    }

}
