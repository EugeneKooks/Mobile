package by.kooks.mobile.reader;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class TariffDataReaderTest {

    private static final String FILE_NAME = "data/data.txt";
    private TariffDataReader lineFileReader = new TariffDataReader();

    @Test
    public void readerTest() throws Exception {
        List<String> testLines = lineFileReader.readData(FILE_NAME);
        Assert.assertTrue("File reading failure", !testLines.isEmpty());
    }
}
