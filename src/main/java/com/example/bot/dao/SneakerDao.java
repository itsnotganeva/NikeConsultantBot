package com.example.bot.dao;

import com.example.bot.entity.Sneaker;
import com.example.bot.utils.Emojis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SneakerDao {
    private static final String URL = "jdbc:mysql://localhost:3306/nikebot";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2878899mg";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String show(String name, String price) {
        List<Sneaker> sneakers = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM sneakers WHERE sneakerName LIKE ? AND price <=?");

            preparedStatement.setString(1, "%"+name+"%");
            preparedStatement.setInt(2, Integer.parseInt(price));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Sneaker sneaker = new Sneaker();

                sneaker.setName(resultSet.getString("sneakerName"));
                sneaker.setLink(resultSet.getString("link"));
                sneaker.setPrice(resultSet.getString("price"));

                sneakers.add(sneaker);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<String> output = new ArrayList<>();

        String result = "";

        for (Sneaker sneaker:sneakers) {
            result += sneaker.toString() + "\n";
        }

        if (result == ""){
            return "По вашему запросу ничего не найдено " + Emojis.EYES;
        }
        else return result;
    }

}
