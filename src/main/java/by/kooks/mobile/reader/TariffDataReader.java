import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TariffDataReader {
    public ArrayList<String> readData(String path) throws InvalidDataException {
        ArrayList<String> lines = new ArrayList<>();
        try {
            lines.addAll(Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new InvalidDataException("File reading failure, " + e.getMessage());
        }
        return lines;
    }
}

