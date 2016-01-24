public class King extends Piece{
    public King(){
	displayName = "K";
    }
    public King(int b){
	displayName = "K";
	white = false;
    }
    public boolean getWhite(){
	return white;
    }
    public boolean canMove(int x1, int y1, int x2, int y2){
	return true;
    }
}
