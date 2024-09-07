import java.util.*;
import java.io.*;


class Player{
  char playerSymbol;

  Player(char symbol){
    this.playerSymbol = symbol;
  }

}

class Grid{
  char [][] arr;

  Grid(){
    this.arr = new char[3][3];
  }

  void setTile(int x, int y, Player player){
    if(x < 0 || x > 2 || y < 0 || y > 2){
      System.out.println("Invalid tile selected, Please select a new tile");
    }

    arr[x][y] = player.symbol;

    System.out.println("Tile " + x + ", " + y + " is set with " + player.symbol);
  }

  void trackState(){
    for(int i = 0; i < 3; i++){
      for(int  j = 0; j < 3; j++){
        System.out.print(arr[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }


}





class tictactoe{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
        
    int n = s.nextInt();

    System.out.println("Creating a grid of : " + n + " x " + n);

    Grid grid = new Grid();

    Player p1 = new Player('x');
    Player p2 = new Player('0');




  }
}