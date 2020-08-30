package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        OptionalDouble result = stream.flatMap(pupil -> pupil.getSubjects()
                .stream())
                .mapToInt(Subject::getScore).average();
       return result.isPresent() ? result.getAsDouble() : result.orElse(0);

    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                 pupil.getSubjects()
                         .stream()
                         .mapToInt(Subject::getScore)
                         .average()
                         .getAsDouble())).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
          return stream
                .flatMap(pupil -> pupil
                        .getSubjects()
                        .stream())
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                Collectors.averagingDouble(Subject::getScore)))
                  .entrySet()
                  .stream()
                  .map(k -> new Tuple(k.getKey(), k.getValue())).collect(Collectors.toList());

    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
       return stream.collect(Collectors.groupingBy(Pupil::getName,
                Collectors.summingDouble(p -> p.getSubjects().stream()
                                .mapToDouble(Subject::getScore).sum()
                        )))
               .entrySet()
               .stream()
               .map(k -> new Tuple(k.getKey(), k.getValue()))
               .max((t1, t2) -> Double.compare(t1.getScore(), t2.getScore())).get();

    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(k -> new Tuple(k.getKey(), k.getValue()))
                .max((t1, t2) -> Double.compare(t1.getScore(), t2.getScore())).get();
    }
}
