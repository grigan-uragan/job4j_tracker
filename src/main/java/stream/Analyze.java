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
        Map<String, Double> res = stream
                .flatMap(pupil -> pupil
                        .getSubjects()
                        .stream())
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                Collectors.averagingDouble(Subject::getScore)));
        List<Tuple> result = new ArrayList<>();
        for (Map.Entry<String, Double> entry : res.entrySet()) {
            result.add(new Tuple(entry.getKey(), entry.getValue()));
        }
        return result;
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
       Map<String, Double> res = stream.collect(Collectors.groupingBy(Pupil::getName,
                Collectors.summingDouble(p -> p.getSubjects().stream()
                                .mapToDouble(Subject::getScore).sum()
                        )));
       Double max = res.values().stream().max(Double::compareTo).get();
       for (Map.Entry<String, Double> entry : res.entrySet()) {
           if (entry.getValue().equals(max)) {
               return new Tuple(entry.getKey(), entry.getValue());
           }
       }
       return null;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> res = stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)));
        double max = res.values().stream().max(Double::compareTo).get();
        for (Map.Entry<String, Double> entry : res.entrySet()) {
            if (entry.getValue() == max) {
                return new Tuple(entry.getKey(), entry.getValue());
            }
        }
        return null;
    }
}
