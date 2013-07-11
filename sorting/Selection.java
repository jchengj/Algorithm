import java.util.Arrays;


public class Selection {
	
	public static void selectionSort(Comparable[] list){
		for(int i = 0; i < list.length; i++){
			int min = i;
			for(int j=i+1; j < list.length; j++){
				if(list[j].compareTo(list[min]) < 0){
					min = j;
				}
			}
			swap(list, i, min);
		}
	}
	
	public static void swap(Comparable[] list, int i, int j){
		Comparable a = list[i];
		list[i] = list[j];
		list[j] = a;
	}
	
	public static void insertionSort(Comparable[] list){
		int h = 1;
		while(h*3+1 < list.length) h = h*3+1;
		
		while(h >= 1){
			for(int i = 1; i < list.length; i+=h){
				Comparable tmp = list[i];
				int j = i;
				while(j-h >= 0 && list[j-h].compareTo(tmp) > 0){
					list[j] = list[j-h];
					j-=h;
				}
				list[j] = tmp; 
			}
			h /= 3;
		}
	}
	
	public static void main(String[] args) {
		Integer[] list = {4,5,29,34,57,22,12,9,2347,38,212,87,20,34,77,63,190};
		System.out.println(Arrays.toString(list));
		
		insertionSort(list);
		
		System.out.println(Arrays.toString(list));		
	}
}
