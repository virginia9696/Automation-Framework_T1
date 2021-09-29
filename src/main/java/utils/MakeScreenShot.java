package utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.ashot.AShot;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static driverManager.DriverFactory.getDriver;
public class MakeScreenShot {

    private static final Logger logger = LoggerFactory.getLogger(MakeScreenShot.class);
    private final String EVIDENCE_DIRECTORY = "target//evidence//";
    private boolean directoryCreated = false;
    private String directoryPath;
    private String currentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime time = LocalDateTime.now();
        return formatter.format(time);
    }

    public void generateDirectory(String featureName) throws IOException {
        try {
            if (!directoryCreated) {
                directoryPath = EVIDENCE_DIRECTORY + featureName + "_" + currentTime();
                Path path = Paths.get(directoryPath);
                Files.createDirectories(path);
                directoryCreated = true;
            }
        } catch (IOException e){

            logger.warn("The directory was not created");
        }
    }

    public void makeAShot( String scenarioName) {
        try {
            ru.yandex.qatools.ashot.Screenshot screenshot = new AShot().takeScreenshot(getDriver());
            ImageIO.write(screenshot.getImage(), "png", new File(directoryPath + "//" + scenarioName + "_"
                    + currentTime() + ".png"));
        } catch (IOException e) {
            logger.warn("Could not create/save screenshot");
        }
    }
}