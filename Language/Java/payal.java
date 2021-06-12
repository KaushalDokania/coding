/*package whatever //do not write package name here */



class Payal {
	public static void main (String[] args) {
	int[] arr= {1,4,2,-2,-9,10,2,12,2,-4,-4,-4,-4,2,6,7};
	int peak = arr[0];
		int index=0;
		
		//System.out.println(arr[0]);
		for(int i=1;i<arr.length-1;i++) {
		    System.out.println("i:" + i + ", peaks:" + peak);
		    if(arr[i]*arr[i-1]>0) {
                System.out.println("i*i-1>0");
    			if(peak<0 && arr[i] <peak) {
    				peak=arr[i];
    				index=i;
    			}
    			if(peak>=0 && arr[i]>peak) {
    				peak= arr[i];
    				index=i;
    			}
			}
			else {
				System.out.println(   index +" "+peak);
				peak=arr[i];
				index=i;
			}
		}
	}
}