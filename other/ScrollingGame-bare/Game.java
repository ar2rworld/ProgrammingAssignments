public class Game
{
    private Grid grid;
    private int userRow;
    private int userCol;
    private int msElapsed;
    private int timesGet;
    private int timesAvoid;
    private int level;//difficulty
    private int ch1y = 5;
    private int ch1x = 5;
    private int ch2y = 13;
    private int ch2x = 5;
    private int ch3y = 5;
    private int ch3x = 13;
    private int ch4y = 13;
    private int ch4x = 13;
    private int score = 0;
    private int[][] eggs = new int[4][4];
    public Game()
    {
        grid = new Grid(19, 19);
        userRow = 5;
        userCol = 5;
        msElapsed = 0;
        timesGet = 0;
        timesAvoid = 0;
        level=1;
        score = 0;
        updateTitle();
        ch1y = 5;
        ch1x = 5;
        ch2y = 13;
        ch2x = 5;
        ch3y = 5;
        ch3x = 13;
        ch4y = 13;
        ch4x = 13;//z like counting
        //boolean[][] eggs 
        grid.setImage(new Location(userRow, userCol), "VOLK.png");
        for(int i=1; i<grid.getNumRows()-1;i++){
            for(int j=1; j<grid.getNumCols()-1;j++){
                grid.setColor( new Location(i,j), new Color(49,96,0));
            }
        }
        
    }
    
    
    public void play()
    {   
        while (!isGameOver())
        {
            grid.pause(100);
            handleKeyPress();
            if (msElapsed % 300 == 0)
            {
                scrollLeft();
                populateRightEdge();
            }
            updateTitle();
            msElapsed += 100;
            gifChicken(5,5);
            gifChicken(13,5);
            gifChicken(5,13);
            gifChicken(13,13);
            if((msElapsed % (int)1000/level - (int)1000/level%100) == 0){
                eggManagement();
            }
        }
    }

    public void gifChicken(int y,int x){
        int t = msElapsed % 2000; 
        if(t<1001){
            grid.setImage(new Location(y, x), "chicken71x71.png");
        }else{
            grid.setImage(new Location(y, x), "chicken71x71(2).gif");
        }
    }

    public double rnd(){
        return Math.random();
    }

    public void eggManagement(){
        boolean t = rnd()>0.843?true:false;
        if(rnd()>0.7){ // top row chicken
            if(rnd()>0.7){ //left column
                if(rnd()>0.7){
                    if(rnd()>0.7){
                        eggCreate(ch1y+1, ch1x, t);
                        if(t){
                            eggs[0][0]=3; 
                        }else{
                        eggs[0][0] = 1;
                        }
                    }else{
                        eggCreate(ch1y-1, ch1x, t);
                        eggs[0][1] = 1;
                    }
                }else{
                    if(rnd()>0.7){
                        eggCreate(ch1y, ch1x+1, t);
                        eggs[0][2] = 1;
                    }else{
                        eggCreate(ch1y, ch1x-1, t);
                        eggs[0][3] = 1;
                    }
                }
            }else{//right column
                if(rnd()>0.7){
                    if(rnd()>0.7){
                        eggCreate(ch2y+1, ch2x, t);
                        eggs[1][0] = 1;
                    }else{
                        eggCreate(ch2y-1, ch2x, t);
                        eggs[1][1] = 1;
                    }
                }else{
                    if(rnd()>0.7){
                        eggCreate(ch2y, ch2x+1, t);
                        eggs[1][2] = 1;
                    }else{
                        eggCreate(ch2y, ch2x-1, t);
                        eggs[1][3] = 1;
                    }
                }
            }
        }else{//bootom row
            if(rnd()>0.7){//left
                if(rnd()>0.7){
                    if(rnd()>0.7){
                        eggCreate(ch3y+1, ch3x, t);
                        eggs[2][0] = 1;
                    }else{
                        eggCreate(ch3y-1, ch3x, t);
                        eggs[2][1] = 1;
                    }
                }else{
                    if(rnd()>0.7){
                        eggCreate(ch3y, ch3x+1, t);
                        eggs[2][2] = 1;
                    }else{
                        eggCreate(ch3y, ch3x-1, t);
                        eggs[2][3] = 1;
                    }
                }
            }else{ //right column
                if(rnd()>0.7){
                    if(rnd()>0.7){
                        eggCreate(ch4y+1, ch4x, t);
                        eggs[3][0] = 1;
                    }else{
                        eggCreate(ch4y-1, ch4x, t);
                        eggs[3][1] = 1;
                    }
                }else{
                    if(rnd()>0.7){
                        eggCreate(ch4y, ch4x+1, t);
                        eggs[3][2] = 1;
                    }else{
                        eggCreate(ch4y, ch4x-1, t);
                        eggs[3][3] = 1;
                    }
                }
            }
        }
    }
    /*public void shakalMangement(){
        
     if(msElapsed % 2000 == 0){
         grid.setImage(new Location(a.getY(), a.getX()), "shakal.png");
         grid.setImage(new Location(a.getY(), a.getX()), null);
         a.moveShakal();
         grid.setImage(new Location(a.getY(), a.getX()), "shakal.png");
        }
    }*/
    public void eggCreate(int y, int x, boolean t){
        if(!t){
            grid.setImage(new Location(y, x), "egg.png");
        }else{
            grid.setImage(new Location(y, x), "eggG.png");
        }
    }
    public void eggInc(){
        if(userRow == ch1y+1 && userCol == ch1x && eggs[0][0] == 1){
            score++;
            eggs[0][0] = 0;
        }
        if(userRow == ch1y-1 && userCol == ch1x && eggs[0][1] == 1){
            score++;
            eggs[0][1] = 0;
        }
        if(userCol == ch1x+1 && userRow == ch1y && eggs[0][2] == 1){
            score++;
            eggs[0][2] = 0;
        }
        if(userCol == ch1x-1 && userRow == ch1y && eggs[0][3] == 1){
            score++;
            eggs[0][3] = 0;
        }
        if(userRow == ch2y+1 && userCol == ch2x && eggs[1][0] == 1){
            score++;
            eggs[1][0] = 0;
        }
        if(userRow == ch2y-1 && userCol == ch2x && eggs[1][1] == 1){
            score++;
            eggs[1][1] = 0;
        }
        if(userCol == ch2x+1 && userRow == ch2y && eggs[1][2] == 1){
            score++;
            eggs[1][2] = 0;
        }
        if(userCol == ch2x-1 && userRow == ch2y && eggs[1][3] == 1){
            score++;
            eggs[1][3] = 0;
        }
        if(userRow == ch3y+1 && userCol == ch3x && eggs[2][0] == 1){
            score++;            
            eggs[2][0] = 0;
        }
        if(userRow == ch3y-1 && userCol == ch3x && eggs[2][1] == 1){
            score++;            
            eggs[2][1] = 0;
        }
        if(userCol == ch3x+1 && userRow == ch3y  && eggs[2][2] == 1){
            score++;            
            eggs[2][2] = 0;
        }
        if(userCol == ch3x-1 && userRow == ch3y && eggs[2][3] == 1){
            score++;            
            eggs[2][3] = 0;
        }
        if(userRow == ch4y+1 && userCol == ch4x && eggs[3][0] == 1){
            score++;       
            eggs[3][0] = 0;
        }
        if(userRow == ch4y-1 && userCol == ch4x && eggs[3][1] == 1){
            score++;           
            eggs[3][1] = 0;
        }
        if(userCol == ch4x+1 && userRow == ch4y && eggs[3][2] == 1){
            score++;           
            eggs[3][2] = 0;
        }
        if(userCol == ch4x-1 && userRow == ch4y && eggs[3][3] == 1){
            score++;           
            eggs[3][3 ] = 0;
        }
    }
    public void handleKeyPress()
    {   //https://docs.oracle.com/javase/7/docs/api/constant-values.html#java.awt.event.KeyEvent.VK_UP
        int key = grid.checkLastKeyPressed();
        String volk = "VOLK.png";
        switch(key){
            case(87):
            //grid.setTitle("w");
            if(userRow>0){
                grid.setImage(new Location(userRow, userCol), null);
                grid.setImage(new Location(userRow-=1, userCol), volk);
            }
            break;
            case(65):
            //grid.setTitle("A");
            if(userCol>0){
                grid.setImage(new Location(userRow, userCol), null);
                grid.setImage(new Location(userRow, userCol-=1), volk);
            }
            break;
            case(68):
            //grid.setTitle("D");
            if(userCol<grid.getNumCols()-1){
                grid.setImage(new Location(userRow, userCol), null);
                grid.setImage(new Location(userRow, userCol+=1), volk);
            }

            break;
            case(83):
            //grid.setTitle("s");
            if(grid.getNumRows()-1>userRow){
                grid.setImage(new Location(userRow, userCol), null);
                grid.setImage(new Location(userRow+=1, userCol), volk);
            }
            break;
            case(27):
            grid.setTitle("Esc");
            System.exit(0);
            break;
        }
        eggInc();
    }
    public void enemyShakal(){
        
    }
    public void populateRightEdge()
    {
    }

    public void scrollLeft()
    {

    }

    public void handleCollision(Location loc)
    {
        
    }

    public int getScore()
    {
        return 0;
    }

    public void updateTitle()
    {
        grid.setTitle("Game:  " + score );//+ getScore());
    }

    public boolean isGameOver()
    {   
        return false;
    }

    public static void test()
    {
        Game game = new Game();
        game.play();
    }

    public static void main(String[] args)
    {
        test();
    }
    
}