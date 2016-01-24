public class Bishop extends Piece{
    public Bishop(){
	displayname = "B";
    }
    public Bishop(int b){
	displayname = "B";
	white = false;
    }
    public static boolean canMove(int x1, int y1, int x2, int y2){
	return true;
    }
}
