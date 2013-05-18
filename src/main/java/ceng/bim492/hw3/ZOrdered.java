package ceng.bim492.hw3;

import com.codometer.homework.bim460.homework6.Homework6Helper;
import com.codometer.homework.bim460.homework6.ZOrderable;
import com.codometer.homework.bim460.homework6.annotations.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * User: ali
 * Date: 5/4/13
 * Time: 7:30 PM
 */

@ZOrderedCompositeComponent
@Component(type = "Z-ORDERED")
public class ZOrdered implements ZOrderable {


    private Set<ZOrderable> children;
    private int z = 0 ;

    public ZOrdered() {
        children = new TreeSet<ZOrderable>(new Comparotorofmine());

    }


    private class Comparotorofmine implements Comparator<ZOrderable> {

        @Override
        public int compare(ZOrderable o1, ZOrderable o2) {
            return Integer.valueOf(o2.getZ()).compareTo(Integer.valueOf(o1.getZ()));         }
    }
    @Override
    @SetZOrder
    public void setZ(int i) {
        this.z = i ;
    }

    @Override
     @GetZOrder
    public int getZ() {
      return this.z;
    }
    @AddComponent
    public void addChild(ZOrderable child) {

          children.add(child);

    }

    @RemoveComponent
    public void removeChild(ZOrderable child) {
        children.remove(child);
    }

    @Operation
    public void paint(){
        Homework6Helper.paint(this);

        for (ZOrderable child:this.children){

        if(child.getClass().isAnnotationPresent(Component.class)){
            Method[] methods = child.getClass().getMethods();
            for (Method m:methods) {

                if(m.isAnnotationPresent(Operation.class)){
                    try {
                        m.invoke(child, null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    }



}
