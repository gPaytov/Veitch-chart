
package saa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class MapBrowser {

    List<Integer> ones;
    List<Integer> n;
    List<Equation> completed;
    List<Equation> uncompleted;

    int[][][] map;
    int mapType;

    public MapBrowser() {
    }

    public MapBrowser(List<Integer> ones, List<Integer> n) {
        this.ones = ones;
        this.n = n;
        this.completed = new LinkedList<>();
        this.map = Map.generateMap(ones, n);
        this.uncompleted = new LinkedList<>();
        if (n.isEmpty()) {
            mapType = Map.mapType(ones);
        } else {
            mapType = Map.mapType(ones, n);
        }
    }

    public void browseMap() {
        Equation equation = new Equation(map, mapType);
        browseEquation(equation);

        List<Equation> temp = new LinkedList<>();
        do {
            for (Equation e : uncompleted) {

                temp.add(e);
            }
            uncompleted = new LinkedList<Equation>();
            for (Equation e : temp) {
                browseEquation(e);
            }
        } while (!uncompleted.isEmpty());

    }

    public void browseEquation(Equation equation) {
        List<Form> forms;
        Equation e;
        while (!equation.isComplete()) {
            forms = returnLargest(equation.getMap());
            if (forms.size() > 1) {
                for (Form f : forms.subList(1, forms.size())) {
                    e = new Equation(new LinkedList<Form>(equation.getForms()), equation.getMap(), mapType);
                    e.updateEquation(f, e.getMap(), ones, n);
                    if (e.isComplete()) {
                        completed.add(e);
                    } else {
                        this.uncompleted.add(e);
                    }

                }
            }
            equation.updateEquation(forms.get(0), equation.getMap(), ones, n);
//            equation.printMap();
        }
        completed.add(equation);
        completed = completed.stream().distinct().collect(Collectors.toList());


    }

    public List<String> getAllCombos() {
        List<String> str = new LinkedList<String>();

        for (Equation e : completed) {

            str.add(e.getSortedEquation());

        }
        return str.stream().distinct().collect(Collectors.toList());
    }


    public List<String> getResults() {
        List<String> str = new LinkedList<String>();
        int min = completed.get(0).toString().replace(" + ", "").replace("'", "").length();
        for (Equation e : completed) {
            if (e.toString().replace(" + ", "").replace("'", "").length() < min) {
                min = e.toString().replace(" + ", "").replace("'", "").length();
            }
        }

        for (Equation e : completed) {
            if (e.toString().replace(" + ", "").replace("'", "").length() == min) {

                str.add(e.getSortedEquation());
            }
        }
        return str.stream().distinct().collect(Collectors.toList());

    }

    public List<String> returnMandatory() {
        List<String> all = getResults();
        List<String> toRemove = new ArrayList<>();
        List<String> mand = new ArrayList<>();
        System.out.println("За да намерим задължителните ПИ първо запазваме ПИ на първата минимална функция \n"
                + "в масив от стрингове.");
        String u = all.get(0);
        String[] base;
        base = u.split(Pattern.quote(" + "));
        for(String w : base){
            System.out.println(w);
        }
        System.out.println("Това са нашите ПИ. Използваме ги като база за сравнение на останалите минимални функции."
                + "\nОбхождаме всички минимални функции и когато намерим някоя, която не съдържа която и да е проста\n"
                + "импликанта от базата премахваме тази ПИ от базата.");
        for (String s : all.subList(1, all.size())) {
            for (String b : base) {
                if (!Arrays.asList(s.split(Pattern.quote(" + "))).contains(b)) {
                    toRemove.add(b);
                    System.out.println(b+ " е премахната");
                }
            }
            
            System.out.println("Накрая извеждаме остатъка от базата.");
        }     
        for (String b : base) {
            if (!toRemove.contains(b)) {
                mand.add(b);
            }
        }

        return mand;
    }


    public List<Coordinates> getOnes(int[][][] map) {
        int a = 0;
        int b = 0;
        int c = 0;
        List<Coordinates> tempCoo = new LinkedList<>();
        for (int x[][] : map) {
            b = 0;
            for (int[] y : x) {
                c = 0;
                for (int z : y) {
                    if (z == 1) {
                        tempCoo.add(new Coordinates(a, b, c));
                    }
                    c++;
                }
                b++;
            }
            a++;
        }
        return tempCoo;
    }

    public List<Form> returnLargest(int[][][] map) {
        List<Form> forms = getForms(map);
        List<Form> largest = new LinkedList<>();


        int max = MapBrowser.getOnes(forms.get(0), map);
        for (Form f : forms) {
            if (MapBrowser.getOnes(f, map) > max) {
                max = MapBrowser.getOnes(f, map);
            }
        }
        for (Form f : forms) {
            if (MapBrowser.getOnes(f, map) >= max) {
                largest.add(f);
            }
        }
        return largest;
    }

    public static int getOnes(Form f, int[][][] map) {
        int ones = 0;
        for (Coordinates c : f.getCoordinates()) {
            if (map[c.getA()][c.getB()][c.getC()] == 1) {
                ones++;
            }
        }
        return ones;
    }

    private List<Form> getForms(int[][][] map) {
        List<Coordinates> tempCoo = getOnes(map);
        List<Form> forms = new LinkedList<>();
        if (mapType == 1) {
            for (Coordinates co : tempCoo) {
                Form hor = new HorizontalLine();
                forms.addAll(hor.returnAll(co, map));

            }
        }
        if (mapType == 2 || mapType == 3 || mapType == 4) {
            for (Coordinates co : tempCoo) {
                Form rect = new Rectangle();
                forms.addAll(rect.returnAll(co, map));

            }
        }
        if (mapType == 5 || mapType == 6) {
            for (Coordinates co : tempCoo) {
                Form threeD = new ThreeDimensional();
                forms.addAll(threeD.returnAll(co, map));

            }
        }
        return forms.stream().distinct().collect(Collectors.toList());

    }
}
