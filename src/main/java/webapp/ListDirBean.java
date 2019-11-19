package webapp;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.stream.Stream;

public class ListDirBean implements ListDir {
    @Override
    public StringBuffer show() throws IOException {
        Stream<Path> stream = Files.find(Paths.get(System.getProperty("user.home")), Integer.MAX_VALUE,
                (path, basicFileAttributes) -> !path.toFile().isDirectory());
        final String[] old = new String[1];
        final StringBuffer resultText = new StringBuffer();
        try {
            stream.forEach(pathObj -> {
                final String path = pathObj.getParent().toString();
                final int parts = path.split(Matcher.quoteReplacement(System.getProperty("file.separator"))).length;
                if (path.equals(old[0])) {
                    resultText.append("__").append(CharBuffer.allocate(parts).toString().replace('\0', '_')).append(" ").append(pathObj.getFileName());
                } else {
                    resultText.append("+").append(CharBuffer.allocate(parts).toString().replace('\0', '_')).append(pathObj.getParent().toString());
                }
                resultText.append("<br />");
                old[0] = pathObj.getParent().toString();
            });
        } catch (Exception ignored) {
        }

        return resultText;
    }
}
