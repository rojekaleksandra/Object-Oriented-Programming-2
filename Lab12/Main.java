import java.io.*;
import java.nio.file.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        String file1 = "";
        String file2 = "";
        Map<String, String> res = new HashMap<>();
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            System.out.println("Wpisz nazwe pierwszego piku: ");
            file1 = stdin.readLine();
            System.out.println("Wpisz nazwe drugiego piku: ");
            file2 = stdin.readLine();
        } catch (IOException e) {
            System.err.println("IOException!");
        }

        Path path1 = Paths.get(file1);
        Path path2 = Paths.get(file2);
        try (BufferedReader reader1 = Files.newBufferedReader(path1)) {
            try (BufferedReader reader2 = Files.newBufferedReader(path2)) {
                String line1 = null;
                String line2 = null;
                while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                    if (line1.split(" ")[0].equals(line2.split(" ")[0])) {
                        res.put(line1.split(" ")[0],
                                "" + (Double.valueOf(line1.split(" ")[1]) + Double.valueOf(line2.split(" ")[1])));
                    }else{
                        continue;
                    }
                }
            } catch (IOException x) {
                System.err.println("IOException " + x);
                return;
            }
        } catch (IOException x) {
            System.err.println("IOException " + x);
            return;
        }

        String fileRes = "";
        BufferedReader stdin1 = new BufferedReader(
                new InputStreamReader(System.in));
        Path pathRes;
        while(true){
            try {
                System.out.println("Wpisz nazwe piku wynikowego: ");
                fileRes = stdin1.readLine();
                pathRes = Paths.get(fileRes);
                if(!Files.exists(pathRes)){
                    BufferedWriter writer = Files.newBufferedWriter(pathRes, StandardOpenOption.CREATE);
                    for(String s: res.keySet()){
                         writer.write(s + " " + res.get(s) + "\n");
                    }
                    writer.close();
                    return;
                }else{
                    System.out.println("Taki plik juz istenieje czy chcesz nadpisac?");
                    if(stdin1.readLine().equals("no")){
                    }else{
                        BufferedWriter writer = Files.newBufferedWriter(pathRes);
                        for(String s: res.keySet()){
                            writer.write(s + " " + res.get(s) + "\n");
                        }
                        writer.close();
                        return;
                    }
                }
            } catch (IOException x) {
                System.err.println("IOException " + x);
            }
        }


    }
}