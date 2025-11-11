package OOPS.Inheritance;

public class BoxPrice extends  Base{
    double cost;
    BoxPrice (){
        super();
        this.cost =-1;
        System.out.println(cost);
    }
    BoxPrice (BoxPrice other) {
        super(other);
        this.cost = other.cost;
    }
}
