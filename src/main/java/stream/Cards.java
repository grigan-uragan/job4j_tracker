package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cards {
    private Suit suit;
    private Value value;

    public Cards(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cards{" + suit + " : " + value + '}';
    }

    public static void main(String[] args) {
        List<Cards> cardsList = new ArrayList<>();
        Stream<Suit> suitStream = Stream.of(Suit.values());
        Stream<Value> valueStream = Stream.of(Value.values());
        for (Suit suit: Suit.values()) {
            for (Value value : Value.values()) {
                cardsList.add(new Cards(suit, value));
            }
        }
        cardsList.forEach(System.out::println);
    }
}
