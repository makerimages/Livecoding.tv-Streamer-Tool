package net.makerimages.streamertool.ui;

import com.sun.javafx.geom.Vec2f;
import net.makerimages.streamertool.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Makerimages on 7/10/2015.
 */
public class UIButton extends UIElement{

    Image backgroundLeft, backgroundCenter,backgroundRight, backgroundLeftH,backgroundRightH,backgroundCenterH;
    public String label;

    public UIButton(int id, String text, int x , int y) {
        super(id, x, y);

        this.label = text;
        try {
            this.backgroundLeft = ImageIO.read(new File("res/ui/button-left.png"));
            this.backgroundCenter = ImageIO.read(new File("res/ui/button-center.png"));
            this.backgroundRight = ImageIO.read(new File("res/ui/button-right.png"));

            this.backgroundLeftH = ImageIO.read(new File("res/ui/button-left-h.png"));
            this.backgroundCenterH = ImageIO.read(new File("res/ui/button-center-h.png"));
            this.backgroundRightH = ImageIO.read(new File("res/ui/button-right-h.png"));



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.setFont(Main.fontManager.primary);
        if(!hovering) {
            graphics.drawImage(this.backgroundLeft, this.xPos, this.yPos, null);
            graphics.drawImage(this.backgroundCenter, this.xPos + this.backgroundLeft.getWidth(null), this.yPos, graphics.getFontMetrics().stringWidth(this.label) + 20, this.backgroundCenter.getHeight(null), null);
            graphics.drawImage(this.backgroundRight, this.xPos + this.backgroundLeft.getWidth(null) + graphics.getFontMetrics().stringWidth(this.label), this.yPos, null);
        } else {
            graphics.drawImage(this.backgroundLeftH, this.xPos, this.yPos, null);
            graphics.drawImage(this.backgroundCenterH, this.xPos + this.backgroundLeft.getWidth(null), this.yPos, graphics.getFontMetrics().stringWidth(this.label) + 20, this.backgroundCenter.getHeight(null), null);
            graphics.drawImage(this.backgroundRightH, this.xPos + this.backgroundLeft.getWidth(null) + graphics.getFontMetrics().stringWidth(this.label), this.yPos, null);



        }
        graphics.setColor(new Color(0xefefef));
        graphics.drawString(this.label,this.xPos+((this.backgroundLeft.getWidth(null)+graphics.getFontMetrics().stringWidth(this.label)+this.backgroundRight.getWidth(null))/2)-graphics.getFontMetrics().stringWidth(this.label)/2,this.yPos+((this.backgroundRight.getHeight(null)-1/2)-graphics.getFontMetrics().getHeight()/2));
    }

    public Vec2i getCalculateSize(){
        int width = this.backgroundLeft.getWidth(null)+Main.appFrame.getContentPane().getFontMetrics(Main.fontManager.primary).stringWidth(this.label)+this.backgroundRight.getWidth(null);
        int height = this.backgroundCenter.getHeight(null);
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
            clicked = true;
        } else {
            clicked = false;
        }
    }
}
