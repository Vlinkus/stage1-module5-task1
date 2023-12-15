package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            boolean allStartsUpperCase = true;
            for (String str : x)
                if(allStartsUpperCase)
                    allStartsUpperCase = Character.isUpperCase(str.charAt(0)) && !Character.isDigit(str.charAt(0));
            return allStartsUpperCase;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> even = new ArrayList<>();
            for (Integer i : x)
                if(i % 2 == 0)
                    even.add(i);
            x.addAll(even);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                            .filter(str -> Character.isUpperCase(str.charAt(0)) &&
                               str.charAt(str.length() - 1) == '.' &&
                               str.split(" ").length >= 3)
                      .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            x.forEach(str -> map.put(str, str.length()));
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
}
