
import java.util.*;

class TimeStampedValue {

    public int timeStamp;
    public String value;

    public TimeStampedValue(int timeStamp, String value){
        this.timeStamp = timeStamp;
        this.value = value;
    }
}

class TimeMap {

    Map<String, ArrayList<TimeStampedValue>> entriesMap;

    public TimeMap(){
        entriesMap = new HashMap<>();
    }

    public void set(String key, String value, int timeStamp){

        if(!entriesMap.containsKey(key)){
            entriesMap.put(key, new ArrayList<>());
        }

        ArrayList<TimeStampedValue> timeStampedValues = entriesMap.get(key);
        timeStampedValues.add(new TimeStampedValue(timeStamp, value));
    }

    public String get(String key, int timeStamp){

        if(!entriesMap.containsKey(key)) return "";

        ArrayList<TimeStampedValue> timeStampedValues = entriesMap.get(key);

        Optional<TimeStampedValue> time = binarySearch(timeStampedValues, timeStamp);

        if(!time.isPresent()) return "";

        return time.get().value;
    }

    private Optional<TimeStampedValue> binarySearch(ArrayList<TimeStampedValue> arr, int target){

        int start = 0;
        int end = arr.size()-1;
        int matchIdx = -1;

        while(start<=end){
            int mid = start+(end-start)/2;

            TimeStampedValue curr = arr.get(mid);

            if(target >= curr.timeStamp){
                matchIdx = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        if(matchIdx == -1) return Optional.empty();

        return Optional.of(arr.get(matchIdx));
    }

    public static void main(String[] args) {
        
        TimeMap obj = new TimeMap();

        obj.set("foo", "bar", 1);
        
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));
        
        obj.set("foo", "bar2", 4);
        
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));
    }
}
