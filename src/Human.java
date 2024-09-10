public class Human extends Actor{

    public Human(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setMakeOrder(boolean makeOrder) {   //setReceivedOrder
        super.isMakeOrder = makeOrder;
    }

    @Override
    public void setTakeOrder(boolean takeOrder) {   //setOrder
        super.isTakeOrder = takeOrder;
    }

    @Override
    public boolean isMakeOrder() {      //hasReceivedOrder
        return super.isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {  //hasOrder
        return super.isTakeOrder;
    }

    @Override
    public String toString() {
        return "Имя= " + name;
    }
}
