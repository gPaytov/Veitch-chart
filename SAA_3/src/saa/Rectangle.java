package saa;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rectangle implements Form {

    private List<Coordinates> shapes;

    public Rectangle() {
    }

    public Rectangle(List<Coordinates> shapes) {
        this.shapes = shapes;
    }

    @Override
    public List<Form> returnAll(Coordinates co, int[][][] map) {
        List<Form> verticals = new LinkedList<>();
        List<Form> horizontals = new LinkedList<>();
        List<Form> allForms = new LinkedList<>();

        Form vertical = new VerticalLine();
        Form horizontal = new HorizontalLine();

        verticals = vertical.returnAll(co, map);
        horizontals = horizontal.returnAll(co, map);
        for (Form v : verticals) {
            allForms.add(v);
        }
        for (Form h : horizontals) {
            allForms.add(h);
        }

        boolean flag = true;
        for (Form v : verticals) {
            for (Form h : horizontals) {

                combine(co, allForms, h, v, map);

                if (flag) {
                    combine3(co, allForms, h, map);
                }
            }
            flag = false;
            combine2(co, allForms, v, map);

        }

        return allForms.stream().distinct().collect(Collectors.toList());

    }

    private void combine(Coordinates co, List<Form> allForms, Form hor, Form ver, int[][][] map) {

        int height = ver.howBig();
        int startingC = hor.getCoordinates().get(0).getC();
        int startingB = ver.getCoordinates().get(0).getB();
        List<Coordinates> tempCoo = new LinkedList<>();
        int width = hor.howBig();

        boolean finished = false;

        for (int q = startingC; q < startingC + width; q++) {
            if (width == 1) {
                break;
            }
            for (int w = startingB; w < startingB + height; w++) {
                finished = false;
                if (map[co.getA()][w][q] != 1 && map[co.getA()][w][q] != 2) {
                    break;
                }
                finished = true;
                tempCoo.add(new Coordinates(co.getA(), w, q));
            }
            if (!finished) {
                break;
            }

        }
        if (finished == true) {
            allForms.add(new Rectangle(new LinkedList<Coordinates>(tempCoo)));
        }

    }

    private void combine2(Coordinates co, List<Form> allForms, Form ver, int[][][] map) {
        try {
            boolean finished = false;
            boolean first = false;
            List<Coordinates> tempCoo = new LinkedList<>();

            if (ver.getCoordinates().get(0).getC() == 0) {
                for (Coordinates c : ver.getCoordinates()) {
                    finished = false;
                    if (map[c.getA()][c.getB()][3] != 1 && map[co.getA()][c.getB()][3] != 2) {
                        break;
                    }
                    finished = true;
                    tempCoo.add(new Coordinates(co.getA(), c.getB(), 3));
                }
            } else if (ver.getCoordinates().get(0).getC() == 3) {
                first = true;
                for (Coordinates c : ver.getCoordinates()) {
                    finished = false;
                    if (map[c.getA()][c.getB()][0] != 1 && map[co.getA()][c.getB()][0] != 2) {
                        break;
                    }
                    finished = true;
                    tempCoo.add(new Coordinates(co.getA(), c.getB(), 0));
                }
            }
            if (finished == true && first) {
                tempCoo.addAll(ver.getCoordinates());

                allForms.add(new Rectangle(new LinkedList<Coordinates>(tempCoo)));

            }
            if (finished == true && !first) {

                allForms.add(new Rectangle(new LinkedList<Coordinates>() {
                    {
                        for (Coordinates c1 : ver.getCoordinates()) {
                            add(c1);
                        }
                        for (Coordinates c2 : tempCoo) {
                            add(c2);
                        }
                    }
                }));

            }

        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    private void combine3(Coordinates co, List<Form> allForms, Form hor, int[][][] map) {
        try {
            boolean finished = false;
            boolean first = false;
            List<Coordinates> tempCoo = new LinkedList<>();

            if (hor.getCoordinates().get(0).getB() == 0 && hor.howBig() > 1) {
                for (Coordinates c : hor.getCoordinates()) {
                    finished = false;
                    if (map[c.getA()][3][c.getC()] != 1 && map[co.getA()][3][c.getC()] != 2) {
                        break;
                    }
                    finished = true;
                    tempCoo.add(new Coordinates(co.getA(), 3, c.getC()));
                }
            } else if (hor.getCoordinates().get(0).getB() == 3 && hor.howBig() > 1) {
                first = true;
                for (Coordinates c : hor.getCoordinates()) {
                    finished = false;
                    if (map[c.getA()][0][c.getC()] != 1 && map[co.getA()][0][c.getC()] != 2) {
                        break;
                    }
                    finished = true;
                    tempCoo.add(new Coordinates(co.getA(), 0, c.getC()));
                }

            }
            if (finished == true && first) {
                tempCoo.addAll(hor.getCoordinates());

                allForms.add(new Rectangle(new LinkedList<Coordinates>(tempCoo)));

            }
            if (finished == true && !first) {

                allForms.add(new Rectangle(new LinkedList<Coordinates>() {
                    {
                        for (Coordinates c1 : hor.getCoordinates()) {
                            add(c1);
                        }
                        for (Coordinates c2 : tempCoo) {
                            add(c2);
                        }
                    }
                }));

            }
        } catch (ArrayIndexOutOfBoundsException e) {

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
        hash = 29 * hash + Objects.hashCode(this.shapes);
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
        final Rectangle other = (Rectangle) obj;
        if (!Objects.equals(this.shapes, other.shapes)) {
            return false;
        }
        return true;
    }

}
