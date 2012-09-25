package ComLib;

import java.util.ArrayList;

/**
 *
 * @author Gerjo Meier
 */
public interface InterfaceZeppelinListener {
    public void onZeppelinConnected(ComThread zeppelinProbe);
    public ArrayList<ComThread> getComProbes();

    public void setStatusText(String status);
    //public ArrayList<ComProbe> ComProbes = new ArrayList<ComProbe>();
}
