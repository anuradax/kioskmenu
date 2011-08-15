package kioskfx;

import javafx.application.*;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.animation.*;
import javafx.util.*;
import java.util.*;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.geometry.*;
import javafx.scene.transform.*;
import javafx.scene.effect.*;
import javafx.scene.text.*;

public class KiSection {
    
    private String title;
    private KiGlass glass;
    private SimpleDoubleProperty order;
    private SimpleDoubleProperty width;
    private SimpleDoubleProperty height;
    //private Image image;
    private ImageView imageView;
    private SimpleDoubleProperty opacity;
    private Vector <KiAction>actions;
    
    public KiSection() {
        title = "";
        imageView = new ImageView();
        actions=new  Vector <KiAction>();
        //Image it=new Image(this.getClass().getResourceAsStream("section.png"));
        //System.out.println(it.getHeight());
        //imageView.setImage(it);
        //image = null;
        order = new SimpleDoubleProperty(0);
        width = new SimpleDoubleProperty(100);
        height = new SimpleDoubleProperty(60);
        opacity = new SimpleDoubleProperty(1.0);
        
        glass = new KiGlass().width(width).height(height).opacity(opacity);
        glass.node().translateXProperty().bind(width.add(16).multiply(order));
        
        image(new Image(this.getClass().getResourceAsStream("section.png")));
        
    }
public KiSection action(KiAction it) {
    it.order(actions.size());
        actions.add(it);
        return this;
    }
public Vector <KiAction> actions() {
        
        return actions;
    }
    public KiSection opacity(double nn) {
        //System.out.println(nn);
        opacity.set(nn);
        return this;
    }
 public KiSection active(boolean nn) {
        glass.active(nn);
        return this;
    }
    public KiSection title(String it) {
        this.title = it;
        return this;
    }
    
    public String title() {
        
        return title;
    }
    
    public KiSection width(DoubleProperty it) {
        width.bind(it);
        return this;
    }
    
    public KiSection height(DoubleProperty it) {
        height.bind(it);
        return this;
    }
    
    public KiSection onSelect(KiJob it) {
        glass.onSelect(it);
        return this;
    }
    
    public KiSection order(int it) {
        order.set(it);
        return this;
    }
    
    public KiSection image(Image it) {
        //order.set(it);

        
        imageView.setImage(it);
        glass.content(imageView);
        return this;
    }
    
    public Node node() {
        return glass.node();
    }
}