public class Knight extends Piece{
    public Knight(){
	displayName = "\033[37mN";
	white = true;
    }
    public Knight(int b){
	displayName = "\033[30N";
	white = false;
    }
    public boolean getWhite(){
	return white;
    }
    public boolean canMove(int x1, int y1, int x2, int y2){
	if ((((y2-y1==-1)||(y2-y1==1))&&((x2-x1==-2)||(x2-x1==2)))     ||        
	    (((y2-y1==-2)||(y2-y1==2))&&((x2-x1==1)||(x2-x1==-1)))){
	    return true;
	}
	else{
	    return false;
	}
    }
}
