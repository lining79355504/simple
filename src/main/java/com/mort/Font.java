package com.mort;

import java.awt.*;

/**
 * Created by mort on 26/07/2017.
 */


public class Font {
    public static void main(String[] args)
    {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fontname:fontNames)
            System.out.println(fontname);
    }
}
