package com.chess.utils;

import org.junit.jupiter.api.Test;

import javax.swing.ImageIcon;
import java.lang.reflect.Method;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class ImageManagerTest {

    @Test
    void loadImageIcon_NonExistentImage_ReturnsFallback() throws Exception {

        // Test the method with an invalid path
        Path path = Path.of("images", "nonexistent.png");
        ImageIcon result = test_loadImageIcon(path);

        assertNotNull(result, "Fallback image should not be null");
        assertSame(ImageManager.IMG_PLACEHOLDER, result, "Invalid path should return the placeholder image");

    }

    @Test
    void loadImageIcon_InvalidPath_ReturnsFallback() throws Exception {

        ImageIcon result = test_loadImageIcon(null); // Test the method with a null path

        assertNotNull(result, "Fallback image should not be null");
        assertSame(ImageManager.IMG_PLACEHOLDER, result, "Invalid path should return the placeholder image");

    }

    ImageIcon test_loadImageIcon(Path path) throws Exception {

        // Use reflection to access the private loadImageIcon method
        Method loadImageIconMethod = ImageManager.class.getDeclaredMethod("loadImageIcon", Path.class);
        loadImageIconMethod.setAccessible(true);

        // Invoke the method with the given path
        return (ImageIcon) loadImageIconMethod.invoke(null, path);

    }

}