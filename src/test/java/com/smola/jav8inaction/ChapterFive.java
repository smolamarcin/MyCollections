package com.smola.jav8inaction;

import com.smola.model.chapter5.Trader;
import com.smola.model.chapter5.Transaction;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class ChapterFive {
    Trader raoul = new Trader("Raoul", "Milan");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950));

    @Test
    void exercises() {
        // Find all transactions in the year 2011 and sort them by value (small to high)
        List<Transaction> sortedByYear = transactions.stream()
                .filter(e -> e.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getYear))
                .collect(toList());
        System.out.println(sortedByYear);

        // What are all the unique cities where the traders work?
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(toList());

        // Find all traders from Cambridge and sort them by name.
        List<Trader> tradersFromCambdridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(e -> e.getCity().equalsIgnoreCase("Cambridge"))
                .sorted(Comparator.comparing(Trader::getCity)).collect(toList());
        System.out.println(tradersFromCambdridge);

        // Return a string of all traders ’ names sorted alphabetically.

        Optional<String> reducedNames = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted(String::compareTo)
                .reduce((t1, t2) -> t1 + " "+ t2);
        System.out.println(reducedNames.orElse("Empty list"));

        // Are any traders based in Milan?
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .anyMatch(e -> e.equalsIgnoreCase("Milan"));

        // Print all transactions ’ values from the traders living in Cambridge.
        transactions.stream()
                .filter(e->e.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // What ’ s the highest / smallest value of all the transactions

        Integer max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo).orElse(-1);

        Integer min = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::min);
        System.out.println(min);
        System.out.println(max);
        // create map with expensive and cheap transactions
        Map<String, List<Transaction>> ex = transactions.stream().collect(groupingBy(e->isExpensive(e)));
        System.out.println(ex);
    }

    private String isExpensive(Transaction e) {
        return e.getValue() > 500 ? "Expensive" : "Cheap";
    }

}
