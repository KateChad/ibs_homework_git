import java.util.Objects;

public interface Keepers {
    void add(Sweet sweet);
    void deleteLast();
    void deleteIndex(int index);
    void weigth();
    void price();
    void info();
    void optimizationWeight(double maxWeight);
    void optimizationPrice(double maxPrice);
}
