import cs1.Keyboard;
import java.util.*;
public class Chess{//driver file for chess game
    public static Piece[][] board = new Piece[8][8];//instance variable for the board
    public static ArrayList<Piece> cap = new ArrayList();
    public static int movecounter;

    public static boolean isStalemate(){
	try {
	    Piece[][] storeboard = new Piece[8][8];
	    boolean whiteturn = ((movecounter % 2)==0);
	    if (!(hasCheck())){
		for (int i = 0; i < 8; i++){
		    for (int j = 0; j < 8; j++){
			if (!(board[i][j] == null)){
			    if    (((board[i][j]).getWhite()) == whiteturn){
				for (int l = 0; l < 8; l++){
				    for (int k = 0; k < 8; k++){
					if (((board[l][k] == null) || ((board[l][k]).getWhite() != whiteturn))  && ((board[i][j]).canMove(i,j,k,l))){
					    for (int a = 0; a < 8; a++){
						for (int b = 0; b < 8; b++){
						    storeboard[a][b]=board[a][b];
						}
					    }							
					    swap(i,j,k,l);
					    board[i][j]=null;
					    if (!(hasCheck())){
						for (int c = 0; c < 8; c++){
						    for(int d =0; d < 8; d++){
							board[c][d] = storeboard[c][d];
						    }
						}
						return false;
					    }	
					}
				    }
				}
			    }
			}
		    }
		}
		System.out.println("Stalemate.");
		return true;
	    }
	}
	catch (NullPointerException e) {
	    System.out.println("Stalemate.");
	    return true;
	}
	return false;
    }
   			    
    public static boolean isCheckmate(){
	/*
	Piece[][] storeboard = new Piece[8][8];
	boolean whiteturn = ((movecounter % 2) == 0);
	if (hasCheck()){
	    for (int i = 0; i < 8; i++){
		for (int j = 0; j < 8; j++){
		    if (!(board[i][j] == null)){
			if (((board[i][j]).getWhite()) == whiteturn){
			    for (int a = 0; a < 8; a++){
				for (int b = 0; b < 8; b++){
				    if ((board[a][b] == null) || ((board[a][b]).getWhite() != whiteturn)){
					if ((board[i][j]).canMove(j,i,b,a)){
					    for (int y =0; y <8; y++){
						for (int z =0; z < 8; z++){
						    storeboard[y][z] = board[y][z];
						}
					    }
					    swap(j,i,b,a);
					    board[i][j]=null;
					    if (!(hasCheck())){
						return false;
					    }
					    for (int r =0; r <8; r++){
						for (int s=0; s <8; s++){
						    board[r][s]=storeboard[r][s];
						}
					    }
					}
				    }
				}
			    }
			}
		    }
		}
	    }
	    System.out.println("CHECKMATE!");
	    return true;
	}
	return false;
	*/
	return false;
    }
    



    private static void clear(){//clears the screen
        final String clear = "\u001b[2J";
        final String home = "\u001b[H";
        System.out.print(clear + home);
        System.out.flush();
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
	if(board[x][y] == null){
	    if((x+y)%2==0){
		return " ";
	    }
	    else{
		return "\033[31mX";
	    }
	} else if(board[x][y].white){
	    return "\033[37m" + board[x][y].getDisplayName();
	} else{
	    return "\033[34m" + board[x][y].getDisplayName();
	}
    }
    
    public static void print() {

	if ((movecounter % 2)==0){
	    System.out.println("    A  B  C  D  E  F  G  H");
	    System.out.println("                         ");
	    for(int i = 0; i < 8; i++){
		String line = (8-i)+ "   ";
		for(int j = 0; j < 7; j++){
		    line += printSquare(i, j) + "  ";
		}
		line += printSquare(i, 7);
		System.out.println(line + "\033[37m ");
	    }
	}
	else{
	    System.out.println("    H  G  F  E  D  C  B  A");
	    System.out.println("                          ");
	    for (int a = 7; a >=0; a--){
		String enil = (8-a)+ "   ";
		for (int b = 7; b >=0; b--){
		    enil += printSquare(a,b) + "  ";
		}
		System.out.println(enil + "\033[37m ");
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
	int x = 0;
	int y = 0;
	int x1 = 0;
	int y1 = 0;
	String ab = "";
	String abc = "";
	String lol = ("ABCDEFGHabcdefgh");
	String lel = ("12345678");
	//clear();
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
	System.out.println("Input first coordinate");
	/*
	ab = Keyboard.readString();
	if (ab.length() != 2){
	    System.out.println("Sorry that is not valid. Please put your coordinate in the form <column><row>");
	    move();
	}

	if (lol.contains(ab.substring(0,1))){
	    if (lel.contains(ab.substring(1,2))){
		x = lol.indexOf(ab.substring(0,1)) % 8;
		y = 7 - lel.indexOf(ab.substring(1,2));
	    }
	}
	else{
	    System.out.println("Sorry that range was invalid. Please list a letter (a-h) and a number (1-8)");
	    move();
	}
	*/
	ab = Keyboard.readString();
	while ((ab.length() != 2)  || !(lol.contains(ab.substring(0,1)))  ||  !(lel.contains(ab.substring(1,2)))){
	    System.out.println("Sorry this is invalid. Please put your coordinate in the form <column><row> and make sure the column is between a and h and the number is between 1 and 8.");
	    ab = Keyboard.readString();
	}
	x = lol.indexOf(ab.substring(0,1)) % 8;
	y = 7 - lel.indexOf(ab.substring(1,2));
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
	    System.out.println("Input second coordinate");
	    abc = Keyboard.readString();
	    /*
	    if (abc.length() != 2){
		System.out.println("Sorry that is not valid. Please put your coordinate in the form <column><row>");
		move();
	    }
	    if (lol.contains(abc.substring(0,1))){
		if (lel.contains(abc.substring(1,2))){
		    x1 = lol.indexOf(abc.substring(0,1)) % 8;
		    y1 = 7- lel.indexOf(abc.substring(1,2));
		}
	    }
	    else{
		System.out.println("Sorry that range was invalid. Please list a letter (a-h) and a number (1-8)");
		move();
	    }
	    */
	    while ((abc.length() != 2)  || !(lol.contains(abc.substring(0,1)))  ||  !(lel.contains(abc.substring(1,2)))){
		System.out.println("Sorry this is invalid. Please put your coordinate in the form <column><row> and make sure the column is between a and h and the number is between 1 and 8.");
		abc = Keyboard.readString();
	    }
	    x1 = lol.indexOf(abc.substring(0,1)) % 8;
	    y1 = 7 - lel.indexOf(abc.substring(1,2));
	    
	    


	    //can piece move?
	    if(board[y][x].canMove(x,y,x1,y1)){//if square is empty, just move
		if(board[y1][x1] == null){
		    swap(x1,y1,x,y);
		} else{//if the square has a piece
		    //check if this piece is a friendly
		    if(((board[y][x]).getWhite())==((board[y1][x1]).getWhite())){
			System.out.println("That is your own piece! Choose another.");
			for (int i = 0; i < 8; i++){
			    for (int j = 0; j < 8; j++){
				board[i][j]=boardCopy[i][j];
			    }
			}
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
		for (int i = 0; i < 8; i++){
		    for (int j = 0; j < 8; j++){
			board[i][j]=boardCopy[i][j];
		    }
		}
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
	    movecounter++;
	}
    }


	
    public static void main(String[] args){
	System.out.println("");
	System.out.println("----------------------------------------------");
	System.out.println(" ######  ##     ## ########  ######   ######  ");
	System.out.println("##    ## ##     ## ##       ##    ## ##    ## ");
	System.out.println("##       ##     ## ##       ##       ##       ");
	System.out.println("##       ######### ######    ######   ######  ");
	System.out.println("##       ##     ## ##             ##       ## ");
	System.out.println("##    ## ##     ## ##       ##    ## ##    ## ");
  	System.out.println(" ######  ##     ## ########  ######   ######  ");
	System.out.println("----------------------------------------------");
	System.out.println("");
	System.out.println("");
	System.out.println("SELECT AN OPTION BY TYPING A NUMBER BELOW TO BEGIN");
	System.out.println("1. PLAY");
	System.out.println("2. INSTRUCTIONS");
	System.out.println("3. QUIT");
	int a = 10;
	while ((a !=1) && (a!=2) && (a !=3)){
	     a = Keyboard.readInt();
	}
	if (a == 2){
	    System.out.println("To play, just enter 1 in the pregame screen.  In this game, two players take turns making moves and attempting to checkmate their opponent. ");
	    System.out.println("Each move consists of a player choosing a piece to move, and choosing a square to move it to.  To do this, the player is be prompted to enter two");
	    System.out.println("coordinates: the initial square, and the target square.  These coordinates should be in <column><row> form and this will be specified in the prompts.");
	    System.out.println("Once a move is over, the board will flip and it will be the opposite player's turn.  Quit at anytime using ctrl-c.");
	    System.out.println("Enter anything to exit");
	    String r = Keyboard.readString();
	    return;
	}
	if (a == 3){
	    return;
	}
	if (a == 1){
	    makeBoard();
	    game();
	}
	
    }

}
