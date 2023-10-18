import java.time.Duration;

public class ProjectF1G5Song{
    private String songName;
    private Duration duration;

    public ProjectF1G5Song(String songName,Duration duration) {
        this.songName = songName;
        this.duration = duration;
    }

    //get
    public String getSongName() {
        return songName;
    }

    public Duration getDuration() {
        return duration;
    }

    //set
    public void setSongName(String songName){
        this.songName=songName;   
    }

    public void setDuration(Duration duration){
        this.duration=duration;
    }

    public long toSeconds() {
        long seconds=duration.toSeconds();
        return seconds;
    }

    public String toString(){
       long minutes=((toSeconds()%86400)%3600)/60;
      long seconds=((toSeconds()%86400)%3600%60)%60;
        return songName+" ("+minutes+":"+seconds+")";
    }


}