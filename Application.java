import java.awt.event.*;

public class Application {

    private Renderer renderer;
    private Mouse mouse;
    private Cloth cloth; 

    private boolean isRunning = false; 
    private int lastUpdateTime; // Update and use to handle deltaTime in Update function


    public void Setup(int clothWidth, int clothHeight, int clothSpacing, int windowWidth, int windowHeight) {
        // Create a renderer object and instance of the mouse class:
        renderer = new Renderer(windowWidth, windowHeight);
        mouse = new Mouse();

        // Call Setup on the renderer instance to create a window and renderer
        isRunning = renderer.Setup();

        // Calculate startX, startY positions of Cloth based on the below operations
        clothWidth /= clothSpacing;
        clothHeight /= clothSpacing;

        int startX = (int) (renderer.GetWindowWidth() * 0.5 - clothWidth * clothSpacing * 0.5); // Horiztonally Centered
        int startY = (int) (renderer.GetWindowHeight() * 0.1); // Vertically, 10% from the top

        cloth = new Cloth(clothWidth, clothHeight, clothSpacing, startX, startY);

        lastUpdateTime = 0;
    }

    // Write current state to the mouse
    public void Input() {
        // Add listeners: Mouse Motion, Key, Mouse Button, Scroll Wheel

        // Mouse Motion Listener:
        renderer.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        renderer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    isRunning = false;
                }
            }
        });
        // Mouse Button Listener:
        renderer.addMouseListener(new MouseAdapter() {
            // Mouse Button Down
            @Override
            public void mousePressed(MouseEvent e) {
                // Update Current Position Stored in Mouse
                mouse.UpdatePosition(e.getX(), e.getY());
                
                // Determine if Left or Right Mouse Button is Clicked
                if (!mouse.GetLeftButtonDown() && e.getButton()==1) {
                    mouse.SetLeftMouseButton(true);
                }

                if(!mouse.GetLeftButtonDown() && e.getButton()==2) {
                    mouse.SetRightMouseButton(true);
                }
            }
            // Mouse Button Up
            @Override
            public void mouseReleased(MouseEvent e) {
                // Determine if Left or Right Mouse Button is Released
                if (mouse.GetLeftButtonDown() && e.getButton()==1) {
                    mouse.SetLeftMouseButton(false);
                }

                if(mouse.GetLeftButtonDown() && e.getButton()==2) {
                    mouse.SetRightMouseButton(false);
                }
            }
        });
        // Scroll Wheel Listener:
        renderer.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // Scroll Wheel Up/Away from User
                if (e.getWheelRotation() < 0) {
                    mouse.IncreaseCursorSize(10);
                }
                // Scroll Wheel Down/Away from User
                if (e.getWheelRotation() > 0) {
                    mouse.IncreaseCursorSize(-10);
                }
            }
        });
    }

    public void Render() {
    }

    // Take info from Mouse State -> Update Cloth -> Update Point -> Read and Use State
    public void Update() {
        int currentTime = 0; // Implement method to get current time
        double deltaTime = (currentTime - lastUpdateTime) / 1000.0;

        cloth.Update(renderer, mouse, deltaTime);

        lastUpdateTime = currentTime;
    }

    public void Destroy() {
    }

    public boolean IsRunning() {
        return false;
    }
  

}
