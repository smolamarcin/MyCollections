package com.smola.jav8inaction;

import com.smola.model.chapter5.Dish;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class ChapterSix {
    List<Dish> menu = Dish.menu;

    @Test
    void groupingExercises() {
        // highest calories value
        Dish maxCaloriesUsingMax = menu.stream().max(comparingInt(Dish::getCalories)).get();

        Optional<Dish> maxCaloriesCollectors = menu.stream().collect(Collectors.maxBy(comparingInt(Dish::getCalories)));
        System.out.println(maxCaloriesUsingMax);

        // concatinate all dishes names

        String names = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(" "));
        System.out.println(names);

        // get sum of calories
        menu.stream()
                .map(Dish::getCalories)
                .collect(Collectors.reducing(0, (i, j) -> i + j));

        // group dishes by type

        Map<Dish.Type, List<Dish>> byType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(byType);

        // group for diet - 1 level grouping

        Map<Dish.CaloricLever, List<Dish>> diet = menu.stream()
                .collect(Collectors.groupingBy(dish -> isCaloric(dish.getCalories())));

        System.out.println(diet);

        // group for diret - 2 level grouping

        Map<Dish.Type, Map<Dish.CaloricLever, List<Dish>>> multiLevelGrouping = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> isCaloric(dish))));
        System.out.println(multiLevelGrouping);

        // count dishes of type
        Map<Dish.Type, Long> countOfSPecificType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, counting()));
        System.out.println(countOfSPecificType);

        // highest calories with dish type

        Map<Dish.Type, Optional<Dish>> fatDishesOptional = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.maxBy(comparingInt(Dish::getCalories))));

        System.out.println(fatDishesOptional);

        Map<Dish.Type, Dish> fatDishesWithoutOptional = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(fatDishesWithoutOptional);

        menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), e -> {
                            Dish dish = e.get();
                            System.err.println(dish);
                            return dish;
                        })));
        // sum of calories of particular type

        System.out.println(menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories))));


        // which caloric level is available for each dish type

        System.out.println(menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.mapping(dish -> isCaloric(dish),toList()))));

        // check vegetarian

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianWithTypes = menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian,Collectors.groupingBy(Dish::getType)));

        System.out.println(vegetarianWithTypes);

        // check vegetarian with string ->

        Map<String, Map<Dish.Type, List<Dish>>> vegetarianWithDataTypesStrings = menu.stream()
                .collect(Collectors.groupingBy(e -> checkVegetarian(e.isVegetarian()), Collectors.groupingBy(Dish::getType)));
        System.out.println(vegetarianWithDataTypesStrings);

        // most caloric vegetarian and non-vegetarian
        Map<String, Dish> mostCaloricVegetarian = menu.stream()
                .collect(Collectors.groupingBy(e -> checkVegetarian(e.isVegetarian()),
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));


        System.out.println(mostCaloricVegetarian);
        // using partiniong by

        System.out.println(menu.stream().collect(Collectors.partitioningBy(e->e.isVegetarian(),
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get))));


    }

    String checkVegetarian(boolean isVegetarian){
        return isVegetarian ? "VEGETARRRRIAN" : "NON VEGETARRRRIAN";
    }

    private Dish.CaloricLever isCaloric(Dish dish) {
        return isCaloric(dish.getCalories());
    }

    private Dish.CaloricLever isCaloric(int calories) {
        if (calories < 400) {
            return Dish.CaloricLever.DIET;
        } else if (400 < calories && calories > 700) {
            return Dish.CaloricLever.NORMAL;
        } else {
            return Dish.CaloricLever.FAT;
        }
    }
}
