public class Knight extends Piece{
    public Knight(){
	displayName = "N";
	white = true;
    }
    public Knight(int b){
	displayName = "N";
	white = false;
    }
    public boolean getWhite(){
	return white;
    }
    public boolean canMove(int x1, int y1, int x2, int y2){
	return true;
    }
}
