/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author x
 */
public class VerticalLine implements Form {

    private List<Coordinates> lines;

    public VerticalLine(List<Coordinates> lines) {
        this.lines = lines;

    }

    public VerticalLine() {
    }

    @Override
    public List<Form> returnAll(Coordinates co, int[][][] map) {
        List<Form> verticals = new LinkedList<>();
        //find out if there's a big line(4 ones)
        try {
            if ((map[co.getA()][0][co.getC()] == 1 || map[co.getA()][0][co.getC()] == 2)
                    && (map[co.getA()][1][co.getC()] == 1 || map[co.getA()][1][co.getC()] == 2)
                    && (map[co.getA()][2][co.getC()] == 1 || map[co.getA()][2][co.getC()] == 2)
                    && (map[co.getA()][3][co.getC()] == 1 || map[co.getA()][3][co.getC()] == 2)
                    ) {

                verticals.add(new VerticalLine(new LinkedList<Coordinates>() {
                    {
                        add(new Coordinates(co.getA(), 0, co.getC()));
                        add(new Coordinates(co.getA(), 1, co.getC()));
                        add(new Coordinates(co.getA(), 2, co.getC()));
                        add(new Coordinates(co.getA(), 3, co.getC()));
                    }
                }));
            }
            //if there's a big line then there are two smaller ones 

            if (co.getB() != 0) {
                if (map[co.getA()][co.getB() - 1][co.getC()] == 1
                        || map[co.getA()][co.getB() - 1][co.getC()] == 2) {
                    verticals.add(new VerticalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), co.getB() - 1, co.getC()));
                            add(new Coordinates(co.getA(), co.getB(), co.getC()));
                        }
                    }));
                }
            } else {
                if (map[co.getA()][3][co.getC()] == 1
                        || map[co.getA()][3][co.getC()] == 2) {
                    verticals.add(new VerticalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), 0, co.getC()));
                            add(new Coordinates(co.getA(), 3, co.getC()));
                        }
                    }));
                }
            }

            if (co.getB() != 3) {
                if (map[co.getA()][co.getB() + 1][co.getC()] == 1
                        || map[co.getA()][co.getB() + 1][co.getC()] == 2) {
                    verticals.add(new VerticalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), co.getB(), co.getC()));
                            add(new Coordinates(co.getA(), co.getB() + 1, co.getC()));
                        }
                    }));
                }
            } else {
                if (map[co.getA()][0][co.getC()] == 1
                        || map[co.getA()][0][co.getC()] == 2) {
                    verticals.add(new VerticalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), 0, co.getC()));
                            add(new Coordinates(co.getA(), 3, co.getC()));
                        }
                    }));
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            try{
            if (co.getB() != 0) {
                 if (map[co.getA()][co.getB() - 1][co.getC()] == 1
                        || map[co.getA()][co.getB() - 1][co.getC()] == 2) {
                    verticals.add(new VerticalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), co.getB() - 1, co.getC()));
                            add(new Coordinates(co.getA(), co.getB(), co.getC()));
                        }
                    }));
                }
            }
            if (co.getB() != 1) {
              if (map[co.getA()][co.getB() + 1][co.getC()] == 1
                        || map[co.getA()][co.getB() + 1][co.getC()] == 2) {
                    verticals.add(new VerticalLine(new LinkedList<Coordinates>() {
                        {
                            add(new Coordinates(co.getA(), co.getB(), co.getC()));
                            add(new Coordinates(co.getA(), co.getB() + 1, co.getC()));
                        }
                    }));
                }
            }
            }
            catch (ArrayIndexOutOfBoundsException e1) {
                return new LinkedList<Form>();
            }
        }
       
        return verticals;
    }

    @Override
    public List<Coordinates> getCoordinates() {
        // System.out.println(lines.get(0));
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
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.lines);
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
        final VerticalLine other = (VerticalLine) obj;
        if (!Objects.equals(this.lines, other.lines)) {
            return false;
        }
        return true;
    }
    

}
