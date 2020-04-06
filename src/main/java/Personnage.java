package main.java;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Personnage extends Init {

    private int positionX;
    private int positionY;
    private int[][] tab;

    public Personnage(int positionX, int positionY) {
        super(positionX, positionY);

        initPerso();
    }

    public static int[][] newTable() {
        int tab[][] = {{1,1,1,1,1,1,1,1,1,1},
                {1,4,2,2,2,2,2,2,2,1},
                {1,2,1,1,1,1,1,1,2,1},
                {1,2,1,1,1,1,1,1,2,1},
                {1,2,1,1,1,1,1,1,2,1},
                {1,2,1,1,1,1,1,1,2,1},
                {1,2,1,1,1,1,1,1,2,1},
                {1,2,1,1,1,1,1,1,2,1},
                {1,2,2,2,2,2,2,2,2,1},
                {1,1,1,1,1,1,1,1,1,1}};

        return tab;
    }

    private void initPerso() {
        loadImage("src/ressources/vaisseau.png"); //charge l'image depuis les ressources
        getImageDimensions(); // récupère les dimensions de l'image
        tab = newTable();

        for(int y=0;y <= tab.length - 1;y++){
            for(int x=0;x <= tab[y].length - 1;x++){
                if(tab[y][x] = 4){
                    positionX = x;
                    positionY = y;
                    break;
                }
            }
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        // set un changement de valeur sur l'apuie d'une touche de direction en lien directe avec la manière de bouger en x et y
        if (key == KeyEvent.VK_LEFT) {
            while(tab[positionY][positionX-1] != 1){
                tab[positionY][positionX] = 3;
                tab[positionY][positionX-1] = 4;
                positionY = positionY-1;
            }
        }

        if (key == KeyEvent.VK_RIGHT) {
            while(tab[positionY][positionX+1] != 1){
                tab[positionY][positionX] = 3;
                tab[positionY][positionX+1] = 4;
                positionY = positionY+1;
            }
        }

        if (key == KeyEvent.VK_UP) {
            while(tab[positionY-1][positionX] != 1){
                tab[positionY][positionX] = 3;
                tab[positionY-1][positionX] = 4;
                positionY = positionY-1;
            }
        }

        if (key == KeyEvent.VK_DOWN) {
            while(tab[positionY+1][positionX] != 1){
                tab[positionY][positionX] = 3;
                tab[positionY+1][positionX] = 4;
                positionY = positionY+1;
            }
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

    }
}