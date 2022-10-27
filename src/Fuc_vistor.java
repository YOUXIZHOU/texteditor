import java.lang.reflect.Type;

public class Fuc_vistor implements Vistor{
    String text;
    public Type visit(Find f){
        f.feature(text);
        return null;
    }
    public Type visit(replace rp){
        rp.feature(text);
        return null;
    }
    public void inputtext(String t){
        this.text = t;
    }
}
