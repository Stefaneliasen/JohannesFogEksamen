
package FunctionLayer;

import DBAccess.ProductMapper;
import entity.Material;
import java.util.ArrayList;


public class ShedCalculator {
        ProductMapper pm = new ProductMapper();
        
        //LENGTH SKAL RETTES TIL SKURETS LÆNGDE!!
    public static void main(String[] args) throws CarportException {
        ShedCalculator shed = new ShedCalculator();
        int length = 780;
        int width = 600;
        int height = 230;
        shed.lægteBagsideDør(length, width, height);
        shed.shedMaterial(length, width, height);
    }
        
 public Material lægteBagsideDør(int sLength, int width, int height) throws CarportException {
        // "til z på bagside af	dør"
        // døren vil altid have samme størrelse. derfor en fast længde
        int stk1width = 420;
        String pname = pm.getMaterialById(3).getPname();
        int price = pm.getMaterialById(3).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(3);
        mat.setAmount(1); 
        mat.setLength(stk1width);
        return mat;
    }
 public Material løsholtergavl(int sLength, int width, int height) throws CarportException {
        // "løsholter til skur gavle"
        // skuret starter 35 cm inde i hver side, derfor -70. deles med 2 fordi der er en stolpe i midten.
        int stk1width = (width - 70)/2;
        String pname = pm.getMaterialById(4).getPname();
        int price = pm.getMaterialById(4).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(4);
        //
        mat.setAmount(12);
        mat.setLength(stk1width);
        return mat;
    }
 public Material løsholterside(int sLength, int width, int height) throws CarportException {
        // "løsholter til skur gavle"
        // skuret starter 35 cm inde i hver side, derfor -70. deles med 2 fordi der er en stolpe i midten.
        String pname = pm.getMaterialById(4).getPname();
        int price = pm.getMaterialById(4).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(4);
        //bankes direkte i rem
        mat.setAmount(4);
        mat.setLength(sLength);
        return mat;
    }
 public Material remmeISider(int sLength, int width, int height) throws CarportException {
        // Remme i sider, sadles ned i stolper
        String pname = pm.getMaterialById(5).getPname();
        int price = pm.getMaterialById(5).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(5);
        //hvorfor skal der bruges 1?? skur del, deles??
        mat.setAmount(1);
        //forstår ikke length er 480 når siden er 530 og der kun skal bruges 1.
        mat.setLength(sLength);
        return mat;
    }
 public Material brætTilSkur(int sLength, int width, int height) throws CarportException {
        // Til beklædning af skur
        String pname = pm.getMaterialById(7).getPname();
        int price = pm.getMaterialById(7).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(7);
        //Length og width divideres med 10, da brædderne er 10 cm i bredde.
        int amount = (int) Math.ceil(((sLength / 5) * 2) + ((width / 5) * 2)); 
        mat.setAmount(amount);
        mat.setLength(height);
        return mat;
    }
 public Material yderBeklædningSkruerTilSkur(int sLength, int width, int height) throws CarportException {
        // til montering af yderste beklædning
        String pname = pm.getMaterialById(16).getPname();
        int price = pm.getMaterialById(16).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(16);
        //Antallet af brædder til ydre beklædning * med 4, fordi der bruges 4 skruer pr. bræt
        int amount = (int) Math.ceil((brætTilSkur(sLength, width, height).getAmount() * 4)/400);
        mat.setAmount(amount);
        return mat;
}
 public Material inderBeklædningSkruerTilSkur(int sLength, int width, int height) throws CarportException {
        // til montering af yderste beklædning
        String pname = pm.getMaterialById(17).getPname();
        int price = pm.getMaterialById(17).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(17);
        //Antallet af brædder til inder beklædning * med 3, fordi der bruges 3 skruer pr. bræt
        int amount = (int) Math.ceil((brætTilSkur(sLength, width, height).getAmount() * 3)/300);
        mat.setAmount(amount);
        return mat;
}
 public Material stalddørsgrebTilSkur(int sLength, int width, int height) throws CarportException {
        // Til lås på dør til skur
        String pname = pm.getMaterialById(18).getPname();
        int price = pm.getMaterialById(18).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(18);
        //Der skal kun bruges en lås/greb til 1 dør
        mat.setAmount(1);
        return mat;
}
 public Material tHængselTilSkur(int sLength, int width, int height) throws CarportException {
        // Til skurdør
        String pname = pm.getMaterialById(19).getPname();
        int price = pm.getMaterialById(19).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(19);
        //Bruges kun 2 hængsler til 1 dør.
        mat.setAmount(2);
        return mat;
}
public Material vinkelBeslagTilSkur(int sLength, int width, int height) throws CarportException {
        // Til montering af løsholter i skur
        String pname = pm.getMaterialById(16).getPname();
        int price = pm.getMaterialById(16).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(16);
        // Bruges 2 vinkelbeslag pr. løsholter
        int amount = (løsholtergavl(sLength, width, height).getAmount() + løsholterside(sLength, width, height).getAmount()) * 2; ;
        mat.setAmount(amount);
        return mat;
}
public ArrayList<Material> shedMaterial (int sLength, int width, int height) throws CarportException {
        ArrayList<Material> shedMaterials = new ArrayList();
        shedMaterials.add(lægteBagsideDør(sLength, width, height));
        shedMaterials.add(løsholtergavl(sLength, width, height));
        shedMaterials.add(løsholterside(sLength, width, height));
        shedMaterials.add(remmeISider(sLength, width, height));
        shedMaterials.add(brætTilSkur(sLength, width, height));
        shedMaterials.add(yderBeklædningSkruerTilSkur(sLength, width, height));
        shedMaterials.add(inderBeklædningSkruerTilSkur(sLength, width, height));
        shedMaterials.add(stalddørsgrebTilSkur(sLength, width, height));
        shedMaterials.add(tHængselTilSkur(sLength, width, height));
        shedMaterials.add(vinkelBeslagTilSkur(sLength, width, height));
        return shedMaterials;
}
}