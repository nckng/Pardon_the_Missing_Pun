public class Queen extends Piece{
    public Queen(){
	displayName = "Q";
    }
    public Queen(int b){
	displayName = "Q";
	white = false;
    }
    public boolean canMove(int x1, int y1, int x2, int y2){
	return true;
    }
}
