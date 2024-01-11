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
    }

    // Write current state to the mouse
    public void Input() {

    }

    public void Render() {
    }

    public void Update() {
    }



    public void Destroy() {
    }

    public boolean IsRunning() {
        return false;
    }
  

}
