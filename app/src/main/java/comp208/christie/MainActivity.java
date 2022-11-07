package comp208.christie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    /**
     * drawingView is an instance of the DrawingView class. This instance will represent our allocated drawing space on our android phone screen.
     */
    DrawingView drawingView;

    /**
     * The 12 buttons below (9 colours and 3 styles), are instances of the Button and ImageButton classes respectfully. These buttons will allow use to select different
     * colours and styles for our lines in functions that are specified later.
     */
    Button redBtn;
    Button yellowBtn;
    Button greenBtn;
    Button aquaBtn;
    Button darkBlueBtn;
    Button magentaBtn;
    Button blackBtn;
    Button whiteBtn;
    Button clearBtn;

    ImageButton widePaintBrushBtn;
    ImageButton crayonBtn;
    ImageButton pencilBtn;

    /**
     * The onCreate function is called when the android app is first clicked on and run. This function will display our first activity to the screen, as well as
     * initialize all of our button instances to their respective buttons on the layout design. After being initialized with the buttons on the layout design, a
     * initTools function will be called that will assign a dynamic onCLickListener that will perform a different event depending on the button pressed. the instance
     * of the DrawingView class will set an onTouchListener that will be responsible for different events, such as pressing your thumb on the screen to draw a line by calling
     * the relevant drawing functions in the DrawingView class.
     *
     * @param savedInstanceState - savedInstanceState is an instance of the Bundle class and will hold relevant data in the event that the app needed to be restored to a previous
     *                           state of use.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawingView = findViewById(R.id.drawingView);

        redBtn = findViewById(R.id.redBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        greenBtn = findViewById(R.id.greenBtn);
        aquaBtn = findViewById(R.id.aquaBtn);
        darkBlueBtn = findViewById(R.id.darkBlueBtn);
        magentaBtn = findViewById(R.id.magentaBtn);
        blackBtn = findViewById(R.id.blackBtn);
        whiteBtn = findViewById(R.id.whiteBtn);
        clearBtn = findViewById(R.id.clearBtn);

        widePaintBrushBtn = findViewById(R.id.widePaintBrushBtn);
        crayonBtn = findViewById(R.id.crayonBtn);
        pencilBtn = findViewById(R.id.pencilBtn);

        initTools();

        drawingView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                Log.i("Touch", "Drawing");

                int action = motionEvent.getActionMasked();

                switch (action) {

                    case MotionEvent.ACTION_DOWN:
                        drawingView.beginPath(motionEvent.getX(), motionEvent.getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_UP:
                        drawingView.addPointToPath(motionEvent.getX(), motionEvent.getY());
                        break;

                }

                return true;

            }
        });

    }

    /**
     * btnListener is an onClickListener of type button that will dynamically perform different tasks depending on the buttons the listener is attached to.
     */
    Button.OnClickListener btnListener = new View.OnClickListener() {

        /**
         * onClick is a function that will be called in the event that any buttons with btnListener are clicked. This function will read through a variety of if statements containing
         * conditional expressions for each of the 12 buttons of whether they were pressed or not. In the event that the colour buttons are pressed, a value of 1-8 will be passed
         * as a parameter to the setDrawingColour function and will change the font colour via switch case statements in the DrawingView class. In the event that the clear button is pressed
         * the clearScreen function will be called, which will clear the ArrayList<ColouredPath> in the DrawingView class and will call the invalidate function which will completely remove
         * all lines currently on screen. In the event that the drawing style buttons are pressed, a value of 1-3 will be passed as a parameter to the setDrawingStyle function and will
         * change the font style via switch case statements in the DrawingView class.
         *
         * @param view - view is an instance of the View class and represents any rectangular drawing space used for drawing and event handling.
         */
        @Override
        public void onClick(View view) {

            if (redBtn.isPressed()) {

                Log.i("Tools", "Red Button Pressed");

                drawingView.setDrawingColour(1);

            }
            else if (yellowBtn.isPressed()) {

                Log.i("Tools", "Yellow Button Pressed");

                drawingView.setDrawingColour(2);

            }
                else if (greenBtn.isPressed()) {

                    Log.i("Tools", "Green Button Pressed");

                    drawingView.setDrawingColour(3);

                }
                    else if (aquaBtn.isPressed()) {

                        Log.i("Tools", "Aqua Button Pressed");

                        drawingView.setDrawingColour(4);

                    }
                        else if (darkBlueBtn.isPressed()) {

                            Log.i("Tools", "Dark Blue Button Pressed");

                            drawingView.setDrawingColour(5);

                        }
                            else if (magentaBtn.isPressed()) {

                                Log.i("Tools", "Magenta Button Pressed");

                                drawingView.setDrawingColour(6);

                            }
                                else if (blackBtn.isPressed()) {

                                    Log.i("Tools", "Black Button Pressed");

                                    drawingView.setDrawingColour(7);

                                }
                                    else if (whiteBtn.isPressed()) {

                                        Log.i("Tools", "White Button Pressed");

                                        drawingView.setDrawingColour(8);

                                    }
                                        else if (clearBtn.isPressed()) {

                                            Log.i("Tools", "Clear Button Pressed");

                                            drawingView.clearScreen();

                                        }
                                            else if (widePaintBrushBtn.isPressed()) {

                                                Log.i("Tools", "Wide Paint Brush Button Pressed");

                                                drawingView.setDrawingStyle(1);

                                            }
                                                else if (crayonBtn.isPressed()) {

                                                    Log.i("Tools", "Crayon Button Pressed");

                                                    drawingView.setDrawingStyle(2);

                                                }
                                                    else if (pencilBtn.isPressed()) {

                                                        Log.i("Tools", "Pencil Button Pressed");

                                                        drawingView.setDrawingStyle(3);

                                                    }
        }

    };

    /**
     * The initTools function when called will assign a dynamic onCLickListener that will perform a different event depending on the button pressed.
     */
    private void initTools() {

        redBtn.setOnClickListener(btnListener);
        yellowBtn.setOnClickListener(btnListener);
        greenBtn.setOnClickListener(btnListener);
        aquaBtn.setOnClickListener(btnListener);
        darkBlueBtn.setOnClickListener(btnListener);
        magentaBtn.setOnClickListener(btnListener);
        blackBtn.setOnClickListener(btnListener);
        whiteBtn.setOnClickListener(btnListener);
        clearBtn.setOnClickListener(btnListener);
        widePaintBrushBtn.setOnClickListener(btnListener);
        crayonBtn.setOnClickListener(btnListener);
        pencilBtn.setOnClickListener(btnListener);

    }

}