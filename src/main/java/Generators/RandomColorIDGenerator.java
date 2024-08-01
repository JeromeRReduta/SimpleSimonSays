package Generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public final class RandomColorIDGenerator {

    public static List<Integer> generateColorIDs(int bound, int length) {
        Random random = new Random();
        return Stream.generate(() -> random.nextInt(bound))
                .limit(length)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
