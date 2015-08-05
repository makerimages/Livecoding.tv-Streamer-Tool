package net.makerimages.streamertool.ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Makerimages on 7/13/2015.
 */
public class UICheckbox extends UIElement {

    private Image off, on;
    public boolean state;
    public UICheckbox(int id, int x, int y) {
        super(id, x, y);
        try {
            off = ImageIO.read(new File("res/ui/checkbox-off.png"));
            on = ImageIO.read(new File("res/ui/checkbox-on.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        if(!state) {
            graphics.drawImage(off,this.xPos,this.yPos+2,null);
        } else {
            graphics.drawImage(on,this.xPos,this.yPos+2,null);

        }
        super.draw(graphics);
    }

    public Vec2i getCalculateSize(){
        int width =34;
        int height = 34;
        return new Vec2i(width,height);
    }

    public Rectangle getBounds(){
        return new Rectangle(this.xPos,this.yPos,getCalculateSize().x,getCalculateSize().y);
    }

    @Override
    public void hoverCheck(int mouseX, int mouseY) {
        super.hoverCheck(mouseX, mouseY);
        if(this.getBounds().contains(mouseX,mouseY)) {
            hovering = true;
        } else {
            hovering = false;
        }

    }

    @Override
    public void clickCheck(int button) {
        super.clickCheck(button);
        if(button == 1 && hovering) {
            state = !state;
        }
    }
}
