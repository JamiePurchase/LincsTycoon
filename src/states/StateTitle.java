package states;

import static application.Main.getState;
import com.jme3.font.BitmapText;
import com.jme3.scene.Node;

public class StateTitle extends State
{
    
    public StateTitle(boolean render)
    {
        super.setName("TITLE");
        super.setRenderEnabled(render);
    }

    @Override
    public void click(String name, float value, float tpf, Node root)
    {
        if(name.equals("Click"))
        {
            root.detachChildNamed("PictureLogo");
            super.setNextState(new StateTycoon(true));
        }
    }
    
    public void render()
    {
        
    }
    
    public void tick(float tpf)
    {
        
    }
    
}