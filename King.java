public class King extends Piece{
    public King(){
	displayName = "K";
	white = true;
	hasMoved = false;
    }
    public King(int b){
	displayName = "K";
	white = false;
    }
    public boolean getWhite(){
	return white;
    }
    public String getDisplayName(){
	return displayName;
    }
    public boolean canMove(int x1, int y1, int x2, int y2){
	if ((x2 == x1) && (y2 == y1)){
	    return false;
	}
	else if((((x2-x1)==1)||
		((x2-x1)== -1)||
		((x2-x1)== 0))
		&&
		(((y2-y1)== -1)||
		((y2-y1)==0)||
		 ((y2-y1)==1))){
	    return true;
	}
	else if((x1==4) && (y1==7) && (x2==6) && (y2==7) && Chess.canCastle2W()  ||
		(x1==4) && (y1==7) && (x2==2) && (y2==7) && Chess.canCastle3W()  ||
		(x1==4) && (y1==0) && (x2==6) && (y2==0) && Chess.canCastle2B()  ||
		(x1==4) && (y1==0) && (x2==2) && (y2==0) && Chess.canCastle3B() ){
	    return true;
	}
	    
	else{
	    return false;
	}
    }
}
