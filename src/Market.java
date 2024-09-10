import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour{

    private List<Actor> queue = new ArrayList<>();

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " зашёл в магазин.");
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actorsList) {
        for (Actor actor : actorsList) {
            System.out.println(actor.getName() + " вышел из магазина");
        }
        actorsList.clear();
    }

    public void releaseFromMarket(Actor actor) {
            System.out.println(actor.getName() + " вышел из магазина");
    }

    @Override
    public void update() {
        System.out.println("Обновление состояние магазина");
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " встал в очередь");
        queue.add(actor);
    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (!actor.isTakeOrder()) {
                System.out.println(actor.getName() + " сделал заказ.");
                actor.setTakeOrder(true);
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            if (actor.isTakeOrder() && !actor.isMakeOrder()) {
                System.out.println(actor.getName() + " получил заказ.");
                actor.setMakeOrder(true);
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> servedActors = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                System.out.println(actor.getName() + " вышел из очереди.");
                servedActors.add(actor);  // Добавляем покупателя в список на удаление
            }
        }
        queue.removeAll(servedActors);
    }

    public void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста.");
        } else {
            System.out.println("Текущая очередь: ");
            for (Actor actor : queue) {
                System.out.println(actor);
            }
        }
    }

}
