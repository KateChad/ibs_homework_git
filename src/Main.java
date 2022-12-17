import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        Chocolates mars = new Chocolates("����", 35 , 24.0, "��������");
        Marmalade flaf = new Marmalade("����", 40.0, 35.4, "������ ���������");
        Candies ozera = new Candies("�����", 125.0, 15.5, "�� ���������");
        Lolipops mix = new Lolipops("����", 5.0, 12, "����");

        System.out.println("������� �������� ��������?");
        System.out.println("(������� �������� �� 0 �� 3)");
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

        System.out.println("������� �������� ���������?");
        System.out.println("(������� �������� �� 0 �� 3)");
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

        System.out.println("������� �������� ��������?");
        System.out.println("(������� �������� �� 0 �� 3)");
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

        System.out.println("������� �������� �������� ������?");
        System.out.println("(������� �������� �� 0 �� 3)");
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
    System.out.println("������ ��������� �������������� �������: �������� ��������, ������ ���, ������ ���������, ����������� �� ����, ����������� �� ���������");
    System.out.println("(�������: ���/ �������/ ������� �� �������/ ���/ ���������/ ���������� � ���������� �������/  ����������� �� ���� / ����������� �� ���������)");
    Scanner sc4 = new Scanner(System.in);
    String comands = sc4.nextLine();
    switch (comands) {
        case "���":
            break;
        case "�������":
            box.deleteLast();
            System.out.println("��������� ����������� ����� ������");
            break;
        case "������� �� �������":
            System.out.println("������� ������");
            Scanner sc5 = new Scanner(System.in);
            int ind = sc5.nextInt();
            box.deleteIndex(ind);
            System.out.println("����� � �������� " + ind + " ������");
            break;
        case "���":
            box.weigth();
            break;
        case "���������":
            box.price();
            break;
        case "���������� � ���������� �������":
            box.info();
            break;
        case "����������� �� ����":
            System.out.println("������� ������������ ���");
            Scanner sc6 = new Scanner(System.in);
            double maxWeight = sc6.nextDouble();
            box.optimizationWeight(maxWeight);
            break;
        case "����������� �� ���������":
            System.out.println("������� ������������ ���������");
            Scanner sc7 = new Scanner(System.in);
            double maxPrice = sc7.nextDouble();
            box.optimizationPrice(maxPrice);
            break;
    }
}





    }
}