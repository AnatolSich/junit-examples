package com.epam.junit.runner.parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Custom parser for using in @TestWith annotated tests
public class CustomCoercer {

    public List<Integer> createIntList(String input) {
        String[] elements = input.replaceAll("\\[|]", "").split(";");

        return Arrays.stream(elements).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
    }

    public Integer[] createIntArray(String input) {
        String[] elements = input.replaceAll("\\[|]", "").split(";");

        return Arrays.stream(elements).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList())
                .toArray(new Integer[elements.length]);
    }

    public Boolean[] createBooleanArray(String input) {
        String[] elements = input.replaceAll("\\[|]", "").split(";");

        return Arrays.stream(elements).map(Boolean::valueOf).collect(Collectors.toList())
                .toArray(new Boolean[elements.length]);
    }

}
