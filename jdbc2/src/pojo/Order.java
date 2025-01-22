package pojo;

public class Order {
    private int id;
    private String name;
    private String time;
    private int price;


    public Order(String name, String time, int price) {
        this.name = name;
        this.time = time;
        this.price = price;
    }

    public Order(int id, String name, String time, int price) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String toString(){return "[订单编号]:"+id+"[商品名称]"+name+" [下单时间]:"+time+" [订单价格]:"+price;
    }

}
