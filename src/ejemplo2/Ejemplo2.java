/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo2;

/**
 *
 * @author Luis Alejandro Castro Contreras
 */
public class Ejemplo2 {

    static int[][] direcciones = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0},
        {1, 1},
        {-1, -1},
        {1, -1},
        {-1, 1}
    };

    public static void main(String[] args) {
        char[][] sopa = {
            {'E', 'S', 'T', 'O'},
            {'S', 'T', 'T', 'M'},
            {'E', 'A', 'S', 'A'},
            {'P', 'R', 'N', 'E'}
        };

        String[] palabras = {"esto", "ese", "pato", "este"};

        for (String palabra : palabras) {
            boolean encontrada = false;
            for (int i = 0; i < sopa.length; i++) {
                for (int j = 0; j < sopa[0].length; j++) {
                    if (buscarPalabra(sopa, palabra.toUpperCase(), i, j)) {
                        encontrada = true;
                        break;
                    }
                }
                if (encontrada) break;
            }
            if (!encontrada) {
                System.out.println("Palabra \"" + palabra + "\" no encontrada.");
            }
        }
    }

    public static boolean buscarPalabra(char[][] sopa, String palabra, int fila, int col) {
        for (int[] dir : direcciones) {
            int f = fila, c = col;
            int k;
            for (k = 0; k < palabra.length(); k++) {
                if (f < 0 || f >= sopa.length || c < 0 || c >= sopa[0].length)
                    break;
                if (sopa[f][c] != palabra.charAt(k))
                    break;
                f += dir[0];
                c += dir[1];
            }
            if (k == palabra.length()) {
                int finFila = fila + (palabra.length() - 1) * dir[0];
                int finCol = col + (palabra.length() - 1) * dir[1];
                System.out.println("Palabra \"" + palabra + "\" encontrada de (" + (fila+1) + "," + (col+1) + ") a (" + (finFila+1) + "," + (finCol+1) + ")");
                return true;
            }
        }
        return false;
    }
    
}
