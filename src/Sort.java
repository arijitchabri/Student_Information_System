class Sort{

    public static void merge(int []arr, int []left, int []right, int l, int r, String []arr2, String []left2, String []right2){
        int i = 0, j = 0, k = 0;
        while(i < l && j < r){
            if(left[i] > right[j]){
                arr[k] = right[j];
                arr2[k++] = right2[j++];
            }
            else{
                arr[k] = left[i];
                arr2[k++] = left2[i++];
            }
        }
        while(i < l){
            arr[k] = left[i];
            arr2[k++] = left2[i++];
        }
        while(j < r){
            arr[k] = right[j];
            arr2[k++] = right2[j++];
        }

    }

    public static void sort(int []arr, String []arr2){
        int len = arr.length;
        if (len < 2){
            return;
        }
        int mid = (len+1)/2;
        int []left = new int[mid];
        int []right = new int[len-mid];
        String []left2 = new String[mid];
        String []right2 = new String[len-mid];
        try{
            for (int i = 0; i <= mid; i++){
                left[i] = arr[i];
                right[i] = arr[i+mid];

                left2[i] = arr2[i];
                right2[i] = arr2[i+mid];

            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }
        sort(left, left2);
        sort(right, right2);
        merge(arr, left, right, mid, len-mid, arr2, left2, right2);
    }

}