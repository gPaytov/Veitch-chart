
package saa;

import java.util.Arrays;

public class MapPrinter {

    int[][][] map;
    int mapType;

    public MapPrinter(int[][][] map, int mapType) {
        this.map = map;
        this.mapType = mapType;
    }

    public void printMap() {
        if (mapType == 1) {
            printMap1();
        }
        if (mapType == 2) {
            printMap2();
        }
        if (mapType == 3) {
            printMap3();
        }
        if (mapType == 4) {
            printMap4();
        }
        if (mapType == 5) {
            printMap5();
        }
        if (mapType == 6) {
            printMap6();
        }
    }

    private void printMap1() {

        System.out.println("x1 x1'");

        for (int[][] arr2 : map) {
            for (int[] arr3 : arr2) {
                for (int arr4 : arr3) {
                    System.out.print(arr4);
                    System.out.print("  ");

                }
                System.out.println("");
            }
            System.out.println("");
        }
    }

    private void printMap2() {

        System.out.println("   x1 x1'");
        String[] arr2 = new String[2];
        arr2[0] = "x2 ";
        arr2[1] = "x2'";

        int a = 0;
        int b = 0;
        int c = 0;
        for (int x[][] : map) {
            b = 0;
            for (int[] y : x) {
                c = 0;
                System.out.print(arr2[b]);
                for (int z : y) {
                    System.out.print(z + "   ");

                    c++;
                }
                System.out.println("");
                b++;
            }
            a++;
        }
    }

    private void printMap3() {

        System.out.println("   x1  x1  x1' x1'");
        String[] arr2 = new String[2];
        arr2[0] = "x2 ";
        arr2[1] = "x2'";

        int a = 0;
        int b = 0;
        int c = 0;
        for (int x[][] : map) {
            b = 0;
            for (int[] y : x) {
                c = 0;
                System.out.print(arr2[b]);
                for (int z : y) {
                    System.out.print(z + "   ");

                    c++;
                }
                System.out.println("");
                b++;
            }
            a++;
        }
        System.out.println("   x3' x3  x3  x3'");

    }

    private void printMap4() {

        System.out.println("   x1  x1  x1' x1'");
        String[] arr2 = new String[4];
        arr2[0] = "x2 ";
        arr2[1] = "x2 ";
        arr2[2] = "x2'";
        arr2[3] = "x2'";
        String[] arr3 = new String[4];
        arr3[0] = "x4'";
        arr3[1] = "x4 ";
        arr3[2] = "x4 ";
        arr3[3] = "x4'";

        int a = 0;
        int b = 0;
        int c = 0;
        for (int x[][] : map) {
            b = 0;
            for (int[] y : x) {
                c = 0;
                System.out.print(arr2[b]);
                for (int z : y) {
                    System.out.print(z + "   ");

                    c++;
                }
                System.out.print(arr3[b]);

                System.out.println("");
                b++;
            }
            a++;
        }
        System.out.println("   x3' x3  x3  x3'");

    }

    private void printMap5() {

        String[] s = new String[4];
        Arrays.fill(s, "");

        System.out.println("   x1  x1  x1  x1     x1' x1' x1' x1'");
        System.out.println("   x2  x2  x2' x2'    x2  x2  x2' x2'");

        String[] arr2 = new String[4];
        arr2[0] = "x3 ";
        arr2[1] = "x3 ";
        arr2[2] = "x3'";
        arr2[3] = "x3'";
        String[] arr3 = new String[4];
        arr3[0] = "x5'";
        arr3[1] = "x5 ";
        arr3[2] = "x5 ";
        arr3[3] = "x5'";

        int a = 0;
        int b = 0;
        int c = 0;
        for (int x[][] : map) {
            b = 0;
            for (int[] y : x) {
                c = 0;
                if (a == 1) {
                    System.out.print(arr2[b]);
                }
                for (int z : y) {
                    if (a == 0) {
                        s[b] += z + "   ";
                    } else {
                        System.out.print(z + "   ");

                    }
                    c++;
                }
                if (a == 1) {
                    System.out.print("|  " + s[b]);

                    System.out.println(arr3[b]);
                }
                b++;
            }
            a++;
        }
        System.out.println("   x4' x4  x4  x4'    x4' x4  x4  x4'");

    }

    private void printMap6() {

        String[] s1 = new String[4];
        Arrays.fill(s1, "");
        String[] s0 = new String[4];
        Arrays.fill(s0, "");
        String[] s2 = new String[4];
        Arrays.fill(s2, "");

        System.out.println("   x1  x1  x1  x1     x1' x1' x1' x1'");
        System.out.println("   x3  x3  x3' x3'    x3  x3  x3' x3'");

        String[] arr2 = new String[4];
        arr2[0] = "x4 ";
        arr2[1] = "x4 ";
        arr2[2] = "x4'";
        arr2[3] = "x4'";
        String[] arr3 = new String[4];
        arr3[0] = "x6'";
        arr3[1] = "x6 ";
        arr3[2] = "x6 ";
        arr3[3] = "x6'";

        int a = 0;
        int b = 0;
        int c = 0;
        for (int x[][] : map) {
            b = 0;
            for (int[] y : x) {
                c = 0;
                if (a == 3) {
                    System.out.print(arr2[b]);
                }
                for (int z : y) {
                    if (a == 1) {
                        s1[b] += z + "   ";
                    } else if (a == 3) {
                        System.out.print(z + "   ");

                    } else if (a == 0) {
                        s0[b] += z + "   ";
                    } else if (a == 2) {
                        s2[b] += z + "   ";
                    }
                    c++;
                }
                if (a == 3) {
                    System.out.print("|  " + s1[b]);

                    System.out.println(arr3[b]);
                    if (b == 3) {
                        System.out.println("");
                        for (int i = 0; i < 4; i++) {
                                                System.out.print(arr2[i]);

                            System.out.print(s2[i] + "|  " + s0[i]);
                                                System.out.println(arr3[i]);

                        }
                    }
                }
                b++;
            }
            a++;
        }
        System.out.println("   x5' x5  x5  x5'    x5' x5  x5  x5'");

    }

}
