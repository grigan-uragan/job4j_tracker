package stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TourCompany {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                        .map(Profile::getAddress)
                        .sorted(Comparator.comparing(Address::getCity))
                        .distinct()
                        .collect(Collectors.toList());
    }
}
