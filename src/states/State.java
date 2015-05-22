package states;

import com.jme3.scene.Node;

public abstract class State
{
    private String name;
    private boolean nextReady = false;
    private State nextState;
    
    // NOTE: rather than renderEnabled, this should be controlEnabled
    // we need to stop the default mouseListener from moving the camera
    private boolean renderEnabled;
    
    public abstract void click(String name, float value, float tpf, Node root);
    
    public String getName()
    {
        return this.name;
    }
    
    public boolean getNextReady()
    {
        return this.nextReady;
    }
    
    public State getNextState()
    {
        return this.nextState;
    }
    
    public boolean getRenderEnabled()
    {
        return this.renderEnabled;
    }
    
    public abstract void render();
    
    public void setName(String stateName)
    {
        this.name = stateName;
    }
    
    public void setNextState(State nextState)
    {
        this.nextReady = true;
        this.nextState = nextState;
    }
    
    public void setRenderEnabled(boolean value)
    {
        this.renderEnabled = value;
    }
    
    public abstract void tick(float tpf);
}