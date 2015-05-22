package application;

import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.AnalogListener;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.ui.Picture;
import states.State;
import states.StateTitle;
import states.StateTycoon;

public class Main extends SimpleApplication
{
    private static Picture logo;
    private static State STATE;

    public static void main(String[] args)
    {
        setState(new StateTitle(false));
        Main app = new Main();
        app.start();
    }

    private AnalogListener analogListener = new AnalogListener()
    {
        public void onAnalog(String name, float value, float tpf)
        {
            getState().click(name, value, tpf, rootNode);
        }
    };
    
    private void changeState(String oldState)
    {
        if(oldState.equals("TITLE"))
        {
            guiNode.detachChild(logo);
            cam.setLocation(new Vector3f(0f, 50f, 10f));
            cam.lookAt(new Vector3f(0f, 0f, 0f), Vector3f.UNIT_Y);
        }
    }
    
    public static State getState()
    {
        return STATE;
    }
    
    public void initInput()
    {
        inputManager.addMapping("Click", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        inputManager.addListener(analogListener, "Click");
    }

    @Override
    public void simpleInitApp()
    {
        // Earth Geometry
        Geometry earth_g = new Geometry("Earth", new Box(50, 1, 50));
        Material earth_m = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        earth_m.setTexture("ColorMap", assetManager.loadTexture("Textures/grass2.png"));
        earth_g.setMaterial(earth_m);
        earth_g.setLocalTranslation(2.0f, -2.5f, 0.0f);
        rootNode.attachChild(earth_g);
        
        // Logo
        logo = new Picture("PictureLogo");
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
        
        // Custom Input
        initInput();
    }

    @Override
    public void simpleUpdate(float tpf)
    {
        if(getState().getNextReady())
        {
            changeState(getState().getName());
            setState(getState().getNextState());
        }
        else
        {
            getState().tick(tpf);
        }
    }

    @Override
    public void simpleRender(RenderManager rm)
    {
        getState().render();
        
        // This keeps things moving (may want to disable/enable this at times)
        //if(STATE.getRenderEnabled()) {super.simpleRender(rm);}
    }
    
    public static void setState(State newState)
    {
        STATE = newState;
    }
    
}