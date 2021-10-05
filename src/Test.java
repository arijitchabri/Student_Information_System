class Test{

    public static void print(int []arr){
        System.out.println();
        for (int j : arr) {
            System.out.print(j + "   ");
        }
    }

    public static void merge(int []arr, int []left, int []right, int l, int r){
        int i = 0, j = 0, k = 0;
        while(i < l && j < r){
            if(left[i] > right[j]){
                arr[k++] = right[j++];
            }
            else{
                arr[k++] = left[i++];
            }
        }
        while(i < l){
            arr[k++] = left[i++];
        }
        while(j < r){
            arr[k++] = right[j++];
        }

    }

    public static void sort(int []arr){
        int len = arr.length;
        if (len < 2){
            return;
        }
        int mid = (len+1)/2;
        int []left = new int[mid];
        int []right = new int[len-mid];
        try{
            for (int i = 0; i <= mid; i++){
                left[i] = arr[i];
                right[i] = arr[i+mid];
            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }
        sort(left);
        sort(right);
        merge(arr, left, right, mid, len-mid);
    }



    public static void main(String[] args) {
        int n = 23;
        String s = "";
        s = s.format("%" + (-20) + "s", "Arijit");
        System.out.println(s + n);
        s = s.format("%" + (-20) + "s", "Arijit Chabri");
        System.out.println(s + n);


    }

}
