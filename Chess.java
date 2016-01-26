import cs1.Keyboard;
import java.util.*;
public class Chess{//driver file for chess game
    public static Piece[][] board = new Piece[8][8];//instance variable for the board
    public static ArrayList<Piece> cap = new ArrayList();
    public static int movecounter;

    public static boolean isStalemate(){//is there a stalemate?
	if (hasCheck()){
	    return false;
	}
	else{
	    return false;
	}
    }
    
    public static boolean isCheckmate(){
	if (hasCheck()){
	    return false;
	}
	return false;
    }

    public static boolean hasCheck(){
	//find the king coord
	boolean whiteturn = ((movecounter % 2)==0);
	int kingx = 0;
	int kingy = 0;
	for (int a = 0; a < 8; a++){
	    for (int b = 0; b < 8; b++){
		//if board[a][b] is a king and the same color as the turn color
		if (!(board[a][b] == null)){//if it isnt empty
		    if (((board[a][b]).getDisplayName()).equals("K")){//is it a king
			if((board[a][b]).getWhite()==whiteturn){//if the piece is the same color as the turn
			    kingx = b;
			    kingy = a;
			}
		    }
		}
	    }
	}
	//System.out.println(kingx);
	//System.out.println(kingy);
	//ask every opposite color piece if they can check the king
	for (int i = 0; i < 8; i++){
	    for (int j = 0; j < 8; j ++){
		if (!(board[i][j] == null)){//if it isnt empty
		    if ((board[i][j]).getWhite() != whiteturn){//if it is the opposite color of the king
			//System.out.println(j + " " +i);
			if ((board[i][j]).canMove(j,i,kingx,kingy)){
			    return true;
			}
		    }
		}
	    }
	}
	return false;
    }
    
    public static boolean isGameOver(){//if there is checkmate or stalemate the game is over
	if (isCheckmate())
	    {return true;}
	else if (isStalemate())
	    {return true;}
	else
	    {return false;}
    }

    public static String printSquare(int x, int y){
	if (board[x][y] == null){
	    if((x+y)%2==0){
		return " ";
	    }
	    else{
		return "X";
	    }
	} else{
	    return board[x][y].getDisplayName();
	}
    }

    public static void print() {
	if ((movecounter % 2)==0){
	    System.out.println("    0  1  2  3  4  5  6  7");
	    System.out.println("                         ");
	    for(int i = 0; i < 8; i++){
		String line = i+ "   ";
		for(int j = 0; j < 7; j++){
		    line += printSquare(i, j) + "  ";
		}
		line += printSquare(i, 7);
		System.out.println(line);
	    }
	}
	else{
	    System.out.println("    7  6  5  4  3  2  1  0");
	    System.out.println("                          ");
	    for (int a = 7; a >=0; a--){
		String enil = a+ "   ";
		for (int b = 7; b >=0; b--){
		    enil += printSquare(a,b) + "  ";
		}
		System.out.println(enil);
	    }
	}
		    
    }

    public static boolean isEmpty(int x, int y){
	return board[y][x] == null;
    }

    public static void swap(int x1, int y1, int x2, int y2){
	Piece stor = board[y1][x1];
	board[y1][x1] = board[y2][x2];
	board[y2][x2] = stor;
    }



				 
    public static void move(){
	//check for turn
	print();
	Piece[][] boardCopy = new Piece[8][8];
	for (int a = 0; a < 8; a++){
	    for (int b = 0; b < 8 ; b++){
		boardCopy[a][b]=board[a][b];
	    }
	}
	if (hasCheck()){
	    System.out.println("CHECK!");
	}
	boolean whiteturn = ((movecounter % 2)==0);
	//Ask for square
	if (whiteturn){
	    System.out.println("White's turn");
	}
	else{
	    System.out.println("Black's turn");
	}
	System.out.println("Input column");
	int x = Keyboard.readInt();
	System.out.println("Input row");
	int y = Keyboard.readInt();
	System.out.println(x+","+y+" selected");
	//is square empty?
	if(board[y][x] == null){
	    System.out.println("There is no piece on that square. Choose another one.");
	    move();
	}
	//check if square has correct turn piece
	else if(((board[y][x]).getWhite())!=(whiteturn)){
	    System.out.println("That is not your piece. Choose another.");
	    move();
	}
	//check for check
	//select new square
	else{
	    System.out.println("You have chosen a "+(board[y][x]).getDisplayName());
	    System.out.println("Input new column");
	    int x1 = Keyboard.readInt();
	    System.out.println("Input new row");
	    int y1 = Keyboard.readInt();
	    System.out.println(x1+","+y1+" selected");
	    //can piece move?
	    if(board[y][x].canMove(x,y,x1,y1)){//if square is empty, just move
		if(board[y1][x1] == null){
		    swap(x1,y1,x,y);
		} else{//if the square has a piece
		    //check if this piece is a friendly
		    if(((board[y][x]).getWhite())==((board[y1][x1]).getWhite())){
			System.out.println("That is your own piece! Choose another.");
			move();
		    }
		    else{
			swap(x1,y1,x,y);
			cap.add(board[y][x]);
			board[y][x] = null;
		    }
		}
	    }
	    else{
		System.out.println("Your piece cannot move there. Please select a different move.");
		move();
	    }
	    //if there is check after the move, reject the move
	    if (hasCheck()){
		System.out.println("Sorry there is a check. You cannot make that move");
		//board = boardCopy;
		for (int i = 0; i < 8; i++){
		    for (int j = 0; j < 8; j++){
			board[i][j]=boardCopy[i][j];
		    }
		}
		move();
	    }
	}
	
    }

    public static void makeBoard(){
	//add black pieces
	board[0][0] = new Rook(1);
	board[0][1] = new Knight(1);
	board[0][2] = new Bishop(1);
	board[0][3] = new Queen(1);
	board[0][4] = new King(1);
	board[0][5] = new Bishop(1);
	board[0][6] = new Knight(1);
	board[0][7] = new Rook(1);
	//add black pawns
	board[1][0] = new Pawn(1);
	board[1][1] = new Pawn(1);
	board[1][2] = new Pawn(1);
	board[1][3] = new Pawn(1);
	board[1][4] = new Pawn(1);
	board[1][5] = new Pawn(1);
	board[1][6] = new Pawn(1);
	board[1][7] = new Pawn(1);
	//add white pawns
	board[6][0] = new Pawn();
	board[6][1] = new Pawn();
	board[6][2] = new Pawn();
	board[6][3] = new Pawn();
	board[6][4] = new Pawn();
	board[6][5] = new Pawn();
	board[6][6] = new Pawn();
	board[6][7] = new Pawn();
	//add white pieces
	board[7][0] = new Rook();
	board[7][1] = new Knight();
	board[7][2] = new Bishop();
	board[7][3] = new Queen();
	board[7][4] = new King();
	board[7][5] = new Bishop();
	board[7][6] = new Knight();
	board[7][7] = new Rook();	
    }
    
    public static void game(){
	boolean turn = false; //false = white, true = black
	while(! isGameOver()){//if the game is not over
	    move();
	    System.out.println(movecounter);
	    movecounter++;
	}
    }


	
    public static void main(String[] args){
	makeBoard();
	game();
    }

}
