import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class TariffDataReaderTest {

    private static final String FILES_PATH = "data/data.txt";
    private TariffDataReader lineFileReader = new TariffDataReader();

    @Test
    public void readerTest() throws Exception {
        List<String> testLines = lineFileReader.readData(FILES_PATH);
        Assert.assertTrue("File reading failure", !testLines.isEmpty());
    }
}
