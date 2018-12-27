package com.cathc_the_drope;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame {

    private static GameWindow game_window;
    private static long last_frame_time;
    private static Image background;
    private static Image drop;
    private static Image game_over;
    private static float drop_left = 200;//координата Х
    private static float drop_top = -100; //координата Y
    private static float drop_v = 200;

    public static void main(String[] args) throws IOException {
        //загружаем картинки
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        game_window = new GameWindow(); //создаем объект
        //настраиваем окно
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_window.setLocation(200, 100); //настраиваем точку
        game_window.setSize(906, 478); //настраиваем размер окна
        game_window.setResizable(false); //запрещаем изменение размера окна
        last_frame_time = System.nanoTime(); //фиксированное время в предыдущем кадре
        GameField game_field = new GameField(); //создаем объект класса GameField
        game_window.add(game_field); //добавляем объект в окно
        game_window.setVisible(true); //делаем окно видимым

    }

    private static void onRepaint(Graphics g){
        long current_time = System.nanoTime(); //фиксирует текущее время
        float delta_time = (current_time - last_frame_time)*0.000000001f;
        last_frame_time = current_time;

        drop_top = drop_top + drop_v * delta_time; //скоррость падения капли
        //отрисовываем фон, точку и надпись
        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, (int) drop_left, (int) drop_top, null);
      //  g.drawImage(game_over,280,120, null);
    }

    private static class GameField extends JPanel{

        //переопределяем матод
        @Override
        protected void paintComponent (Graphics g) {
            super.paintComponent(g); //отрисовываем панель
            onRepaint(g); //выполняется метод
            repaint();
        }
    }
}
