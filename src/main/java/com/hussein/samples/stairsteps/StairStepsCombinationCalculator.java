package com.hussein.samples.stairsteps;


import java.util.*;
import java.util.stream.Collectors;

public class StairStepsCombinationCalculator {
    public static Set<String> combinationsFor(final int stairSteps) {

        final List<Integer> ones = Collections.nCopies(stairSteps, 1);

        Set<String> allStairCombinations = new HashSet<>();
        allStairCombinations.add(combineElements(ones));

        calculateCombinations("", ones, allStairCombinations);

        return allStairCombinations;
    }

    //A tail-recursive version which is safe on stack(this is a popular concept in Scala)
    // I am using recursion to calculate all combinations
    //Have 3 stopping conditions
    private static void calculateCombinations(final String previousCombinedElementsBuffer,
                                              final List<Integer> elements,
                                              final Set<String> accumulatedCombinations) {
        if (elements == null || elements.isEmpty()) {
            accumulatedCombinations.add(previousCombinedElementsBuffer);
            return;
        }
        if (elements.size() == 1) {
            accumulatedCombinations.add(combineElements(previousCombinedElementsBuffer,
                    combineElements(elements)));
            return;
        }

        if (elements.size() == 2) {
            accumulatedCombinations.add(combineElements(previousCombinedElementsBuffer, combineElements(1, 1)));
            accumulatedCombinations.add(combineElements(previousCombinedElementsBuffer, "2"));
            return;
        }

        for (int i=0;i<elements.size()-1;i++) {
            String currentCombinationBuffer = combineElements(previousCombinedElementsBuffer,
                    combineElements(elements.subList(0, i)), "2");

            calculateCombinations(currentCombinationBuffer,
                    elements.subList(i+2, elements.size()), accumulatedCombinations);
        }
    }

    private static <T> String combineElements(final List<T> elements) {
        return elements.stream()
                .map(Object::toString)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(","));
    }
    private static <T> String combineElements(final T... elements) {
        return combineElements(Arrays.asList(elements));
    }
}
