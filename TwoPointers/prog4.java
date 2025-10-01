class ContainerWithWater {

    private static int maximumArea(int heights[]){

        int maxArea = 0;
        int left = 0;
        int right = heights.length-1;

        while(left<right){

            // area = l * b = (right-left) * min(ht(left), ht(right))
            int area = (right-left) * Math.min(heights[left],heights[right]);

            maxArea = Math.max(maxArea, area);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        
        int heights[] = {1,8,6,2,5,4,8,3,7};

        int result = maximumArea(heights);
        System.out.println(result);
    }
}