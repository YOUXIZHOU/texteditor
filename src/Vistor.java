import java.lang.reflect.Type;

public interface Vistor {
    Type visit(Find f);
    Type visit(replace rp);
}
