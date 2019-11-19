package webapp;

import javax.ejb.Local;
import java.io.IOException;

@Local
public interface ListDir {

    StringBuffer show() throws IOException;
}
