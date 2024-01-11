public class Main { 

    public static void main(String[] args) {
        // Create app instance of application class, encapsulating the logic of the entire application
        Application app = new Application();

        app.Setup(1200, 320, 10, 1400, 500); // Create cloth with width: 1200, height: 320, spacing: 10;

        // Simple Game Loop: (1) Gather User Input, (2) State Updates, (3) Render Current State
        while (app.IsRunning()) {
            app.Input();
            app.Update();
            app.Render();
        }

        app.Destroy(); // User Input ESCAPE --> Sets all internal objects created using keyword new to be cleaned up by garbage collector
    }
   
}