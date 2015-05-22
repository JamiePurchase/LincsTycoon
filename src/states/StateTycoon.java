package states;

import static application.Main.getState;
import com.jme3.scene.Node;

public class StateTycoon extends State
{
    
    public StateTycoon(boolean render)
    {
        super.setName("TYCOON");
        super.setRenderEnabled(render);
    }

    @Override
    public void click(String name, float value, float tpf, Node root)
    {
        //
    }
    
    public void render()
    {
        //
    }
    
    public void tick(float tpf)
    {
        //
    }
    
}