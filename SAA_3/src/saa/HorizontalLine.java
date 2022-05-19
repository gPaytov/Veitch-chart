package saa;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HorizontalLine implements Form {

    private List<Coordinates> lines;

    public HorizontalLine(List<Coordinates> lines) {
        this.lines = lines;

    }

    public HorizontalLine() {
    }

    @Override
    public List<Form> returnAll(Coordinates co, int[][][] map) {
        List<Form> horizontals = new LinkedList<>();

        try {
            if ((map[co.getA()][co.getB()][0] == 1 || map[co.getA()][co.getB()][0] == 2)
                    && (map[co.getA()][co.getB()][1] == 1 || map[co.getA()][co.getB()][1] == 2)
                    && (map[co.getA()][co.getB()][2] == 1 || map[co.getA()][co.getB()][2] == 2)
                    && (map[co.getA()][co.getB()][3] == 1 || map[co.getA()][co.getB()][3] == 2)) {

                horizontals.add(new HorizontalLine(new LinkedList<Coordinates>() {
                    {
                        add(new Coordinates(co.getA(), co.getB(), 0));
                        add(new Coordinates(co.getA(), co.getB(), 1));
                        add(new Coordinates(co.getA(), co.getB(), 2));
                        add(new Coordinates(co.getA(), co.getB(), 3));
                    }
                }));
            }

            if (co.getC() != 0) {
                if (map[co.getA()][co.getB()][co.getC() - 1] == 1
                        || map[co.getA()][co.getB()][co.getC() - 1] == 2) {
                    horizontals.add(new HorizontalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), co.getB(), co.getC() - 1));
                            add(new Coordinates(co.getA(), co.getB(), co.getC()));
                        }
                    }));
                }
            } else {
                if (map[co.getA()][co.getB()][3] == 1
                        || map[co.getA()][co.getB()][3] == 2) {
                    horizontals.add(new HorizontalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), co.getB(), 0));
                            add(new Coordinates(co.getA(), co.getB(), 3));
                        }
                    }));
                }
            }

            if (co.getC() != 3) {
                if (map[co.getA()][co.getB()][co.getC() + 1] == 1
                        || map[co.getA()][co.getB()][co.getC() + 1] == 2) {
                    horizontals.add(new HorizontalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), co.getB(), co.getC()));
                            add(new Coordinates(co.getA(), co.getB(), co.getC() + 1));
                        }
                    }));
                }
            } else {
                if (map[co.getA()][co.getB()][0] == 1
                        || map[co.getA()][co.getB()][0] == 2) {
                    horizontals.add(new HorizontalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), co.getB(), 0));
                            add(new Coordinates(co.getA(), co.getB(), 3));
                        }
                    }));
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            if (co.getC() != 0) {
                if (map[co.getA()][co.getB()][co.getC() - 1] == 1
                        || map[co.getA()][co.getB()][co.getC() - 1] == 2) {

                    horizontals.add(new HorizontalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), co.getB(), co.getC() - 1));
                            add(new Coordinates(co.getA(), co.getB(), co.getC()));
                        }
                    }));
                }
            }
            if (co.getC() != 1) {
                if (map[co.getA()][co.getB()][co.getC() + 1] == 1
                        || map[co.getA()][co.getB()][co.getC() + 1] == 2) {

                    horizontals.add(new HorizontalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), co.getB(), co.getC()));
                            add(new Coordinates(co.getA(), co.getB(), co.getC() + 1));
                        }
                    }));
                }
            }
        }
        //adding the single 1 as a horizontal line so that we can chck it with the other lines 
        //in 3D

        horizontals.add(new HorizontalLine(new LinkedList<Coordinates>() {
            {
                add(new Coordinates(co.getA(), co.getB(), co.getC()));
            }
        }));
        return horizontals;
    }

    @Override
    public List<Coordinates> getCoordinates() {
        return lines;
    }

    public void setLines(List<Coordinates> lines) {
        this.lines = lines;
    }

    @Override
    public int howBig() {
        return lines.size();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.lines);
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
        final HorizontalLine other = (HorizontalLine) obj;
        if (!Objects.equals(this.lines, other.lines)) {
            return false;
        }
        return true;
    }

}
