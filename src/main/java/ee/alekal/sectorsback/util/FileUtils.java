package ee.alekal.sectorsback.util;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    public static Path createTempFile(String fileName) {
        try {
            return Files.createTempFile(fileName, ".json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResponseEntity<InputStreamResource> downloadFile(File file,
                                                            ServletContext servletContext) {
        var mediaType = getMediaTypeForFileName(servletContext, file.getName());

        InputStreamResource res;
        try {
            res = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(mediaType)
                .contentLength(file.length())
                .body(res);
    }

    public static MediaType getMediaTypeForFileName(ServletContext servletContext, String fileName) {
        String mineType = servletContext.getMimeType(fileName);
        try {
            return MediaType.parseMediaType(mineType);
        } catch (Exception e) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}
