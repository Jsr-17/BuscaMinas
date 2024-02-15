import java.util.Scanner;

public class Juego implements Tablero {
    Scanner input = new Scanner(System.in);
    public int minas;
    String[][] tablero;
    int x;
    int y;

    @Override
    public void iniciaJuego() {
        boolean valor;
        eligeDificultad();

        do {
             valor=escogePosicion();
            
        } while (!valor);
    }

    public int[] creaNumeroAleatorio(int x, int y) {
        int[] array = new int[2];
        int numeroAleatorioX = (int) (Math.random() * x);
        int numeroAleatorioY = (int) (Math.random() * y);
        array[0] = numeroAleatorioX;
        array[1] = numeroAleatorioY;
        return array;
    }

    @Override
    public void creaTablero(int x, int y) {
        this.tablero = new String[x][y];
        this.x = x;
        this.y = y;

        for (int i = 0; i < minas; i++) {
            int[] array = creaNumeroAleatorio(x, y);

            tablero[array[0]][array[1]] = "mina";
        }

        // for(int i=0;i<x;i++){
        // for(int z=0;z<y;z++){
        // if(tablero[i][z]==null ||tablero[i][z]=="mina" ){
        // System.out.print("["+i+","+z+"]");
        // }
        // }
        // System.out.println("");
        // }
        
    }

    @Override
    public void eligeDificultad() {
        System.out.println("Elija el grado de dificultad : \n -Facil \n-Normal \n -Dificil");
        String txt = input.nextLine();

        switch (txt.toLowerCase()) {
            case "Facil":
            case "facil":
                this.minas = 1;
                creaTablero(2, 2);
                break;
            case "normal":
            case "Normal":
                minas = 12;
                creaTablero(6, 6);
                break;
            case "Dificil":
            case "dificil":
                minas = 25;
                creaTablero(9, 9);
                break;

            default:
                break;
        }

    }

    public boolean escogePosicion() {
        pintaTablero();
        System.out.println("Escoge el primer número  ");
        int posicion1 = input.nextInt();
        System.out.println("Escoge el segundo número  ");
        int posicion2 = input.nextInt();
        boolean resultado=compruebaMina(posicion1, posicion2);

        if (resultado) {
            return true;
        }
        return false;
    }

    public boolean compruebaMina(int posicion, int posicion2) {

        if (tablero[posicion][posicion2] == "mina") {
            System.out.println("Has perdido");
            return true;
        }else{
            tablero[posicion][posicion2]="vacio";
        }
        return false;
    }

    public void pintaTablero() {

        for (int i = 0; i < this.x; i++) {
            for (int z = 0; z < this.y; z++) {
                if (tablero[i][z] == null || tablero[i][z] == "mina") {
                    System.out.print("[" + i + "," + z + "]");
                }else if (tablero[i][z]=="vacio"){
                    System.out.print("[  ]");
                }
            }
            System.out.println("");
        }

    }
}
