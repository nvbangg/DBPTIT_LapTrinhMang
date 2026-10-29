package UDP;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 20161107L;

    public String id;
    public String code;
    public String name;
    public int quantity;

    public Product(String id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
}

