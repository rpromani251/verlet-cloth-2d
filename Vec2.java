public class Vec2 {

    public double x;
    public double y;

    // Overloaded Constructors
    public Vec2() {
    }

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(Vec2 v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void set(double x, double y ) {
        this.x = x;
        this.y = y;
    }

    // "Overload" Math Operators for vector addition/subtraction/multiplication/division
    public void add(Vec2 v) {
        this.x += v.x;
        this.y += v.y;
    }
    public void sub(Vec2 v) {
        this.x -= v.x;
        this.y -= v.y;
    }
    public void mult(Vec2 v) {
        this.x *= v.x;
        this.y *= v.y;
    }
    public void div(Vec2 v) {
        this.x /= v.x;
        this.y /= v.y;
    }

    public void scale(double s) {
        scale(s, s);
    }
    
    public void scale(double sx, double sy) {
        this.x *= sx;
        this.y *= sy;
    }

}
