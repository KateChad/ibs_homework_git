import java.util.ArrayList;

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
        System.out.println("Содержание коробки с учетом ограничения по весу " + maxWeight + " : ");
        double sumWeigth = 0;
        for (Sweet sweet: boxArray) {
            double weigth = sweet.getWeight();
            sumWeigth += weigth;
        }
        int id = 0;
        while (sumWeigth > maxWeight ) {
            for (int i = 0; (i + 1) < boxArray.size(); i++) {
                if (boxArray.get(i + 1).weight < boxArray.get(i).weight) {
                    id = i+1;
                }
            }
            sumWeigth -= boxArray.get(id).weight;
            boxArray.remove(id);

        }
        for (Sweet sweet: boxArray) {
            sweet.infoSweet();
        }


    }
    @Override
    public void optimizationPrice(double maxPrice) {
        System.out.println("Содержание коробки с учетом ограничения по стоимости " + maxPrice + " : ");
        double sumPrice = 0;
        for (Sweet sweet: boxArray) {
            double price = sweet.getPrice();
            sumPrice += price;
        }
        int id = 0;
        while (sumPrice > maxPrice ) {
            for (int i = 0; (i + 1) < boxArray.size(); i++) {
                if (boxArray.get(i + 1).getPrice() < boxArray.get(i).getPrice()) {
                    id = i+1;
                }
            }
            sumPrice -= boxArray.get(id).price;
            boxArray.remove(id);

        }
        for (Sweet sweet: boxArray) {
            sweet.infoSweet();
        }


    }

}
