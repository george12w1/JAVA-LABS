public class Restaurant extends Node implements Payable {
    public void setPrice(int price){
        this.price=price;

    }
    Restaurant(String name,int price){
        this.name=name;
        setPrice(price);

    }



}
