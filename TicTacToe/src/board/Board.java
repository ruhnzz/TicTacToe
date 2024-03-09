package board;

public class Board {
   public int size;
    public char matrix[][];

    public Board(int size){  //constructor
        this.size = size ;
        matrix = new char[size][size];
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                matrix[i][j] = '-';
            }
        }

    }
    
    //you can initial this with constructor and u can also define a function to set default character as per your choice bu i prefer initialize it with constructor with defined char
    // public void setDefault(char ch){
    //     for(int i = 0 ; i < size ; i++){
    //         for(int j = 0 ; j < size ; j++){
    //             matrix[i][j] = ch;
    //         }
    //     }
        
    // }

    public void printBoardConfig(){
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }


}
