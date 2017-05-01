import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        java.io.PrintWriter output = new java.io.PrintWriter(new File("p8out(Jae Jee).txt"));
        List<Art> List=new ArrayList<>();
        Map<Integer,String> artistList=new TreeMap<>();


        Scanner artistInput=new Scanner(new File("p7artists.txt"));
        artistInput.useDelimiter("\t|\r\n");

        while (artistInput.hasNext()){
            int id=artistInput.nextInt();
            String name=artistInput.next();

            artistList.put(id,name);
        }

        Scanner artInput=new Scanner(new File("p7arts.txt"));
        artInput.useDelimiter("\t|\r\n");

        while (artInput.hasNext()){
            int artID=artInput.nextInt();
            String artTitle=artInput.next();
            int artistID=artInput.nextInt();
            int value=artInput.nextInt();


            List.add(new Art(artID,artTitle,artistID,value));
        }

        Collections.sort(List);

        int num=0;
        for (Art art:List){
            if (num!=art.getArtistID()){
                output.println(art.getArtistID() + "\t" + artistList.get(art.getArtistID()) + "\t"+art);
                num=art.getArtistID();
            } else
                output.println("\t\t\t"+art);
        }
        output.close();

    }
}
