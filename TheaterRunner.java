import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Text for the title and subtitle  
    String[][] array1 = {
      {"Porsche", "911s"},
      {"Through", "the Years"}
    };

    // Names of different 911 models  
    String[][] array2 = {
      {"Carrera RS 2.7", "Turbo (930)"},
      {"(993)", "(996)"}
    };

    // Images for cars and engines  
    ImageFilter[][] array3 = {
      { new ImageFilter("car1.png"), new ImageFilter("car2.jpg"), new ImageFilter("car3.jpg"), new ImageFilter("car4.jpg") },
      { new ImageFilter("engine1.jpg"), new ImageFilter("engine2.jpeg"), new ImageFilter("engine3.jpg"), new ImageFilter("engine4.jpg") }
    };

    // Notes and durations for sounds  
    int[][] array4 = {
      {60, 75, 70, 65}, // Notes  
      {1, 2, 3, 4} // Durations  
    };

    // Create and play the scene  
    MyStory scene = new MyStory(array1, array2, array3, array4);
    scene.drawScene();
    Theater.playScenes(scene);
  }
}