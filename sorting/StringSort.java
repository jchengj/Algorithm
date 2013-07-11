
public class StringSort {
	
	public static int charAt(String s, int d){
		if(s.length() <= d){
			return -1;
		}else{
			return s.charAt(d);
		}
	}
	
	public static void swap(String[] list, int i , int j){
		String tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}
	
	public static void QuickSort3Way(String[] list, int lo, int hi, int d){
		if(hi >= lo){ return; }
		
		int value = charAt(list[lo],d);
		int lt = lo;
		int gt = hi;
		int i = lo+1;
		
		
		while(i <= hi){
			int current = charAt(list[i],d);
			if(current < value){
				swap(list, i++, lt++);
			}else if(current > value){
				swap(list, i, gt--);
			}else{
				i++;
			}
		}
		
		QuickSort3Way(list, lo, lt-1, d);
		QuickSort3Way(list, lt, gt, d+1);
		QuickSort3Way(list, gt+1, hi, d);
	}
}
