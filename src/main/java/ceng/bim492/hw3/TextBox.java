package ceng.bim492.hw3;

import com.codometer.homework.bim460.homework6.Homework6Helper;
import com.codometer.homework.bim460.homework6.ZOrderable;
import com.codometer.homework.bim460.homework6.annotations.Component;
import com.codometer.homework.bim460.homework6.annotations.GetZOrder;
import com.codometer.homework.bim460.homework6.annotations.Operation;
import com.codometer.homework.bim460.homework6.annotations.SetZOrder;

/**
 * User: ali
 * Date: 5/4/13
 * Time: 7:29 PM
 */
@Component(type = "TEXTBOX")
public class TextBox implements ZOrderable {
      private int z = 0 ;

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

    @Operation
    public void  paint(){

        Homework6Helper.paint(this);
    }
}
