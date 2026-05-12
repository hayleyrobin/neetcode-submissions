class DynamicArray {
    int[] arr;
    int capacity;
    int length;
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0; 
        arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    //[4,6,5,7,8] len=5 capcity=5
    public void pushback(int n) {
        if(length == capacity){ // if 5 = 5 if full
            this.resize();
        }
        arr[length] = n;
        length++;
        
    }

    public int popback() {
        length--;
        return arr[length];

    }

    private void resize() {
        capacity = capacity *2;
        int[] tempArray = new int[capacity];
        for( int i=0; i<length;i++){
            tempArray[i] = arr[i];
        }
        arr = tempArray;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
