package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLesson {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        numbers.add(85.);
        numbers.add(42.);
        numbers.add(97.);
        numbers.add(33.);
        numbers.add(26.);
        numbers.add(3.);
        numbers.add(50.);
        numbers.add(0.);
        numbers.add(30.);
        numbers.add(70.);

        double anything = Double.NEGATIVE_INFINITY;
        double anything2 = Double.POSITIVE_INFINITY;
        List<Double> evenNumbers = new ArrayList<>();
        List<Double> oddNumbers = new ArrayList<>();
        double total = 0;
        List<Double> oddSquareNumbers = new ArrayList<>();
        double minOddSquareNumber = Double.POSITIVE_INFINITY;

        for (int i = 0; i < 10; i++) {
            anything = Math.max(anything, numbers.get(i));
            anything2 = Math.min(anything2, numbers.get(i));
            if (numbers.get(i) % 2 == 0) {
                evenNumbers.add(numbers.get(i));
            }
            else {
                oddNumbers.add(numbers.get(i));
            }
            total += numbers.get(i);
            oddSquareNumbers.add(Math.pow(numbers.get(i),2));
            if (oddSquareNumbers.get(oddSquareNumbers.size()-1) % 2 == 0) {
                oddSquareNumbers.remove(oddSquareNumbers.size() - 1);
            }
            minOddSquareNumber = Math.min(minOddSquareNumber,oddSquareNumbers.get(oddSquareNumbers.size()-1));

        }
        System.out.println("max number is " + anything + "\n min number is " + anything2 + "\n total number is " + total + "\n odd square numbers are" + oddSquareNumbers +"\n min od square number is " + minOddSquareNumber);

        System.out.println(numbers.stream().reduce((accumulator, current)-> accumulator + current));

        System.out.println(numbers.stream().reduce((accumulator, current)-> Math.max(accumulator, current)));

        System.out.println(numbers.stream().reduce((accumulator, current)-> Math.min(accumulator, current)));

        System.out.println(numbers.stream().filter(number->number % 2 == 0 ).collect(Collectors.toList()));

        System.out.println(numbers.stream().filter(number->number % 2 != 0).collect(Collectors.toList()));

        System.out.println(numbers.stream().map(number -> Math.pow(number,2)).filter(number->number % 2 != 0 ).reduce((accumulator, current) -> Math.min(accumulator, current)));





    }//write within this bracket
}
