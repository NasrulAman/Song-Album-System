import java.time.Duration;
import  java.util.Scanner;

class ProjectF1G5Album{

    private String albumName;
    private String artistName;
    private ProjectF1G5Song[] songs;
    private int totalSongs;

    Scanner input= new Scanner(System.in);
    public ProjectF1G5Album(){}

    public ProjectF1G5Album(String albumName,String artistName){
        this.albumName = albumName;
        this.artistName = artistName;
        this.songs = new ProjectF1G5Song[20]; 
        this.totalSongs = 0;
    }


    //Get
    public String getAlbumName(){
        return albumName;
    }

    public String getArtistName(){
        return artistName;
    }

    public ProjectF1G5Song[] getSongs(){
        return songs;
    }


    public int getTotalSongs(){
        return totalSongs;
    }

    //Set
    public void setAlbumName(String albumName){
        this.albumName=albumName;
    }

    public void setArtistName(String artistName){
        this.artistName=artistName;
    }

    public void setSongs(ProjectF1G5Song[] songs){
        this.songs=songs;
    }

    public void setTotalSongs(int totalSongs){
        this.totalSongs=totalSongs;
    }


    //Add Songs
    public boolean addSong(ProjectF1G5Album[] albums,String songName, String Strduration) {


    try{
        String[] parts=Strduration.split(":");
 
    if(parts.length==2){     
        Duration duration=translate(parts);
    if(totalSongs < songs.length) {
        songs[totalSongs] = new ProjectF1G5Song(songName,duration);
        totalSongs++;
        System.out.println("Added " + songName + " to " + albumName);
    } else {
       ProjectF1G5Song[] newSongs=new ProjectF1G5Song[songs.length*2];
       System.arraycopy(songs, 0, newSongs, 0, songs.length);
       songs=newSongs;
        songs[totalSongs] = new ProjectF1G5Song(songName,duration);
        totalSongs++;
    }
    }

    else{
        System.err.println("Invalid time format.Please enter using MM:SS format");
        return false;
    }

    }
    catch(NumberFormatException e){
        System.err.println("Invalid time format.Please enter using MM:SS format");
        
    }
    return true;
        
    }


    //Search Album
    public void search (ProjectF1G5Album[] albums, String title){
    boolean ans=false;
    for (int i = 0; i < albums.length; i++) { 
    if(albums[i]!=null){
    if(title.equalsIgnoreCase(albums[i].getAlbumName())){
        System.out.println("Album"+albums[i].getAlbumName()+"is found");
        System.out.println("The data is as follows:");
        System.out.println("-----------------------------------");
        System.out.println("Album name:"+albums[i].getAlbumName());
        System.out.println("Artist Name:"+albums[i].getArtistName());
        totalDuration(albums, i);
        albums[i].listSongs();
        ans=true;
    }}
    }
    if(ans==false){
        System.out.println("Not found !");
    }
    }
    
    //Display Albums
    public void displayAlbums(ProjectF1G5Album[] albums){

    System.out.println();
    System.out.println("Album list");
    System.out.println("--------------------------------------------------------------");
    System.out.printf("%-5s%-20s%-20s%-20s%n", "No", "Album Name", "Artist Name", "Number of songs");
    System.out.println("--------------------------------------------------------------");

    for(int j=0;j<albums.length;j++){
    if(albums[j]!=null){
        System.out.printf("%-5s%-20s%-20s%-20s%n",j+1,albums[j].getAlbumName(),albums[j].getArtistName(),albums[j].totalSongs);}}
    System.out.println("--------------------------------------------------------------");    
}

    //Display Songs
    public void listSongs() {
     System.out.println("List of songs and durations");  
    for (int i = 0; i < totalSongs; i++) {
        System.out.println((i + 1) + ". " + songs[i]);
    }
    }
 
    public Duration translate(String[] parts){
        int minutes=Integer.parseInt(parts[0]);
        int seconds=Integer.parseInt(parts[1]);
        Duration duration=Duration.ofMinutes(minutes).plusSeconds(seconds);
        return duration;
    }

    //Total durations
    public void totalDuration (ProjectF1G5Album[] albums,int i){
        long total=0;
        long minutes=0;
        long seconds=0;
               
        ProjectF1G5Song[] songs = albums[i].getSongs();
    if(albums[i].getSongs()!=null){
    for (int j = 0; j < albums[i].getTotalSongs(); j++) {
        if(!albums[i].getAlbumName().isEmpty()){
        total+=songs[j].getDuration().toSeconds();
        }
    } }

        minutes=((total%86400)%3600)/60;
        seconds=((total%86400)%3600%60)%60;
                
        System.out.println("Total duration: "+minutes+":"+seconds);
    }

}
