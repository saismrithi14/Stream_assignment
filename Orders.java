import java.util.*;
public class Orders {
    private int order_id;
    private List<String> order_items;

    public Orders(int order_id, List<String> order_items) {
        this.order_id = order_id;
        this.order_items = order_items;
    }

    public int getOrderId() {
        return this.order_id;
    }

    public void setId(int id) {
        this.order_id = id;
    }

    public List<String> getItems() {
        return this.order_items;
    }

    public void setItems(List<String> items) {
        this.order_items = items;
    }

}
