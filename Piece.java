public abstract class Piece{//super class for all pieces
    public boolean white;
    public abstract boolean getWhite();
    public String displayName;
    public String getDisplayName(){
	return displayName;
    }
    public boolean hasMoved;
    
    public abstract boolean canMove(int x1, int y1, int x2, int y2);
}
