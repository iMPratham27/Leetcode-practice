class Search2DMatrix {

    private static boolean searchMatrix(int target, int matrix[][]){

        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = (rows*cols)-1;
        while(start <= end){

            int mid = start+(end-start)/2;

            int midValue = matrix[mid/cols][mid%cols];

            if(target == midValue) return true;

            if(target > midValue){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        
        int matrix[][] = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };

        int target = 30;

        boolean ans = searchMatrix(target, matrix);
        System.out.println(ans);
    }
}
