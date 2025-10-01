
class MedianOfSortedArrays {

    private static int[] mergeArr(int nums1[], int nums2[]){

        int result[] = new int[nums1.length+nums2.length];

        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                result[k] = nums1[i];
                i++;
            }else{
                result[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i<nums1.length){
            result[k] = nums1[i];
            i++;
            k++;
        }

        while(j<nums2.length){
            result[k] = nums2[j];
            j++;
            k++;
        }

        return result;
    }

    private static double getMedian(int nums[]){

        int n = nums.length;

        if(n%2 == 1){
            return nums[n/2];
        }else{
            int med1 = nums[(n/2)-1];
            int med2 = nums[n/2];

            return (med1+med2)/2.0;
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){

        double median = getMedian(mergeArr(nums1, nums2));

        return median;
    }
    
    public static void main(String[] args) {
        
        int nums1[] = {1,2};
        int nums2[] = {3,4};

        double ans = findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }
}
