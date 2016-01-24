public class Pawn extends Piece{//class for pawn
    public boolean hasMoved = false;
    public Pawn(){
	displayName = "P";
	white = true;
    }
    public Pawn(int a){
	displayName = "P";
	white = false;
    }
    public boolean getWhite(){
	return white;
    }
    public String getDisplayName(){
	return displayName;
    }
    public boolean canMove(int x1, int y1, int x2, int y2){
	if (white == true){//for white pieces
	    if (y1 != 6){
		hasMoved = true;
	    }
	    if (hasMoved){//if it has moved
		if ((y1-y2)==1 && (x2==x1)){//pawn can move only 1 piece forward
		    return true;
		}
		else{
		    return false;
		}
	    }
	    else{//if it hasnt moved
		if ((((y1-y2)==1)||((y1-y2)==2)) && (x2==x1)){//pawn can move one or two forward
		    return true;
		}
		else{
		    return false;
		}
	    }
	}
	else{//for black pieces
	    if (y1 != 1){
		hasMoved = true;
	    }
	    if (hasMoved){//if it has moved
		if ((y2-y1)==1 && (x2==x1)){//pawn can move only 1 piece forward
		    return true;
		}
		else{
		    return false;
		}
	    }
	    else{//if it hasnt moved
		if ((((y2-y1)==1)||((y2-y1)==2)) && (x2==x1)){//pawn can move one or two forward
		    return true;
		}
		else{
		    return false;
		}
	    }
	}
    }	
}
