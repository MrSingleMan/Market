import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Human alex = new Human("Alex");
        Human serg = new Human("Sergey");

        market.acceptToMarket(alex);
        market.acceptToMarket(serg);

        market.showQueue();
        market.update();
        market.update();

        market.showQueue();

        market.releaseFromMarket(alex);
        market.releaseFromMarket(serg);

    }
}
