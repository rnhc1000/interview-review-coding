package br.dev.ferreiras.challenges;

import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * DoubleSummaryStatistics():
 * A default constructor which initializes the count and sum to zero, and sets max to Double.NEGATIVE_INFINITY and
 * min to Double.POSITIVE_INFINITY.
 */
public class Statistics {

    public static DoubleSummaryStatistics getStatistics() {
        DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();

        var statistics = IntStream
                .range(1,20)
                .mapToDouble(number -> Math.random() * number * 0.173119)
                .boxed()
                .toList();

        for (Double statistic : statistics) {

            doubleSummaryStatistics.accept(statistic);
        }

        Logger.getGlobal().log(
                Level.INFO, String.format("::: %s :::", statistics)
        );

        Logger.getGlobal().log(

                Level.INFO, String.format(
                        """
                                ::: Count: %d :::
                                ::: Average: %.2f :::
                                ::: Sum: %.2f :::
                                ::: Max: %.2f :::
                                ::: Min: %.2f :::""",
                        doubleSummaryStatistics.getCount(), doubleSummaryStatistics.getAverage(),
                        doubleSummaryStatistics.getSum(), doubleSummaryStatistics.getMax(),
                        doubleSummaryStatistics.getMin()
                ));

        return doubleSummaryStatistics;
    }

    public static void main(String[] args) {
        DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();

        doubleSummaryStatistics = getStatistics();

        Logger.getGlobal().log(
                Level.INFO, String.format("::: %s ::::", doubleSummaryStatistics.toString())
        );
    }

}
