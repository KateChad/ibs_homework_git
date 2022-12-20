import java.util.*;

public class Box implements Keepers{
    public Box() {

    }

    ArrayList<Sweet> boxArray = new ArrayList<>();

    @Override
    public void add(Sweet sweet) {
        boxArray.add(sweet);
    }


    @Override
    public void deleteLast() {
        boxArray.remove(boxArray.size() - 1);
    }

    @Override
    public void deleteIndex(int index) {
    boxArray.remove(index);
    }

    @Override
    public void weigth() {
        double sumWeigth = 0;
        for (Sweet sweet: boxArray) {
            double weigth = sweet.getWeight();
            sumWeigth += weigth;
        }
        System.out.println("Вес коробки: " + sumWeigth + " грамм");
    }

    @Override
    public void price() {
        double sumPrice = 0;
        for (Sweet sweet: boxArray) {
            double price = sweet.getPrice();
            sumPrice += price;
        }
        System.out.println("Стоимость коробки: " + sumPrice + " рублей");
    }

    @Override
    public void info() {
        System.out.println("Содержание коробки: ");
       for (Sweet sweet: boxArray) {
           sweet.infoSweet();
       }
    }

    @Override
    public void optimizationWeight(double maxWeight) {
        System.out.println("Содержание коробки с учетом максимального веса " + maxWeight + " : ");
        Collections.sort(boxArray, new Comparator<Sweet>() {
            public int compare(Sweet stock1, Sweet stock2) {
                return ((Double)stock1.getWeight()).compareTo((Double) stock2.getWeight());
            }
        });
        double sumWeightInBox = 0;
        ArrayList<Sweet> boxArrayWeight = new ArrayList<>();
        ListIterator<Sweet> iteratorWeight = boxArray.listIterator(boxArray.size());
        while (iteratorWeight.hasPrevious()) {
            Sweet sweet = iteratorWeight.previous();
            sumWeightInBox += sweet.getWeight();
            if (sumWeightInBox<=maxWeight){
                boxArrayWeight.add(sweet);}

        }
        boxArray = boxArrayWeight;
        for (Sweet sweet: boxArray) {
            sweet.infoSweet();
        }


    }
    @Override
    public void optimizationPrice(double maxPrice) {
        System.out.println("Содержание коробки с учетом максимальной стоимости " + maxPrice + " : ");
        Collections.sort(boxArray, new Comparator<Sweet>() {
            public int compare(Sweet stock1, Sweet stock2) {
                return ((Double)stock1.getPrice()).compareTo((Double) stock2.getPrice());
            }
        });
        double sumPriceInBox = 0;
        ArrayList<Sweet> boxArrayPrice = new ArrayList<>();
        ListIterator<Sweet> iterator = boxArray.listIterator(boxArray.size());
        while (iterator.hasPrevious()) {
           Sweet sweet = iterator.previous();
           sumPriceInBox += sweet.getPrice();
           if (sumPriceInBox<=maxPrice){
           boxArrayPrice.add(sweet);}

        }
        boxArray = boxArrayPrice;
        for (Sweet sweet: boxArray) {
            sweet.infoSweet();
        }


    }

}
