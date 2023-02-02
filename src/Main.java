import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Album album1=new Album("moosa","SidhuMooseWala");
        album1.addSongToAlbum("295",4.05);
        album1.addSongToAlbum("lastRide",5.5);
        album1.addSongToAlbum("soHigh",3.05);

        Album album2=new Album("Arijit songs","Arijit Singh");
        album2.addSongToAlbum("gerua",5.6);
        album2.addSongToAlbum("kesariya",6.0);
        album2.addSongToAlbum("jeena jeena",3.1);

        LinkedList<Song> myPlayList=new LinkedList<>();
        album1.addToPlaylistFromAlbum("295",myPlayList);
        album2.addToPlaylistFromAlbum(2,myPlayList);
        album1.addToPlaylistFromAlbum("soHigh",myPlayList);
        album1.addToPlaylistFromAlbum(2,myPlayList);


        System.out.println(myPlayList);
        play(myPlayList);
    }

    public static void play(LinkedList<Song> playlist)
    {
        Scanner sc=new Scanner(System.in);
        ListIterator<Song> itr=playlist.listIterator();
        boolean isForward=false;
        if(playlist.size()>0)
        {
            System.out.println("currently playing");
            System.out.println(itr.next());
            isForward=true;

        }
        else
        {
            System.out.println("your playlist is empty");
            return;
        }
        printNo();
        boolean quit=false;
        while(!quit)
        {
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    if(isForward==false)
                    {
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext())
                    {
                        System.out.println(itr.next());
                    }
                    else
                    {
                        System.out.println("we reached at the end of list");
                    }
                    break;

                case 2:
                    if(isForward==true)
                    {
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious())
                    {
                        System.out.println(itr.previous());
                    }
                    else
                    {
                        System.out.println("we reached at the begining of list");
                    }
                    break;

                case 3:
                    if(isForward==true)
                    {
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isForward = false;
                        }
                        else {
                            System.out.println("you are at begining of list");
                        }
                    }
                    else
                    {
                        if(itr.hasNext())
                        {
                            System.out.println(itr.next());
                            isForward=true;
                        }
                        else
                        {
                            System.out.println("you are at end of list");
                        }
                    }
                    break;

                case 4: printNo(); break;
                case 5:
                    itr.remove();
                    System.out.println("song removed successfully");
                    break;
                case 6: printSongs(playlist); break;
                case 7:quit=true; break;
            }
        }
    }
    public static void printSongs(LinkedList<Song> playlist)
    {
        for(Song song:playlist)
        {
            System.out.println(song);
        }
        return;
    }

    public static void printNo(){
        System.out.println("Select your choice");
        System.out.println("press 1 to play next song");
        System.out.println("press 2 to play previous song");
        System.out.println("press 3 repeat song");
        System.out.println("show menu again");
        System.out.println("delete the current song");
        System.out.println("print all songs in the playlist");
        System.out.println("exit");


    }
}