package saa;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SAA {

    public static void main(String[] args) {

        int arr[][][];

        String onesString = "";
        String nString = "";

        List<Integer> ones = new LinkedList<>();
        List<Integer> n = new LinkedList<>();
        List<Form> forms;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter ones(for exmp:1,2,3,4,5(limit:63)): ");
        onesString = sc.nextLine();
        System.out.println("");
        System.out.print("Please enter 'n's: ");
        nString = sc.nextLine();

        ones = Arrays.stream(onesString.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::valueOf).collect(Collectors.toList());

        n = Arrays.stream(nString.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::valueOf).collect(Collectors.toList());

        arr = Map.generateMap(ones, n);
        MapBrowser b = new MapBrowser(ones, n);

        MapPrinter p = new MapPrinter(b.map, b.mapType);
        p.printMap();
        b.browseMap();
        int input;
        System.out.println("");
        while (true) {
            System.out.print("Как бихте искали да продължите? Ако искате да намерите задължителните единици натиснете 1 и Enter.\n"
                    + "Ако искате да намерите минималните слепвания натиснете 2. \n Ако искате да намерите слепванията на картата"
                    + "натиснете 3.\n"
                    + "Натиснете 4 за да излезете. ");
            input = Integer.parseInt(sc.nextLine());
            System.out.println("");
            if (input == 4) {
                break;
            }
            if (input == 1) {
                System.out.println(b.returnMandatory());

            }
            if (input == 2) {
                for (String s : b.getResults()) {

                    System.out.println(s);
                }
            }
            if (input == 3) {
                for (String s : b.getAllCombos()) {
                    System.out.println(s);
                }
            }

        }
    }

}
