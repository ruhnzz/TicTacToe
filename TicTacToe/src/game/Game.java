package game;
import player.Player;
import board.Board;
import java.util.Scanner;

public class Game {
    Player[] players ; //array to store the players details
    Board board ;
    int turn ;
    int noOfMoves ;
    boolean gameOver ;
    String zero ; //it's value is OOO
    String cross ; ////it's value is XXX in line 25-28 

    public Game(Player[] players , Board board){
        this.players = players ;
        this.board = board ;
        this.turn = 0 ; // chance of first pkayer to mark turn = 1 chnace of 2nd player to mark
        this.noOfMoves = 0 ;
        this.gameOver = false ;

        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for(int i = 0 ; i < board.size ; i++){
            z.append('O');
            c.append('X');
        }

        this.zero = z.toString();
        this.cross = c.toString();

    }

    public void printBoardConfig(){
        int sz = this.board.size;
        for(int i = 0 ; i < sz ; i++){
            for(int j = 0 ; j < sz ; j++){
                System.out.print(board.matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void play(){
        printBoardConfig();
        int sz = board.size ;
        while(!gameOver){
           noOfMoves++;
           int idx = getIndex() ;
           int row = idx / sz ;
           int col = idx % sz ;

           board.matrix[row][col] = players[turn].getPlayerSymbol();

           if(noOfMoves >= sz*sz ){
            System.out.println("Game Draw");
            return ;
           }

           if(noOfMoves >= 2*sz-1 && checkCombinations()){
             gameOver = true ;
             printBoardConfig();
             System.out.println("Winner is "+players[turn].getPlayerName());
             return ;
           }

           turn = (turn+1) % 2 ; // 2 becoz 2 players
           //turn = 0 -> 0+1 = 1%2 = 1 
           //turn = 1 -> 1+1 = 2%2 = 0
           printBoardConfig(); //dont need i feel

        }


    }

    public int getIndex(){
        while(true){
            System.out.println("Player: "+players[turn].getPlayerName()+" give one of the position");
            Scanner scn = new Scanner(System.in);
            int pos = scn.nextInt()-1; //user gives pos from 1-9 but we need it from 0-8
            int s = board.size ;

            int row = pos / s ;
            int col = pos % s ;
           
            //checking for invalid position
            if(row < 0 || row >= s || col < 0 || col >= s){
                System.out.println("Invalid Position");
                continue ;
            }
            
            //checking for vacant position 
            if(board.matrix[row][col] != '-'){
                System.out.println("Position already Occupied");
            }

            return pos ;

        }

    }

    public boolean checkCombinations(){
        int sz = board.size ;

        //row wise
        for(int i = 0 ; i < sz ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < sz ; j++){
                sb.append(board.matrix[i][j]);

            }
            String pattern = sb.toString();
            if(pattern.equals(zero) || pattern.equals(cross)){
              return true ;
            }

        }

        //col wise
        for(int i = 0 ; i < sz ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < sz ; j++){
                sb.append(board.matrix[j][i]);

            }
            String pattern = sb.toString();
            if(pattern.equals(zero) || pattern.equals(cross)){
              return true ;
            }
        }

        // diagonal wise row++ col++
        int i = 0 , j = 0 ;
        StringBuilder sb = new StringBuilder();
        while(i<sz){
            sb.append(board.matrix[i][j]);
            i++;
            j++;
        }
        String pattern = sb.toString();
        if(pattern.equals(zero) || pattern.equals(cross)){
          return true ;
        }

        
        //Antidiagonal row++ col--
         i = 0 ;
         j = sz-1 ;
         sb = new StringBuilder();
        while(i<sz){
            sb.append(board.matrix[i][j]);
            i++;
            j--;
        }
         pattern = sb.toString();
        if(pattern.equals(zero) || pattern.equals(cross)){
          return true ;
        }

      return false ;
    }




}
