package player;

public class Player {
    String name ;
    int age ;
    String address;
    String number ;
    String email;
    char symbol;

    // public Player(String name ,int age,String address,int number ,String email,char symbol){
    //     this.name = name ;
    //     this.age = age ;
    //     this.address = address ;
    //     this.number = number;
    //     this.email = email ;
    //     this.symbol = symbol ;
    // }   constructor but here we are using functions because we need only main two properties
    // above constructor can also defined as function

    public void playerDetails(String name ,int age,String address,String number ,String email,char symbol){
        this.name = name ;
        this.age = age ;
        this.address = address ;
        this.number = number;
        this.email = email ;
        this.symbol = symbol ;
    }

    public void setPlayersNameandSymbol(String name,char symbol){
        this.name = name ;
        this.symbol = symbol ;


    }

    public String getPlayerName(){
        return this.name ;
    }
    
    public char getPlayerSymbol(){
        return this.symbol ;
    }


    public void printDetails(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(address);
        System.out.println(number);
        System.out.println(email);
        System.out.println(symbol);


    }

    public void changeSymbol(char symbol){
        this.symbol = symbol ;
    }

}
