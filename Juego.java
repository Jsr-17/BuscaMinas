import java.util.Scanner;

public class Juego implements Tablero {
    Scanner input = new Scanner(System.in);
    public int minas;

    public int[] creaNumeroAleatorio(int x, int y){
        int[] array= new int[2]; 
        int numeroAleatorioX=(int)(Math.random()*x);
        int numeroAleatorioY=(int)(Math.random()*y);
        array[0]=numeroAleatorioX;
        array[1]=numeroAleatorioY;
        return  array;
    }

    @Override
    public void creaTablero(int x, int y) {
        String[][] tablero= new String[x][y];

        for(int i=0;i<minas;i++){
           int[] array= creaNumeroAleatorio(x, y);
           System.out.println(array[i]);
           
           /*tablero[array[0]][array[1]]="Pito";*/
        }

        for(int i=0;i<x;i++){
            for(int z=0;z<y;z++){
                System.out.print(tablero[i][z]+" ");
            }
            System.out.println("");
        }
    }

    @Override
    public void eligeDificultad() {
        System.out.println("Elija el grado de dificultad : \n -Facil \n-Normal \n -Dificil");
        String txt= input.nextLine();

        switch (txt.toLowerCase()) {
            case "Facil":
            case "facil":
                creaTablero(4, 4);
                minas=4;
            break;
            case "normal":
            case "Normal":
            creaTablero(8, 8);
                minas=12;
            break;
            case "Dificil":
            case "dificil":
            creaTablero(14, 14);
                minas=65;
            break;

            default:
                break;
        }
        
    }
    
}
