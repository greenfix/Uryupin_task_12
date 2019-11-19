package webapp;

import javax.ejb.Local;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

@Local
public interface ListDir {

    public StringBuffer show() throws IOException;
}
