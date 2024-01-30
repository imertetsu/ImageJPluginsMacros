import ij.IJ;
import ij.plugin.PlugIn;

public class HelloWorld_ implements PlugIn {
    @Override
    public void run(String s) {
        IJ.showMessage("Hellow World");
    }
}
