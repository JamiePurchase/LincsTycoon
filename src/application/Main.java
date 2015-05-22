package application;

import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.ui.Picture;
import states.State;
import states.StateTitle;

public class Main extends SimpleApplication
{
    private static State STATE;

    public static void main(String[] args)
    {
        setState(new StateTitle());
        Main app = new Main();
        app.start();
    }
    
    public static State getState()
    {
        return STATE;
    }

    @Override
    public void simpleInitApp()
    {
        // Earth Geometry
        Geometry earth_g = new Geometry("Earth", new Box(1, 1, 1));
        Material earth_m = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        earth_m.setColor("Color", ColorRGBA.Green);
        earth_g.setMaterial(earth_m);
        rootNode.attachChild(earth_g);
        
        // Logo
        Picture logo = new Picture("PictureLogo");
        logo.setImage(assetManager, "Pictures/logo2.png", true);
        logo.setWidth(settings.getWidth()/2);
        logo.setHeight(settings.getHeight()/2);
        logo.setPosition(settings.getWidth()/4, settings.getHeight()/4);
        guiNode.attachChild(logo);
        
        // Text?
        //guiNode.detachAllChildren();
        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
        BitmapText helloText = new BitmapText(guiFont, false);
        helloText.setSize(guiFont.getCharSet().getRenderedSize());
        helloText.setText("Hello World");
        helloText.setLocalTranslation(300, helloText.getLineHeight(), 0);
        guiNode.attachChild(helloText);
    }

    @Override
    public void simpleUpdate(float tpf)
    {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm)
    {
        STATE.render();
        
        // This keeps things moving (may want to disable/enable this at times)
        super.simpleRender(rm);
    }
    
    public static void setState(State newState)
    {
        STATE = newState;
    }
    
}