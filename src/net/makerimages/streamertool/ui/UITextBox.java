package net.makerimages.streamertool.ui;

import net.makerimages.streamertool.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by Makerimages on 7/13/2015.
 */
public class UITextBox extends UIElement {

    Image backgroundLeft, backgroundCenter,backgroundRight;
    public int width;
    public boolean focused;
    public String text, realText;
    public boolean hidden = false;

    public UITextBox(int id, int x, int y, int w, boolean hidden,String startText) {
        super(id, x, y);
        this.width = w;
        this.hidden = hidden;

        this.text=startText;
        this.realText = this.text;
        if(hidden) {
        	this.text = "";
        	for(int i = 0; i < this.realText.length();i++) {
        		this.text = this.text+"*";
        	}
        }
        try {
            this.backgroundLeft = ImageIO.read(new File("res/ui/text-left.png"));
            this.backgroundCenter = ImageIO.read(new File("res/ui/text-center.png"));
            this.backgroundRight = ImageIO.read(new File("res/ui/text-right.png"));

          /*  this.backgroundLeftH = ImageIO.read(new File("res/ui/button-left-h.png"));
            this.backgroundCenterH = ImageIO.read(new File("res/ui/button-center-h.png"));
            this.backgroundRightH = ImageIO.read(new File("res/ui/button-right-h.png"));*/



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.setFont(Main.fontManager.primarySmaller);
        graphics.drawImage(this.backgroundLeft, this.xPos, this.yPos, null);
        graphics.drawImage(this.backgroundCenter, this.xPos + this.backgroundLeft.getWidth(null), this.yPos, this.width, this.backgroundCenter.getHeight(null), null);
        graphics.drawImage(this.backgroundRight, this.xPos + this.backgroundLeft.getWidth(null) + this.width, this.yPos, null);
        Rectangle whole = graphics.getClipBounds();
        Rectangle textBounds = new Rectangle(this.xPos + 7, this.yPos, this.getCalculateSize().x-this.backgroundRight.getWidth(null)+7, this.getCalculateSize().y);
        graphics.setClip(textBounds);
        FontMetrics fm = graphics.getFontMetrics();
        int textWidth = fm.stringWidth(this.text + "|");
        int offset = Math.max(0, textWidth - textBounds.width);
        graphics.setColor(Color.WHITE);
        graphics.drawString(this.text, this.xPos + 7 - offset, this.yPos + (this.backgroundCenter.getHeight(null) - 11 / 2) - (graphics.getFontMetrics().getHeight()/2));
        if(focused) {
            graphics.drawString("|",this.xPos+7+fm.stringWidth(this.text) - offset,this.yPos + (this.backgroundCenter.getHeight(null) - 11 / 2) - (graphics.getFontMetrics().getHeight()/2));
        }
        graphics.setClip(whole);

    }

    public Vec2i getCalculateSize(){
        int width = this.backgroundLeft.getWidth(null)+this.width+this.backgroundRight.getWidth(null);
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

    @Override
    public void keyEvent(KeyEvent e) {
        if(this.focused) {
            if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                textEntered('ä');

            } else {
                textEntered(e.getKeyChar());

            }

        }
        super.keyEvent(e);
    }

    public void textEntered(char c) {
        if (c == 'ä') {
        	if(!hidden) {
        		 if (this.text.length() > 0) {
                     this.text = this.text.substring(0, this.text.length() - 1);
                 }
        	} else {
        		if (this.text.length() > 0) {
                    this.text = this.text.substring(0, this.text.length() - 1);
                    this.realText = this.realText.substring(0, this.realText.length() - 1);

                }
        	}
           
        } else {
        	if(!hidden) {
        		this.text = this.text + c;
        	} else {
        		this.text = this.text + '*';
        		this.realText = this.realText + c;
        	}
        }
    }
}
