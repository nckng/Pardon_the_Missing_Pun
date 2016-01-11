/*
Team No Spoon -- Nicholas Ng, Adam McKoy
APCS pd10
HW55 -- Don't Think You Are. Know You Are.
2015-01-06
*/

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
        Categorize runtime of each. 
        Test in your main method.
  ====================================*/ 

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;
    private int _size;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix( ) {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
	_size = DEFAULT_SIZE;
    }//O(1)


    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	matrix = new Object[a][a];
	_size = a;
    }//O(1)


    //return size of this matrix, where size is 1 dimension
    private int size() {
	return _size;
    }//O(1)


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];
    }//O(1)


    //return true if this index is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return (matrix[r][c] == null);
    }//O(1)


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object a = matrix[r][c];
	matrix[r][c] = newVal;
	return a;
    }//O(1)


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String thing = "";
	for (int i = 0; i < _size; i++){
	    for (int r = 0; r < _size; r++){
		thing += matrix[i][r]+" ";
	    }
	    thing+="\n";
	}
	return thing;
    }//O(n^2)


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
   public boolean equals( Object rightSide ) {
    	Matrix m = (Matrix)rightSide;
    	if (_size != m.size()) {
    		return false;
    	}
    	for (int i = 0; i < _size;i++) {
	    for (int r = 0; r < _size;r++) {
		if (isEmpty(i,r) ^ m.isEmpty(i,r)) {
		    return false;
		}
		if ((! isEmpty(i,r)) && (! m.isEmpty(i,r))) {
		    if (!(matrix[i][r].equals(m.get(i,r)))){
			return false;
		    }
		}
	    }
	}
    	return true;
   }//O(n^2)
    

    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	Object[] jim = new Object[_size];
	for(int i = 0; i < _size; i++){
	    jim[i]=matrix[i][c1];
	}
	for(int o=0; o< _size; o++){
	    matrix[o][c1]=matrix[o][c2];
	}
	for(int r = 0; r < _size; r++){
	    matrix[r][c2]=jim[r];
	}

    }//O(n^2)


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	Object[] stor = matrix[r1];
	matrix[r1] = matrix[r2];
	matrix[r2] = stor;

    }//O(1)


    public boolean isFull(){
	for (int i = 0; i < _size; i++){
	    for (int j = 0; j < _size; j++){
		if (matrix[i][j] == null){
		    return false;
		}
	    }
	}
	return true;
    }//O(n^2)

    public Object[] getRow(int r){
	return matrix[r];
    }//O(1)

    public Object[] setRow(int r, Object[] newRow){
	Object[] adam = matrix[r];
	matrix[r] = newRow;
	return adam;
    }//O(1)
    
    public Object[] getCol(int c){
	Object[] nick = new Object[_size];
	for (int i = 0; i < _size; i++){
	    nick[i]=matrix[i][c];
	}
	for (int i = 0; i < _size; i++){
	    System.out.println(nick[i]);
	}
	return nick;
    }//O(n) varies with matrix size  (constant wrt c)

    public Object[] setCol(int c, Object[] newCol){
	Object[] one = getCol(c);
	for (int i = 0; i < _size; i++){
	    matrix[i][c]=newCol[i];
	}
	return one;
    }//O(n) with matrix size (constant wrt c)

    public void transpose(){
	for(int i = 0; i < _size; i++){
	    for(int j = 0; j < _size; j++){
		if (i>j){
		    Object ball = matrix[i][j];
		    matrix[i][j]=matrix[j][i];
		    matrix[j][i]=ball;
		}
	    }
	}
	
    }//O(n^2)

    public boolean contains(Object o){
	for (int i = 0; i < _size; i++){
	    for (int j = 0; j< _size; j++){
		if (o.equals(matrix[i][j])){
		    return true;
		}
	    }
	}
	return false;
    }//O(n^2)
	

    //main method for testing
    public static void main( String[] args ) {
	Matrix one = new Matrix();
	Matrix two = new Matrix(3);
	Matrix six = new Matrix(5);
	Matrix three = new Matrix(3);
	System.out.println(one.size());
	System.out.println(two.size());
	System.out.println(one);
	System.out.println(one.isEmpty(0,0));
	one.set(0,0,"STRING");
	System.out.println(one);
	System.out.println(one.isEmpty(0,0));
	System.out.println(two.equals(three));
	two.set(0,0,1);
		System.out.println(two.equals(three));
	three.set(0,0,1);
	System.out.println(two.equals(three));
	three.set(0,0,1);
	three.set(0,1,2);
	three.set(0,2,3);
	three.set(1,0,4);
	three.set(1,1,5);
	three.set(1,2,6);
	three.set(2,0,7);
	three.set(2,1,8);
	three.set(2,2,9);
	System.out.println(three);
	three.swapColumns(0,2);
	System.out.println(three);
	three.swapRows(0,2);
	System.out.println(three);
	three.transpose();
	System.out.println(three);
	System.out.println(three.contains(2));
	System.out.println(three.contains("String"));
	System.out.println(three.getRow(1));
	System.out.println(three.getCol(1));
    }

}//end class Matrix
