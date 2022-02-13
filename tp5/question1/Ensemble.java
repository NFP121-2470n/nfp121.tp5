package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t) {
        if(table.contains(t)){return false;}
        else{table.add(t);return true;}
        
    }

    public Ensemble<T> union(Ensemble<? extends T> e) {
        this.addAll(e); 
        return this;
    }

    public Ensemble<T> inter(Ensemble<? extends T> e) {
            if(e.contains(table)){
            Ensemble<T> e1=new Ensemble<T>();
            e1.addAll(e);
            return e1;
            }
            else{return null;}
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
         Ensemble<T> e1=new Ensemble<T>();
         e1.addAll(table);
         e1=inter(e);
         this.removeAll(e1);
         return this;
    }

    Ensemble<T> diffSym(Ensemble<? extends T> e) {
    Ensemble<T> e1=new Ensemble<T>();
    Ensemble<T> e2=new Ensemble<T>();
         e1.addAll(table);
         e1=inter(e);
         e2=union(e);
         e2.removeAll(e1);
          return e2;
    }
    
}
