
class TrappingRainWater {

    private static int trap1(int height[]){

        int n = height.length;
        int water = 0;

        int prefixMax[] = new int[n];
        prefixMax[0] = height[0];
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        }

        int suffixMax[] = new int[n];
        suffixMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }

        for(int i=0; i<n; i++){
            water = water + Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }
        
        return water;
    }
    

    private static int trap2(int height[]){

        int n = height.length;
        

        int leftMax = 0; 
        int rightMax = 0;
        int water = 0;

        int left = 0;
        int right = n-1;
        while(left < right){

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax){
                
                water = water + (leftMax - height[left]);
                left++;
            
            }else{

                water = water + (rightMax - height[right]);
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        
        int height[] = {4,2,0,3,2,5};

        int ans1 = trap1(height);
        System.out.println(ans1);

        int ans2 = trap2(height);
        System.out.println(ans2);
    }
}
