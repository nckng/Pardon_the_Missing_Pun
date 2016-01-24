public class Rook extends Piece{
    public Rook(){
	displayName = "R";
	white = true;
    }
    public Rook(int b){
	displayName = "R";
	white = false;
    }
    public boolean getWhite(){
	return white;
    }
    public boolean canMove(int x1, int y1, int x2, int y2){
	return true;
    }
}
