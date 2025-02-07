import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  // Constructor that loads an image  
  public ImageFilter(String fileName) {
    super(fileName);
  }

  // Applies a pixelation effect by averaging colors in small blocks  
  public void pixelate() {
    int gridSize = 8;
    Pixel[][] pixels = getImagePixels();
    
    for (int i = 0; i < pixels.length; i += gridSize) {
      for (int j = 0; j < pixels[0].length; j += gridSize) {
        double totalRed = 0;
        double totalGreen = 0;
        double totalBlue = 0;

        // Get the average color in a block  
        for (int k = 0; k < gridSize; k++) {
          for (int l = 0; l < gridSize; l++) {
            Pixel currentPixel = pixels[i + k][j + l];
            totalRed += currentPixel.getRed();
            totalGreen += currentPixel.getGreen();
            totalBlue += currentPixel.getBlue();
          }
        }

        int avgRed = (int) (totalRed / (gridSize * gridSize));
        int avgGreen = (int) (totalGreen / (gridSize * gridSize));
        int avgBlue = (int) (totalBlue / (gridSize * gridSize));

        // Apply the average color to the block  
        for (int k = 0; k < gridSize; k++) {
          for (int l = 0; l < gridSize; l++) {
            Pixel currentPixel = pixels[i + k][j + l];
            currentPixel.setRed(avgRed);
            currentPixel.setGreen(avgGreen);
            currentPixel.setBlue(avgBlue);
          }
        }
      }
    }
  }

  // Converts the image to grayscale  
  public void grayscale() {
    Pixel[][] pixels = getImagePixels();

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        double total = 0;

        Pixel currentPixel = pixels[i][j];
        total += currentPixel.getRed();
        total += currentPixel.getGreen();
        total += currentPixel.getBlue();

        int avg = (int) (total / 3.0);

        // Set all color channels to the average value  
        currentPixel.setRed(avg);
        currentPixel.setGreen(avg);
        currentPixel.setBlue(avg);
      }
    }
  }

  // Changes colors based on brightness  
  public void colorize() {
    Pixel[][] pixels = getImagePixels();

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        double total = 0;

        Pixel currentPixel = pixels[i][j];
        total += currentPixel.getRed();
        total += currentPixel.getGreen();
        total += currentPixel.getBlue();

        int avg = (int) (total / 3.0);

        // Apply red, green, or blue based on brightness  
        if (avg < 85) {
          currentPixel.setRed(255);
          currentPixel.setGreen(0);
          currentPixel.setBlue(0);
        } else if (avg < 170) {
          currentPixel.setRed(0);
          currentPixel.setGreen(255);
          currentPixel.setBlue(0);
        } else {
          currentPixel.setRed(0);
          currentPixel.setGreen(0);
          currentPixel.setBlue(255);
        }
      }
    }
  }

  // Applies a purple tint by averaging red and green  
  public void purplize() {
    Pixel[][] pixels = getImagePixels();

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        double total = 0;

        Pixel currentPixel = pixels[i][j];
        total += currentPixel.getRed();
        total += currentPixel.getGreen();

        int avg = (int) (total / 2.0);

        // Set red and blue channels to the average, green to zero  
        currentPixel.setRed(avg);
        currentPixel.setGreen(0);
        currentPixel.setBlue(avg);
      }
    }
  }
}