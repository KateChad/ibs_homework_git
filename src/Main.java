import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        Chocolates mars = new Chocolates("марс", 35 , 24.0, "батончик");
        Marmalade flaf = new Marmalade("флаф", 40.0, 35.4, "черная смородина");
        Candies ozera = new Candies("озера", 125.0, 15.5, "со сгущенкой");
        Lolipops mix = new Lolipops("микс", 5.0, 12, "яблоко");

        System.out.println("Сколько шоколадок добавить?");
        System.out.println("(Введите число от 0 до 3)");
        Scanner sc = new Scanner(System.in);
        int amountChocolates = sc.nextInt();
        switch (amountChocolates){
            case 0:
                break;
            case 1:
                box.add(mars);
                break;
            case 2:
                box.add(mars);
                box.add(mars);
                break;
            case 3:
                box.add(mars);
                box.add(mars);
                box.add(mars);
                break;
        }

        System.out.println("Сколько мармелада добавить?");
        System.out.println("(Введите число от 0 до 3)");
        Scanner sc1 = new Scanner(System.in);
        int amountMarmelad = sc1.nextInt();
        switch (amountMarmelad){
            case 0:
                break;
            case 1:
                box.add(flaf);
                break;
            case 2:
                box.add(flaf);
                box.add(flaf);
                break;
            case 3:
                box.add(flaf);
                box.add(flaf);
                box.add(flaf);
                break;
        }

        System.out.println("Сколько лединцов добавить?");
        System.out.println("(Введите число от 0 до 3)");
        Scanner sc2 = new Scanner(System.in);
        int amountLolipop = sc2.nextInt();
        switch (amountLolipop){
            case 0:
                break;
            case 1:
                box.add(mix);
                break;
            case 2:
                box.add(mix);
                box.add(mix);
                break;
            case 3:
                box.add(mix);
                box.add(mix);
                box.add(mix);
                break;
        }

        System.out.println("Сколько упоковок конфет добавить?");
        System.out.println("(Введите число от 0 до 3)");
        Scanner sc3 = new Scanner(System.in);
        int amountCandies = sc3.nextInt();
        switch (amountCandies){
            case 0:
                break;
            case 1:
                box.add(ozera);
                break;
            case 2:
                box.add(ozera);
                box.add(ozera);
                break;
            case 3:
                box.add(ozera);
                box.add(ozera);
                box.add(ozera);
                break;
        }

while (true) {
    System.out.println("Хотите использовать доп функцию: удалить последний, удалить по индексу, узнать вес, узнать цену, узнать содержание коробки, оптимизация по весу, оптимизация по стоимости");
    System.out.println("(Введите: нет / удалить последний / удалить по индексу / вес / цена / узнать содержание коробки / оптимизация по весу / оптимизация по стоимости)");
    Scanner sc4 = new Scanner(System.in);
    String comands = sc4.nextLine();
    switch (comands) {
        case "нет":
            break;
        case "удалить последний":
            box.deleteLast();
            System.out.println("Последний элимент удален");
            break;
        case "удалить по индексу":
            System.out.println("Введите индекс");
            Scanner sc5 = new Scanner(System.in);
            int ind = sc5.nextInt();
            box.deleteIndex(ind);
            System.out.println("Элимент с индексом " + ind + " удален");
            break;
        case "вес":
            box.weigth();
            break;
        case "цена":
            box.price();
            break;
        case "узнать содержание коробки":
            box.info();
            break;
        case "оптимизация по весу":
            System.out.println("Введите максимальный вес");
            Scanner sc6 = new Scanner(System.in);
            double maxWeight = sc6.nextDouble();
            box.optimizationWeight(maxWeight);
            break;
        case "оптимизация по стоимости":
            System.out.println("Введите максимальную стоимость");
            Scanner sc7 = new Scanner(System.in);
            double maxPrice = sc7.nextDouble();
            box.optimizationPrice(maxPrice);
            break;
    }
}





    }
}