package com.example.bot.entity;

import com.example.bot.utils.Emojis;

public class Sneaker {
    private int id;
    private String name;
    private String link;
    private String price;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Sneaker(int id, String name, String link, String price) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.price = price;
    }

    public Sneaker() {}

    @Override
    public String toString() {
        return name + " " + Emojis.SNEAKERS + "\n" +
                "$" + price + " " + Emojis.MONEY + "\n" +
                link + " " + Emojis.TROLLEY + "\n\n";
    }
}
