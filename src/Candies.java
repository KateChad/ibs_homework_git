public class Candies extends Sweet{

        public Candies(String name, double weigth, double price, String parameter) {
            this.name = name;
            this.price = price;
            this.weight = weigth;
            this.parameter = parameter;
    }
    public Candies(String name, double weigth, double price) {
        this.name = name;
        this.price = price;
        this.weight = weigth;
    }
}
