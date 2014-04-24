/* Adrián Carenas */

import java.util.Scanner;

public class Main {
	private static Scanner in;
	private Nodo store[];

	public void input() {
		while (in.hasNext()) {
			int nBoxes = in.nextInt();
			int nDim = in.nextInt();
			store = (Nodo[]) new Nodo[nBoxes];
			for (int i = 0; i < nBoxes; i++) {
				store[i] = new Nodo(i+1,nDim); //Asignar numero de caja
				for (int j = 0; j < nDim; j++) {
					store[i].dims[j] = in.nextInt();
				}
			}
			
			in.nextLine();
			
			sortDims(nBoxes); //Ordenar dimensiones
			
			sortBoxes(nBoxes); //Ordenar cajas según dimensiones para LIS.
			
			String[] track = new String[nBoxes];
			//LIS
			int[] trackMax = new int[nBoxes];
			//Inicializar maximos cajas
			for(int i = 0; i < nBoxes; i++){
				trackMax[i] = -1;
			}
			int max;
			for(int i = 0; i < nBoxes; i++){
				max = 0;
				track[i] = Integer.toString(store[i].id);
//				System.out.println(store[i].id + " " + "id: " + i);
				for(int j = 0; j < i; j++){
					if(isNested(store[i], store[j])){
						if(trackMax[j] > max){
							max = trackMax[j];
//							System.out.println("id: " + store[j].id);
							track[i] = track[j] + " " + store[i].id; //track[j] vertices acumulados hasta ese nodo (más largo)
//							System.out.println(track[i]);
						}
					}
				}
				trackMax[i] = max + 1;
			}
			//seleccionar el máximo entre todos.
			max = 0;
			int boxStart = 0;
			for(int i = 0; i < nBoxes; i++){
				if(trackMax[i] > max){
					max = trackMax[i];
					boxStart = i;
				}
			}
			System.out.println(max);
			System.out.println(track[boxStart]);
		}
	}

	private void sortBoxes(int nBoxes) {
		int min;
		for(int i= 0; i < nBoxes - 1; i++){
			min = i;
			for(int j = i+1; j < nBoxes; j++)
				if(lessThan(store[j],store[min])){
					min = j;
				}
			Nodo aux = store[i];
			store[i] = store[min];
			store[min] = aux;
		}
		//TODO Modificar Mergesort a T para reutilizar codigo
	}

	private boolean isNested(Nodo one, Nodo two) {
		int i = 0;
		while(i < one.dims.length){
			if (one.dims[i] > two.dims[i]){
				i++;
			}else if (one.dims[i] < two.dims[i]){
				return false;
			}else
				return false;
		}
		return true;
	}
	
	private boolean lessThan(Nodo one, Nodo two) {
		int i = 0;
		while(i < one.dims.length){
			if (one.dims[i] < two.dims[i]){
				return true;
			}else if (one.dims[i] > two.dims[i]){
				return false;
			}else
				i++;
		}
		return false;
	}

	private void sortDims(int numBoxes) {
		Mergesort sort = new Mergesort();
		for (int i = 0; i < numBoxes; i++) {
			sort.sort(store[i].dims);
		}
	}
	
	/////////////////////
	public class Mergesort {
		private int[] numbers;
		private int[] helper;

		private int number;

		public void sort(int[] values) {
			this.numbers = values;
			number = values.length;
			this.helper = new int[number];
			mergesort(0, number - 1);
		}

		private void mergesort(int low, int high) {
			// check if low is smaller then high, if not then the array is
			// sorted
			if (low < high) {
				// Get the index of the element which is in the middle
				int middle = low + (high - low) / 2;
				// Sort the left side of the array
				mergesort(low, middle);
				// Sort the right side of the array
				mergesort(middle + 1, high);
				// Combine them both
				merge(low, middle, high);
			}
		}

		private void merge(int low, int middle, int high) {

			// Copy both parts into the helper array
			for (int i = low; i <= high; i++) {
				helper[i] = numbers[i];
			}

			int i = low;
			int j = middle + 1;
			int k = low;
			// Copy the smallest values from either the left or the right side
			// back
			// to the original array
			while (i <= middle && j <= high) {
				if (helper[i] <= helper[j]) {
					numbers[k] = helper[i];
					i++;
				} else {
					numbers[k] = helper[j];
					j++;
				}
				k++;
			}
			// Copy the rest of the left side of the array into the target array
			while (i <= middle) {
				numbers[k] = helper[i];
				k++;
				i++;
			}

		}
	}

	////////////////
	
	public class Nodo{
		int id;
		int[] dims;
		
		public Nodo(int pId, int size){
			this.id = pId;
			this.dims = new int[size];
		}
	}
	
	///////////////
	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().input();
		in.close();
	}
}
