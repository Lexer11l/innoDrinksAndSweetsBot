package bot.model;

import java.io.Serializable;


public class Product implements Serializable{

    private ProductType productType;
    private float price;
    private int id;
    private int countRemain;
    private String description;
    private String linkToPhoto;

    public Product() {
    }

    public Product(ProductType productType, float price, int id, int countRemain, String description, String linkToPhoto) {
        this.productType = productType;
        this.price = price;
        this.id = id;
        this.countRemain = countRemain;
        this.description = description;
        this.linkToPhoto = linkToPhoto;

    }

    public void setLinkToPhoto(String linkToPhoto) {
        this.linkToPhoto = linkToPhoto;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountRemain(int countRemain) {
        this.countRemain = countRemain;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public int getCountRemain() {
        return countRemain;
    }

    public String getDescription() {
        return description;
    }

    public String getLinkToPhoto() {
        return linkToPhoto;
    }
}
