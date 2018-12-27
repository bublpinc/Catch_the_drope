package com.cathc_the_drope;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static GameWindow game_window;

    public static void main(String[] args) {
        game_window = new GameWindow(); //создаем объект
        //настраиваем окно
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_window.setLocation(200, 100); //настраиваем точку
        game_window.setSize(906, 478); //настраиваем размер окна
        game_window.setResizable(false); //запрещаем изменение размера окна
        GameField game_field = new GameField(); //создаем объект класса GameField
        game_window.add(game_field); //добавляем объект в окно
        game_window.setVisible(true); //делаем окно видимым

    }

    private static void onRepaint(Graphics g){
        g.fillOval(10, 10, 10, 10); //отрисовываем точку
        g.drawLine(30, 10, 10, 10); //отрисовываем линию
    }

    private static class GameField extends JPanel{

        //переопределяем матод
        @Override
        protected void paintComponent (Graphics g) {
            super.paintComponent(g); //отрисовываем панель
            onRepaint(g); //выполняется метод
        }
    }
}
