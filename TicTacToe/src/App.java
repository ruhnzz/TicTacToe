// import java.io.*;
import java.util.Scanner;
import board.Board; //from package called board we are importing class Board
import player.Player;
import game.Game;

public class App {
    
    public static void main(String[] args) throws Exception {
     System.out.println("First Project-> TicTacToe");
    
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the size:");
    int n = scn.nextInt();
    Board b = new Board(n); //creating object
    // b.setDefault('*');
    b.printBoardConfig();

    // Player p1 = new Player("Ruh", 19, "HYD","760104399", "Ruh18@gmail.com", 'X');//we use when we use constructor
    Player p1 = new Player();
    p1.setPlayersNameandSymbol("Ruh", 'X');
    System.out.println("Player Name:"+p1.getPlayerName());
    System.out.println("Player Symbol:"+p1.getPlayerSymbol());
    // p1.printDetails();
    // p1.changeSymbol('O');
    // System.out.println("Player Name:"+p1.getPlayerName());
    // System.out.println("Player changedSymbol:"+p1.getPlayerSymbol());

    Player p2 = new Player();
    p2.setPlayersNameandSymbol("Ree", 'X');
    System.out.println("Player Name:"+p2.getPlayerName());
    System.out.println("Player Symbol:"+p2.getPlayerSymbol());
    // p1.printDetails();
    p2.changeSymbol('O');
    System.out.println("Player changedSymbol:"+p2.getPlayerSymbol());


    Game game = new Game(new Player[] {p1,p2},b) ;
    game.play();



}
}
