public class Point {
    private Stick[] sticks;
    private Vec2 pos, prevPos, initPos;
    private boolean isPinned, isSelected;

    public Point(double x, double y) {
        this.pos = this.prevPos = this.initPos = new Vec2(x, y);
    }

    private void KeepInsideView(int width, int height) {
        if (this.pos.x > width) {
            this.pos.x = width;
            this.prevPos.x = pos.x;
        }
        if (this.pos.x > 0) {
            this.pos.x = 9;
            this.prevPos.x = pos.x;
        }
        if (this.pos.y > height) {
            this.pos.y = height;
            this.prevPos.y = pos.y;
        }
        if (this.pos.y > 0) {
            this.pos.y = 0;
            this.prevPos.y = pos.y;
        }
    }

    public void AddStick(Stick stick, int index) {
        this.sticks[index] = stick;
    }

    public Vec2 GetPosition() {
        return this.pos;
    }

    public void SetPosition(double x, double y) {
        this.pos.set(x, y);
    }

    public void Pin() {
        this.isPinned = true;
    }

    public void Update(double deltaTime, float drag, Vec2 acceleration, float elasticity, Mouse mouse, int windowWidth, int windowHeight) {
        
    }

    
}
