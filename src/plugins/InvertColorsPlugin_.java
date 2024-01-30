package plugins;

import ij.ImagePlus;
import ij.io.FileSaver;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InvertColorsPlugin_ implements PlugInFilter {

    public int setup(String arg, ImagePlus imp) {
        return DOES_ALL;
    }

    public void run(ImageProcessor imgProcessor) {

        ImagePlus imgPlus = new ImagePlus("inverted", imgProcessor);
//        ImageProcessor imgProcessor = imgPlus.getProcessor();
        imgProcessor.invert();
        FileSaver fs = new FileSaver(imgPlus);
        fs.saveAsJpeg("C:\\Users\\imert\\Downloads\\images\\inverted.jpg");

        BufferedImage bufferedImage = imgProcessor.getBufferedImage();
        for(int y=0;y<bufferedImage.getHeight();y++)
        {
            for(int x=0;x<bufferedImage.getWidth();x++)
            {
                Color color = new Color(bufferedImage.getRGB(x, y));
                int grayLevel = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                int r = grayLevel;
                int g = grayLevel;
                int b = grayLevel;
                int rgb = (r<<16)  | (g<<8)  | b;
                bufferedImage.setRGB(x, y, rgb);
            }
        }
        ImagePlus grayImg = new ImagePlus("gray", bufferedImage);
        fs = new FileSaver(grayImg);
        fs.saveAsJpeg("C:\\Users\\imert\\Downloads\\images\\gray.jpg");
    }
}
