package com.hussein.samples.stairsteps;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StairStepsCombinationCalculatorTest {

    @Test
    void stairsWithZeroStepsShouldReturnEmptyResult() {
        assertThat(StairStepsCombinationCalculator.combinationsFor(0)).containsOnly("");
    }

    @Test
    void stairsWithOneStepShouldReturnOnlyOneCombination() {
        assertThat(StairStepsCombinationCalculator.combinationsFor(1))
                .containsOnly("1");
    }

    @Test
    void stairsWith2StepsShouldReturn2Combinations() {
        assertThat(StairStepsCombinationCalculator.combinationsFor(2))
                .containsOnly("1,1", "2");
    }

    @Test
    void staisWithNStepsShouldReturnAllPossibleCombinations() {
        assertThat(StairStepsCombinationCalculator.combinationsFor(4))
                .containsOnly(
                        "1,1,1,1",
                        "2,1,1",
                        "2,2",
                        "1,2,1",
                        "1,1,2");
    }

    @Test
    void memoryOptimisedCombinationForShouldReturnAllPossibleCombinationsWhenStairStepsIs4() {
        assertThat(StairStepsCombinationCalculator.memoryOptimisedCombinationsFor(4))
                .containsOnly(
                        "1,1,1,1",
                        "2,1,1",
                        "2,2",
                        "1,2,1",
                        "1,1,2");
    }

    @Test
    void memoryOptimisedCombinationForShouldReturn2CombinationsWhenStairStepsIs2() {
        assertThat(StairStepsCombinationCalculator.memoryOptimisedCombinationsFor(2))
                .containsOnly("1,1", "2");
    }

    @Test
    void memoryOptimisedCombinationForShouldReturnEmptyCombinationsWhenStairStepsIs0() {
        assertThat(StairStepsCombinationCalculator.memoryOptimisedCombinationsFor(0)).containsOnly("");
    }

    @Test
    void memoryOptimisedCombinationForShouldReturn1CombinationsWhenStairStepsIs1() {
        assertThat(StairStepsCombinationCalculator.memoryOptimisedCombinationsFor(1))
                .containsOnly("1");
    }
}