package com.chess.utils;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageManager {

    private static final Logger LOGGER = Logger.getLogger(ImageManager.class.getName());

    // ROOT PATHS
    private static final String PIECES = Path.of("images", "board", "pieces").toString();


    // PATHS
    private static final Path PATH_WHITE_ROOK    = Path.of( PIECES, "white_rook.png"     );
    private static final Path PATH_WHITE_KNIGHT  = Path.of( PIECES, "white_knight.png"   );
    private static final Path PATH_WHITE_BISHOP  = Path.of( PIECES, "white_bishop.png"   );
    private static final Path PATH_WHITE_QUEEN   = Path.of( PIECES, "white_queen.png"    );
    private static final Path PATH_WHITE_KING    = Path.of( PIECES, "white_king.png"     );
    private static final Path PATH_WHITE_PAWN    = Path.of( PIECES, "white_pawn.png"     );

    private static final Path PATH_BLACK_ROOK    = Path.of( PIECES, "black_rook.png"     );
    private static final Path PATH_BLACK_KNIGHT  = Path.of( PIECES, "black_knight.png"   );
    private static final Path PATH_BLACK_BISHOP  = Path.of( PIECES, "black_bishop.png"   );
    private static final Path PATH_BLACK_QUEEN   = Path.of( PIECES, "black_queen.png"    );
    private static final Path PATH_BLACK_KING    = Path.of( PIECES, "black_king.png"     );
    private static final Path PATH_BLACK_PAWN    = Path.of( PIECES, "black_pawn.png"     );


    // IMAGES
    private static final int IMAGE_SIZE = 72;
    public static final ImageIcon IMG_PLACEHOLDER = createPlaceholderImageIcon(IMAGE_SIZE);

    public static final ImageIcon IMG_WHITE_ROOK    = loadImageIcon(PATH_WHITE_ROOK);
    public static final ImageIcon IMG_WHITE_KNIGHT  = loadImageIcon(PATH_WHITE_KNIGHT);
    public static final ImageIcon IMG_WHITE_BISHOP  = loadImageIcon(PATH_WHITE_BISHOP);
    public static final ImageIcon IMG_WHITE_QUEEN   = loadImageIcon(PATH_WHITE_QUEEN);
    public static final ImageIcon IMG_WHITE_KING    = loadImageIcon(PATH_WHITE_KING);
    public static final ImageIcon IMG_WHITE_PAWN    = loadImageIcon(PATH_WHITE_PAWN);

    public static final ImageIcon IMG_BLACK_ROOK    = loadImageIcon(PATH_BLACK_ROOK);
    public static final ImageIcon IMG_BLACK_KNIGHT  = loadImageIcon(PATH_BLACK_KNIGHT);
    public static final ImageIcon IMG_BLACK_BISHOP  = loadImageIcon(PATH_BLACK_BISHOP);
    public static final ImageIcon IMG_BLACK_QUEEN   = loadImageIcon(PATH_BLACK_QUEEN);
    public static final ImageIcon IMG_BLACK_KING    = loadImageIcon(PATH_BLACK_KING);
    public static final ImageIcon IMG_BLACK_PAWN    = loadImageIcon(PATH_BLACK_PAWN);

    private ImageManager() {}
    
    private static ImageIcon loadImageIcon(Path iconPath) {
        ImageIcon image;

        try {

            URL url = ImageManager.class.getClassLoader().getResource(iconPath.toString());

            if (url == null) {
                LOGGER.log(Level.WARNING, "Error loading image from path: {0}", iconPath);
                return IMG_PLACEHOLDER;
            }

            image = new ImageIcon(url);

        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error loading image from path: {0}", iconPath);
            return IMG_PLACEHOLDER;
        }

        return image;
    }

    private static ImageIcon createPlaceholderImageIcon(int size) {
        return createPlaceholderImageIcon(size, size);
    }

    private static ImageIcon createPlaceholderImageIcon(int width, int height) {

        BufferedImage placeholder = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = placeholder.getGraphics();

        // Set background color
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, placeholder.getWidth(), placeholder.getHeight());
        g.dispose();

        return new ImageIcon(placeholder);
    }

}
