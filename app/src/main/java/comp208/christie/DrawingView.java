package comp208.christie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * DrawingView is a class that inherits the View class. This class will contain all relevant
 * data when creating and storing the lines (paths) changing the colour and style of a line,
 * as well as clearing the screen.
 */
public class DrawingView extends View {

    /**
     * A new instance of the paint class is initialized and will be responsible for holding
     * data such as the colour and stroke width. path is an instance of the ColouredPath class
     * which inherits the Path class and is responsible for the specific line being drawing.
     * Each new line can contain a different colour and style. paths is ArrayList of type
     * ColouredPath and contains all of the different lines (path) inside of it. Clearing this
     * ArrayList would remove all of the lines (path) from the user interface.
     */
    Paint paint = new Paint();
    ColouredPath path;
    ArrayList<ColouredPath> paths = new ArrayList<>();

    /**
     * DrawingView is the constructor for the DrawingView class. This constructor will
     * initialize the instance of the Paint class with a default value from the colour and
     * style before the user is given the option to change it to a different one.
     *
     * @param context - Context contains data that is defined by the android system. Context
     *                provides the connection to the Android system and the resources of the
     *                project.
     *
     * @param attribSet - attribSet allows direct access to resouces such as the values
     *                  of the XML document defining the design layout (user interface).
     */
    public DrawingView(Context context, @Nullable AttributeSet attribSet) {

        super(context, attribSet);

        paint.setColor(Color.RED);
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);

    }

    /**
     * beginPath is a function that is called when the user places their finger on the
     * drawing area of the screen to begin a new line. The beginning of the line will be placed
     * at the specific x and y coordinates of the drawing area. This information will be moved to
     * and save to the ArrayList.
     *
     * @param x - x contains the horizontal coordinates of the drawing area.
     * @param y - y contains the vertical coordinates of the drawing area.
     */
    public void beginPath(float x, float y) {

        path = new ColouredPath();
        path.colour = paint.getColor();
        path.style = paint.getStrokeWidth();

        Log.i("Colour", "Colour: " + path.colour);

        path.moveTo(x, y);
        paths.add(path);

    }

    /**
     * addPointToPath is a function that is called when the user places their finger on the
     * drawing area of the screen and it is not their first time doing so. If the path is empty
     * then a new line will be created, otherwise the line will be connected to the line that
     * occupies those coordinates.
     *
     * @param x - x contains the horizontal coordinates of the drawing area.
     * @param y - y contains the vertical coordinates of the drawing area.
     */
    public void addPointToPath(float x, float y) {

        if (path.isEmpty())
            path.moveTo(x, y);
        else
            path.lineTo(x, y);

        invalidate();

    }

    /**
     * onDRaw is a function automatically called by the View class. This function will draw
     * each instance of the ColouredPath class inside of the ColouredPath ArrayList paths on to
     * the canvas with their specified coloured and style.
     *
     * @param canvas - canvas is referencing the drawing area, and will be used to draw the lines
     *               on to the screen.
     */
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        for (ColouredPath path : paths) {

            paint.setColor(path.colour);
            paint.setStrokeWidth(path.style);
            canvas.drawPath(path, paint);

        }
    }

    /**
     * setDrawingColour receives a parameter of type int which contains a value of 1-8 depending
     * on which colour button was pressed. This colour will parameter will be used in a switch
     * case statement to change the colour for the instance of the Paint class.
     *
     * @param colour - colour contains an integer between 1-8 that was received from the onCLickListener
     *               when one of the colour buttons was pressed.
     */
    public void setDrawingColour(int colour) {

        switch (colour) {
            case 1:
                paint.setColor(Color.rgb(255, 0, 0));
                break;
            case 2:
                paint.setColor(Color.rgb(255, 255, 0));
                break;
            case 3:
                paint.setColor(Color.rgb(0, 255, 0));
                break;
            case 4:
                paint.setColor(Color.rgb(3, 253, 252));
                break;
            case 5:
                paint.setColor(Color.rgb(0, 0, 139));
                break;
            case 6:
                paint.setColor(Color.rgb(255, 0, 255));
                break;
            case 7:
                paint.setColor(Color.rgb(0, 0, 0));
                break;
            case 8:
                paint.setColor(Color.rgb(255, 255, 255));
                break;
        }

    }

    /**
     * setDrawingStyle receives a parameter of type int which contains a value of 1-3 depending
     * on which style button was pressed. This style will parameter will be used in a switch
     * case statement to change the style for the instance of the Paint class.
     *
     * @param style - style contains an integer between 1-e that was received from the onCLickListener
     *              when one of the style buttons was pressed.
     */
    public void setDrawingStyle(int style) {

        switch (style) {
            case 1:
                paint.setStrokeWidth(12);
                break;
            case 2:
                paint.setStrokeWidth(8);
                break;
            case 3:
                paint.setStrokeWidth(4);
                break;
        }

    }

    /**
     * clearScreen is a function that is responsible for clearing the canvas so the user can begin
     * a new drawing. It does this by clearing the ArrayList of type ColouredPath which removes
     * all lines coordinates, colour, style, etc. removing from the user interface. If the
     * invalidate function is not called, the user interface will be cleared but the screen
     * won't be updated until onDraw function is called when the user begins drawing a new line.
     * To circumvent this, the invalidate function will be called so the user interface is cleared
     * immediately after the button is pressed.
     */
    public void clearScreen() {

        paths.clear();
        invalidate();

    }

}