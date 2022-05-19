/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author x
 */
public class ThreeDimensional implements Form {

    private List<Coordinates> shapes;

    public ThreeDimensional() {
    }

    public ThreeDimensional(List<Coordinates> shapes) {
        this.shapes = shapes;
    }

    @Override
    public List<Form> returnAll(Coordinates co, int[][][] map) {
        List<Form> allForms;
        Form rect = new Rectangle();
        allForms = rect.returnAll(co, map);
        for (Form fo : new LinkedList<Form>(allForms)) {
            combine(co, allForms, fo, map);
        }
        return allForms.stream().distinct().collect(Collectors.toList());

    }

    private void combine(Coordinates co, List<Form> allForms, Form t, int[][][] map) {
        try {
            boolean finished = false;
            List<Coordinates> tempCoo = new LinkedList<>();

            for (Coordinates cc : t.getCoordinates()) {
                finished = false;
                if (!((map[0][cc.getB()][cc.getC()] == 1 || map[0][cc.getB()][cc.getC()] == 2)
                        && (map[1][cc.getB()][cc.getC()] == 1 || map[1][cc.getB()][cc.getC()] == 2)
                        && (map[2][cc.getB()][cc.getC()] == 1 || map[2][cc.getB()][cc.getC()] == 2)
                        && (map[3][cc.getB()][cc.getC()] == 1 || map[3][cc.getB()][cc.getC()] == 2))) {

                    break;
                }
                finished = true;
                tempCoo.add(new Coordinates(0, cc.getB(), cc.getC()));
                tempCoo.add(new Coordinates(1, cc.getB(), cc.getC()));
                tempCoo.add(new Coordinates(2, cc.getB(), cc.getC()));
                tempCoo.add(new Coordinates(3, cc.getB(), cc.getC()));

            }
            if (finished) {
                allForms.add(new Rectangle(new LinkedList<Coordinates>(tempCoo)));

            }
            for (Coordinates cc2 : t.getCoordinates()) {
                if (cc2.getA() == 0 || cc2.getA() == 3) {
                    combine1(allForms, t, 1, map);
                    combine1(allForms, t, 2, map);

                } else if (cc2.getA() == 1 || cc2.getA() == 2) {
                    combine1(allForms, t, 0, map);
                    combine1(allForms, t, 3, map);

                }

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            if(t.getCoordinates().get(0).getA() == 1){
                            combine1(allForms, t, 0, map);

            }
            if(t.getCoordinates().get(0).getA() == 0){
                            combine1(allForms, t, 1, map);

            }
        }
    }

    //a2 demek tursime shodstvie s takova a
    private void combine1(List<Form> allForms, Form t1, int a2, int[][][] map) {
        boolean finished = false;
        List<Coordinates> tempCoo = new LinkedList<>();

        for (Coordinates cc : t1.getCoordinates()) {
            finished = false;
            if (!((map[a2][cc.getB()][cc.getC()] == 1 || map[a2][cc.getB()][cc.getC()] == 2))) {

                break;
            }
            finished = true;
            tempCoo.add(new Coordinates(a2, cc.getB(), cc.getC()));

        }
        if (finished) {
            if(tempCoo.get(0).getA()<t1.getCoordinates().get(0).getA()){
            tempCoo.addAll(t1.getCoordinates());

            allForms.add(new Rectangle(new LinkedList<Coordinates>(tempCoo)));
            }
            else{
                   allForms.add(new Rectangle(new LinkedList<Coordinates>() {
                    {
                        for (Coordinates c1 : t1.getCoordinates()) {
                            add(c1);
                        }
                        for (Coordinates c2 : tempCoo) {
                            add(c2);
                        }
                    }
                }));
            }
        }
    }

    @Override
    public List<Coordinates> getCoordinates() {
        return shapes;
    }

    @Override
    public int howBig() {
        return shapes.size();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.shapes);
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
        final ThreeDimensional other = (ThreeDimensional) obj;
        if (!Objects.equals(this.shapes, other.shapes)) {
            return false;
        }
        return true;
    }

}
