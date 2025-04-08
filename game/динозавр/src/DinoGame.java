import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class DinoGame extends JPanel implements ActionListener {
    private Timer timer;
    private boolean isJumping = false;
    private int jumpHeight = 0;
    private int score = 0;
    private ArrayList<Integer> obstacles = new ArrayList<>();
    private Random random = new Random();

    public DinoGame() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 400));
        timer = new Timer(20, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE && !isJumping) {
                    isJumping = true;
                }
            }
        });
        setFocusable(true);
        spawnObstacle();
    }

    private void spawnObstacle() {
        Timer spawnTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int obstacleHeight = random.nextInt(50) + 20;
                obstacles.add(800);  // Изначальная позиция препятствия
            }
        });
        spawnTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(50, 300 - jumpHeight, 20, 20);  // Динозаврик

        g.setColor(Color.RED);
        for (Integer obstacleX : obstacles) {
            g.fillRect(obstacleX, 280, 20, random.nextInt(50) + 20);  // Препятствия
        }

        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isJumping) {
            if (jumpHeight < 60) {
                jumpHeight += 5;
            } else {
                isJumping = false;
            }
        } else {
            if (jumpHeight > 0) {
                jumpHeight -= 5;
            }
        }

        for (int i = 0; i < obstacles.size(); i++) {
            int obstacleX = obstacles.get(i);
            obstacleX -= 5;  // Двигаем препятствия влево
            if (obstacleX < 0) {
                obstacles.remove(i);
                score++;
                i--;
            } else {
                obstacles.set(i, obstacleX);
            }
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dino Game");
        DinoGame game = new DinoGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}