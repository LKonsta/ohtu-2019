
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class Not implements Matcher {
    
    public Matcher m;
    
    public Not(Matcher m) {
       this.m = m;
    }

    @Override
    public boolean matches(Player p) {
        return !m.matches(p);    
        
    }    
    
}
