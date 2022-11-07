package comp208.christie;

import android.graphics.Path;

/**
 * ColouredPath is a class that extends the Path class. This class contains extra information for the path
 * such as the colour that is being used, as well as the style being used. These values will be used in tandem
 * with an instance of the Paint class.
 */
public class ColouredPath extends Path {

    int colour;
    float style;

}
