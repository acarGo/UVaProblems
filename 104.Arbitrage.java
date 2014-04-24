import java.util.Scanner;

/**
 * @author Adrian Carenas (acar_go) 
 * UVa Problem 104
 */
public class Main {

	private static Scanner in;
	private double[][][] multiplicaciones;
	private int[][][] ruta;
	
	public void process() {
		int nDim = 0;
		while (in.hasNext()) {
			nDim = in.nextInt();
			multiplicaciones = new double[nDim][nDim][nDim+1]; // +1 por que no modificamos la posicion original (l=0) por lo tanto en la ultima sale del rango
			ruta = new int[nDim][nDim][nDim+1];
			
			for (int i = 0; i < nDim; i++) {
				for (int j = 0; j < nDim; j++) {
					if (i != j)
						multiplicaciones[i][j][0] = in.nextDouble();
					else
						multiplicaciones[i][j][0] = 1;
					ruta[i][j][0] = i+1; // Matriz para las rutas, en vez de almacenar
					// los valores, almacenamos el numero de
					// moneda (para la ruta) ["Inicilizacion como el algoritmo FW"]
				}
			}

			double maxValor;
			int l = 1;
			boolean ventaja = false;
			int q; //indice para diagonal. MONEDA.
			while(l <= nDim && !ventaja){
				for (int k = 0; k < nDim; k++){
					for (int i = 0; i < nDim; i++){
						for (int j = 0; j < nDim; j++) {
							maxValor = multiplicaciones[i][k][l - 1] * multiplicaciones[k][j][0];
							// Multiplicamos valor original por el resultado de la multiplicacion hecha un paso anterior
							if(maxValor > multiplicaciones[i][j][l]){
								ruta[i][j][l] = k; // asignamos el
								// numero de moneda que hemos multiplicado para seguir la ruta
								multiplicaciones[i][j][l] = maxValor; //el resultado es el nuevo valor hasta el momento (este es el que comprobaremos si es mayor que 1.0 si est� en la diagonal)
							}
						}
					}
				}
				q = 0;
				while(q < nDim && !ventaja){
					if (multiplicaciones[q][q][l] > 1.01) { //Diagonal se encuentra el total de las conversiones, en un paso.
						//1.01 esto tuve que buscarlo, con > 1.0 no funciona para algun determinado caso de prueba. Parece ser errores de comparacion de decimales
						ventaja = true;
						mostrarRuta(q,q,l); //Desde una moneda a la misma moneda
					}
					q++;
				}
				l++;
			}
			if(!ventaja)
				System.out.println("no arbitrage sequence exists");
		}
	}
	
	//Mismo funcionamiento que obtener ruta de Floyd Warshall. (Modificacion de mirar cada posicion que contiene los resultados de las multiplicaciones)
	private void mostrarRuta(int i, int j, int l) {
		String track = Integer.toString(j+1);
		int ant = j;
		while (l != 0) {
			ant = ruta[i][ant][l--];
			track = ant+1 + " " + track;
		}
		track = i+1 + " " + track;
		System.out.println(track);
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
