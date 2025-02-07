import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  // Stores text for scenes  
  private String[][] strings1;
  private String[][] strings2;

  // Stores images for cars and engines  
  private ImageFilter[][] imgs1;

  // Stores sound notes and durations  
  private int[][] sounds1;

  // Constructor that sets up the scene with text, images, and sounds  
  public MyStory(String[][] strings1, String[][] strings2, ImageFilter[][] imgs1, int[][] sounds1) {
    this.strings1 = strings1;
    this.imgs1 = imgs1;
    this.strings2 = strings2;
    this.sounds1 = sounds1;
  }

  // Runs all scenes in order  
  public void drawScene() {
    drawFirstScene();
    drawSecondScene();
    drawThirdScene();
    drawFourthScene();
  }

  // Displays first scene with title text  
  public void drawFirstScene() {
    clear("white");

    drawText(strings1[0][0], 50, 100);
    pause(0.5);
    drawText(strings1[0][1], 250, 100);
    pause(0.5);
    drawText(strings1[1][0], 50, 300);
    pause(0.5);
    drawText(strings1[1][1], 250, 300);

    pause(1.0);
  }

  // Displays second scene with model names  
  public void drawSecondScene() {
    clear("white");

    drawText(strings2[0][0], 50, 100);
    pause(0.5);
    drawText(strings2[0][1], 250, 100);
    pause(0.5);
    drawText(strings2[1][0], 50, 300);
    pause(0.5);
    drawText(strings2[1][1], 250, 300);

    pause(1.0);
  }
  
  // Displays third scene with car images  
  public void drawThirdScene() {
    clear("white");

    drawImage(imgs1[0][0], 0, 0, 200);
    pause(0.5);
    drawImage(imgs1[0][1], 200, 0, 200);
    pause(0.5);
    drawImage(imgs1[0][2], 0, 200, 200);
    pause(0.5);
    drawImage(imgs1[0][3], 200, 200, 200);

    pause(1.0);
  }

  // Displays fourth scene with engine images and effects  
  public void drawFourthScene() {
    clear("white");

    drawImage(imgs1[1][0], 0, 0, 200);
    decideFilter(0);
    pause(0.5);
    drawImage(imgs1[1][0], 0, 0, 200);
    playRandomSound();
    pause(0.5);

    drawImage(imgs1[1][1], 200, 0, 200);
    decideFilter(1);
    pause(0.5);
    drawImage(imgs1[1][1], 200, 0, 200);
    playRandomSound();
    pause(0.5);

    drawImage(imgs1[1][2], 0, 200, 200);
    decideFilter(2);
    pause(0.5);
    drawImage(imgs1[1][2], 0, 200, 200);
    playRandomSound();
    pause(0.5);

    drawImage(imgs1[1][3], 200, 200, 200);
    decideFilter(3);
    pause(0.5);
    drawImage(imgs1[1][3], 200, 200, 200);
    playRandomSound();
    pause(1.0);
  }

  // Plays a random sound  
  public void playRandomSound(){
    int randomNum1 = (int) (Math.random() * 4);
    int randomNum2 = (int) (Math.random() * 4);
    playNote(sounds1[0][randomNum1], sounds1[1][randomNum2]);

    System.out.println(sounds1[0][randomNum1]);
    System.out.println(sounds1[1][randomNum2]);

    // Adjusts the pitch and duration slightly  
    for (int i = 0; i < sounds1.length; i++) {
      for (int j = 0; j < sounds1[0].length; j++) {
        if (i == 0 && j != randomNum1) {
          sounds1[i][j] += 2;
        }
        if (i == 1 && j != randomNum2) {
          sounds1[i][j] += 1;
        }
      }
    }
  }

  // Applies a filter to engine images  
  public void decideFilter(int index){
    System.out.println(imgs1[1][index].getFilename());

    if (imgs1[1][index].getFilename().equals("engine1.jpg")) {
      imgs1[1][index].purplize();
    }
    if (imgs1[1][index].getFilename().equals("engine2.jpeg")) {
      imgs1[1][index].grayscale();
    }
    if (imgs1[1][index].getFilename().equals("engine3.jpg")) {
      imgs1[1][index].pixelate();
    }
    if (imgs1[1][index].getFilename().equals("engine4.jpg")) {
      imgs1[1][index].colorize();
    }
  }
}