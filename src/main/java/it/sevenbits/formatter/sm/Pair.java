package it.sevenbits.formatter.sm;

import java.util.Objects;

/**
 * A class for storing a pair of elements
 *
 * @param <T> First param in pair
 * @param <U> Second param in pair
 */
public final class Pair<T, U> {

    private final T first;
    private final U second;

    /**
     * Default constructor for pair
     *
     * @param first  first elem in pair
     * @param second second elem in pair
     */

    public Pair(final T first, final U second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
