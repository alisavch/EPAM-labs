package model;

public class ProductInfo implements Comparable<ProductInfo> {
    public String name;
    public String title;
    public String colour;
    public String size;
    public String price;
    public String count;

    public ProductInfo(String name, String title, String colour,
                       String size, String price, String count) {
        this.name = name;
        this.title = title;
        this.colour = colour;
        this.size = size;
        this.price = price;
        this.count = count;
    }

    public int compareTo(ProductInfo object) {
        if(name.compareTo(object.name) == 0 &&
            title.compareTo(object.title) == 0 &&
            colour.compareTo(object.colour) == 0 &&
            size.compareTo(object.size) == 0 &&
            price.compareTo(object.price) == 0 &&
            count.compareTo(object.count)==0)
            return 0;
        if(name.compareTo(object.name) > 0 )
            return 1;
        if(title.compareTo(object.title) > 0 )
            return 1;
        if(colour.compareTo(object.colour) > 0 )
            return 1;
        if(size.compareTo(object.size) > 0 )
            return 1;
        if(price.compareTo(object.price) > 0 )
            return 1;
        if(count.compareTo(object.count) > 0 )
            return 1;
        return -1;
    }

}
