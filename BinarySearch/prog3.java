class KokoEatingBananas {

    private static int findMax(int arr[]){

        int maxVal = Integer.MIN_VALUE;
        for(int i: arr){
            maxVal = Math.max(maxVal, i);
        }

        return maxVal;
    }

    private static int totalHrsAtSpeed(int arr[], int speed){
        int totalH = 0;
        for(int i=0; i<arr.length; i++){
            totalH += Math.ceil((double)(arr[i])/(double)(speed));
        }

        return totalH;
    }

    private static int minEatingSpeed(int arr[], int h){
        int start = 1;
        int end = findMax(arr);

        while(start<=end){

            int mid = (start+end)/2;
            int totalH = totalHrsAtSpeed(arr, mid);

            if(totalH > h){
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }

        return start;
    }
    
    public static void main(String[] args) {
        
        int piles[] = {3,6,7,11};
        int h = 8;

        int ans = minEatingSpeed(piles, h);
        System.out.println(ans);
    }
}
