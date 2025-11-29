package display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import Input.Input;
import game.state.State;

public class Display extends JFrame {

    private Canvas canvas;
    private Renderer renderer;

    public Display(int widht, int height, Input input) {
        setTitle("null");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        this.renderer = new Renderer();

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(widht, height));
        canvas.setFocusable(false);
        add(canvas);
        addKeyListener(input);
        pack();

        canvas.createBufferStrategy(2);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(State state) {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.darkGray);
        graphics.fillRect(0,  0,  canvas.getWidth(),  canvas.getHeight());

        renderer.render(state, graphics);

        graphics.dispose();
        bufferStrategy.show();
    }
}
