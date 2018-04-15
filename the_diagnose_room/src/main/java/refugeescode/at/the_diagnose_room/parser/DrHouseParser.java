package refugeescode.at.the_diagnose_room.parser;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import java.util.stream.Stream;

import static java.nio.file.Files.lines;

@Service
public class DrHouseParser {
    //private ResourceLoader resourceLoader;

//    //public DrHouseParser(DefaultResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }

     HashMap<String, List<String>> hashmap = new HashMap<>();
    private String filePath = "refugeescode/at/the_diagnose_room/data/file.txt";

    public HashMap<String, List<String>> getDiagnoses() {

        try {
            Stream<String> lines = lines(Paths.get(filePath));

             lines.skip(1)
                    .map(line -> line.split(";"))
                    .forEach(str -> hashmap.put(str[0], Arrays.asList(str[1].split("/"))));


        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashmap;



    }
}
