package net.makerimages.streamertool.ui;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Makerimages on 7/10/2015.
 */
public class FontManager {

    Font primary;
    Font primarySmaller;

    public FontManager() {
        File primaryFile = new File("res/fonts/Amble-Regular.ttf");
        FileInputStream primaryStream = null;
        try {
            primaryStream = new FileInputStream(primaryFile);
            primary = Font.createFont(Font.TRUETYPE_FONT, primaryStream);
            primary = primary.deriveFont(20f);
            primarySmaller = primary.deriveFont(16f);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
