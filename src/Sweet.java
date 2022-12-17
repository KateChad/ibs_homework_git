 abstract class Sweet {
     String name;
     double weight;
     double price;
     String parameter;

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public void infoSweet(){
        System.out.println(name + " " + weight + " грамм " + price + " рублей " + parameter);
    }


}
