import java.util.Scanner;

public class ProjectF1G5Main{

public static void main(String[] args) {
   
final int MAX=20;
int k=3;
int choice=0;
ProjectF1G5Album[] albums=new ProjectF1G5Album[MAX];
ProjectF1G5Album album=new ProjectF1G5Album();

//Scanner
Scanner input=new Scanner(System.in);


// Creating 3 albums manually
albums[0]=  new ProjectF1G5Album("Number One", "Artist A"); 
albums[1] = new ProjectF1G5Album("Number Two", "Artist B");
albums[2] = new ProjectF1G5Album("Number Three","Artist C");

// Adding songs to albums
albums[0].addSong(albums,"Song 1", "3:20");
albums[0].addSong(albums,"Song 2", "4:25");
albums[1].addSong(albums,"Song 3", "3:10");
albums[1].addSong(albums,"Song 4", "2:24");
albums[2].addSong(albums,"Song 5", "5:21");

album.displayAlbums(albums);

do{
    try{
    System.out.println();
    System.out.println("Activity selection");
    System.out.println("1. Add Album");
    System.out.println("2. Add song to album");
    System.out.println("3. Search for an album");
    System.out.println("4. Display all albums");
    System.out.println();
    System.out.print("Enter your option(0 to exit):");
    choice=input.nextInt();
    input.nextLine();

    if(choice <0||choice>4){
        throw new IllegalArgumentException("Invalid input.");
    }
    
    switch(choice){
case 0:

System.out.println("Exiting program...");
return;


case 1:
    System.out.print("Enter the album name: ");
    String albumName= input.nextLine();
    System.out.print("Enter the artist name: ");
    String artistName=input.nextLine();

    albums[k]=  new ProjectF1G5Album(albumName, artistName);

    k++;

    break;

case 2:
String duration;
    //Printing menu for add songs    
    album.displayAlbums(albums);
    int albumNum=0;
try {
        do{
    if(albumNum<0||albums[albumNum]==null)
    System.out.println("Incorrect input.");
    System.out.print("Enter the album number to add song into (0 to cancel): ");
    albumNum=input.nextInt()-1;
    if(albumNum==-1)
    break;
    input.nextLine();       
    }while(albums[albumNum]==null);
} catch (Exception e) {
    System.out.println("Invalid album selection.The limit for the album is 20!");
    break;
}


    int conti;
    if(albumNum!=-1){
    do{
    System.out.print("Enter song name:");
    String songName=input.nextLine();
    do{
    System.out.print("Enter song duration:");
     duration=input.nextLine();
    }while(!albums[albumNum].addSong(albums, songName, duration));
    System.out.print("Add another song? 1 to add / 0 to cancel:");
    conti=input.nextInt();
    input.nextLine();
    }while(conti !=0);
}
    else{
    
        break;
    }
    break;



case 3:
    System.out.print("Enter album name to search:");
    String search=input.nextLine();
    album.search(albums, search);
break;

case 4:
    //Printing album list
    album.displayAlbums(albums);
    break;

default:
System.out.println("Invalid option!");
}
    }
catch(java.util.InputMismatchException e){
        System.out.println("Invalid input. Please enter a number.");
        input.next();
    }
catch (IllegalArgumentException e) {
        
        System.out.println(e.getMessage());
    }
}while(choice!=0);


input.close();

}


}
    

