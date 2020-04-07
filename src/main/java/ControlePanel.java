package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class ControlePanel extends JPanel implements ActionListener{

    private Timer timer;
    private boolean ingame;
    private Personnage personnage;
    private Init initImage;
    private final int B_WIDTH = 700;
    private final int B_HEIGHT = 600;
    private final int caseWidth = 35;
    private final int caseHeight = 30;
    int tab[][];
    private final int DELAY = 50;

    public ControlePanel() {

        initControlePanel();
    }

    private void initControlePanel() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.gray);
        ingame = true;
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        personnage = new Personnage(10,10);

        timer = new Timer(DELAY, this);
        timer.start();

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {

            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        if(personnage.getVictory()){
            drawVictory(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {

        tab = personnage.getTab();
       for(int y=0; y<tab.length;y++){
           for(int x=0; x<tab[y].length;x++){
                initImage = new Init(caseWidth*y,caseHeight*x);
               switch (tab[x][y]){
                   case 1 : initImage.loadImage("src/ressources/glace2.png");
                            initImage.getImageDimensions();                     
                   break;
                   case 2 : initImage.loadImage("src/ressources/glace.png");
                            initImage.getImageDimensions(); 
                   break;
                   case 3 : initImage.loadImage("src/ressources/eau.jpg");
                            initImage.getImageDimensions(); 
                   break;
                   case 4 : initImage.loadImage("src/ressources/pinguin.png");
                            initImage.getImageDimensions(); 
                   break;
               }
               
               g.drawImage(initImage.getImage(), initImage.getX(), initImage.getY(),this);
           }
       }
    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    private void drawVictory(Graphics g) {

        String msg = "Victory";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();
        repaint();


    }

    private void inGame() {
        if (!ingame) {
            timer.stop();
        }
    }
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            personnage.keyPressed(e);
        }
    }
}