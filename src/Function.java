import java.lang.reflect.Type;

public interface Function {
    public Type accept(Vistor v);
}
