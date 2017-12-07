/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.ProductMapper;
import entity.Material;
import java.util.ArrayList;

/**
 *
 * @author Mathias
 */
public class CarportCalculator {

    ProductMapper pm = new ProductMapper();

    public static void main(String[] args) throws CarportException {
        CarportCalculator cvasga = new CarportCalculator();
        int length = 0;
        int width = 0;
        int height = 0;
        cvasga.brædderSiderne(length, width, height);
        cvasga.brædderForOgBag(length, width, height);
    }

    public Material brædderForOgBag(int length, int width, int height) throws CarportException {
        // Understernbrædder til for & bag ende
        // +5 da sternbrædderne rækker 2,5cm udover spærrene hver side
        int stk1width = width + 5;
        String pname = pm.getMaterialById(1).getPname();
        int price = pm.getMaterialById(1).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(1);
        mat.setAmount(4);
        mat.setLength(stk1width);
        return mat;
    }

    public Material brædderSiderne(int length, int width, int height) throws CarportException {
        //Understernbrædder til siderne.
        String pname = pm.getMaterialById(1).getPname();
        int price = pm.getMaterialById(1).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(1);
        mat.setAmount(2);
        mat.setLength(length);
        return mat;
    }

    public Material oversternBrædderForenden(int length, int width, int height) throws CarportException {
        //Oversternbrædder til forenden
        //
        // TJEK LIGE GAMMELT PROJEKT om l er rigtig
        String pname = pm.getMaterialById(2).getPname();
        int price = pm.getMaterialById(2).getPrice();
        Material mat = new Material(pname, price);
        // int l = width + 5;
        mat.setId(2);
        mat.setAmount(2);
        mat.setLength(width);
        return mat;
    }

    public Material oversternBrædderSiderne(int length, int width, int height) throws CarportException {
        // oversternbrædder til siderne
        String pname = pm.getMaterialById(2).getPname();
        int price = pm.getMaterialById(2).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(2);
        mat.setAmount(4);
        mat.setLength(length);
        return mat;
    }

    public Material remISider(int length, int width, int height) throws CarportException {
        // Remme i sider, sadles ned i stolper
        // der bruges 1 rem til hver ende af carporten.
        String pname = pm.getMaterialById(5).getPname();
        int price = pm.getMaterialById(5).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(5);
        mat.setAmount(2);
        mat.setLength(width);
        return mat;
    }

    public Material spaer(int length, int width, int height) throws CarportException {
        // "Spær, monteres på rem"
        String pname = pm.getMaterialById(5).getPname();
        int price = pm.getMaterialById(5).getPrice();
        Material mat = new Material(pname, price);
        //1 spær placeres i starten, og derfor ikke regnet med i divisionstykket. Derfor +1
        int amount = (int) Math.round(length / 55)+1;
        mat.setId(5);
        mat.setAmount(amount);
        mat.setLength(width);
        return mat;
    }

    public Material stolper(int length, int width, int height) throws CarportException {
        // "97x97 mm. trykimp. Stolpe"
        // stolperne graves 90cm ned i jorden, så de skal være 90cm længere end højden
        String pname = pm.getMaterialById(6).getPname();
        int price = pm.getMaterialById(6).getPrice();
        Material mat = new Material(pname, price);
        int l = height + 90;
        mat.setId(6);
        mat.setLength(l);
        int amount = (int) Math.ceil((length-130) / 310) * 2;
        if (length < 430) {
            mat.setAmount(4);
        } else {
            mat.setAmount(4+amount);
        }
        return mat;
    }
    public Material vandbrætSide(int length, int width, int height) throws CarportException {
        //"vandbrædt på stern i sider"
        String pname = pm.getMaterialById(7).getPname();
        int price = pm.getMaterialById(7).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(7);
        mat.setAmount(4);
        mat.setLength(length);
        return mat;
    }

    public Material vandbrætFor(int length, int width, int height) throws CarportException {
        // "vandbrædt på stern i forende"
        String pname = pm.getMaterialById(7).getPname();
        int price = pm.getMaterialById(7).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(7);
        mat.setAmount(2);
        mat.setLength(width);
        return mat;
    }

    public Material tagPladeStor(int length, int width, int height) throws CarportException {
        // "Plastmo Ecolite blåtonet"
        String pname = pm.getMaterialById(8).getPname();
        int price = pm.getMaterialById(8).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(8);
        if (length >= 501) {
            // mål på tagplader 109x360
            int a = (int) (Math.ceil(width / 109) + Math.ceil(length / 600));
            mat.setAmount(a);
        } else {
            mat.setAmount(0);
        }
        mat.setLength(600);
        return mat;
    }

    public Material tagPladeLille(int length, int width, int height) throws CarportException {
        // "Plastmo Ecolite blåtonet"
        String pname = pm.getMaterialById(8).getPname();
        int price = pm.getMaterialById(8).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(8);
        if (length >= 240 && length <= 500) {
            // mål på tagplader 109x360
            int a = (int) (Math.ceil(width / 109) + Math.ceil(length / 360));
            mat.setAmount(a);
        } else {
            mat.setAmount(0);
        }
        mat.setLength(360);
        return mat;
    }
    //Screws

    public Material tagPladeSkruer(int length, int width, int height) throws CarportException {
        // "plastmo bundskruer 200 stk."
        String pname = pm.getMaterialById(9).getPname();
        int price = pm.getMaterialById(9).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(9);
        int amount = 0;
        if (length <= 240) {
            amount = 1;
        } else if (length >= 241 && length < 500) {
            amount = 2;
        } else if (length >= 501 && length < 780) {
            amount = 3;
        }
        mat.setAmount(amount);
        return mat;
    }

    public Material hulbaand(int length, int width, int height) throws CarportException {
        // "hulbånd 1x20 mm. 10 mtr."
        String pname = pm.getMaterialById(10).getPname();
        int price = pm.getMaterialById(10).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(10);
        double w = width / 100;
        double l = length / 100;
        double a = Math.sqrt(Math.pow(w, 2) + Math.pow(l, 2));
        int amount = (int) Math.ceil(((a * 2) / 10));
        mat.setAmount(amount);
        return mat;
    }

    public Material universalBeslagHøjre(int length, int width, int height) throws CarportException {
        // "universal 190 mm højre"
        String pname = pm.getMaterialById(11).getPname();
        int price = pm.getMaterialById(11).getPrice();
        Material mat = new Material(pname, price);
        int amount = (int) Math.ceil(length / 55);
        mat.setAmount(amount);
        mat.setId(11);
        return mat;
    }

    public Material universalBeslagVenstre(int length, int width, int height) throws CarportException {
        // "universal 190 mm højre"
        String pname = pm.getMaterialById(11).getPname();
        int price = pm.getMaterialById(11).getPrice();
        Material mat = new Material(pname, price);
        int amountOfMaterial = (int) Math.ceil(length / 55);
        mat.setAmount(amountOfMaterial);
        mat.setId(11);
        return mat;
    }

    public Material skruerSternOgVandbræt(int length, int width, int height) throws CarportException {
        // "4,5 x 60 mm. skruer 200 stk."
        // Ca. 10 skruer pr. meter. 
        String pname = pm.getMaterialById(12).getPname();
        int price = pm.getMaterialById(12).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(12);
        int b = ((length + width) / 100);
        int amount = 0;
        if (b <= 16) {
            amount = 1;

        } else if (b > 16 && b < 30) {
            amount = 2;
        }
        mat.setAmount(amount);
        return mat;
    }

    public Material universalOgHulbaandSkruer(int length, int width, int height) throws CarportException {
        // "4,0 x 50 mm. beslagskruer 250 stk."
        String pname = pm.getMaterialById(13).getPname();
        int price = pm.getMaterialById(13).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(13);
        int b = ((length + width) / 100);
        int amount = 0;
        if (b <= 16) {
            amount = 3;
        } else if (b > 16 && b < 30) {
            amount = 4;
        }
        mat.setAmount(amount);
        return mat;
    }

    public Material bræddebolt(int length, int width, int height) throws CarportException {
        // "bræddebolt 10 x 120 mm."
        String pname = pm.getMaterialById(14).getPname();
        int price = pm.getMaterialById(14).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(14);
        int amount = stolper(length, width, height).getAmount() * 2;
        mat.setAmount(amount);
        return mat;
    }

    public Material firkantskiver(int length, int width, int height) throws CarportException {
        // "firkantskiver 40x40x11mm"
        String pname = pm.getMaterialById(15).getPname();
        int price = pm.getMaterialById(15).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(15);
        int amount = stolper(length, width, height).getAmount() * 2;
        mat.setAmount(amount);
        return mat;
    }

    public ArrayList<Material> flatRoofMaterial(int length, int width, int height) throws CarportException {
        ArrayList<Material> treeAndRoofTiles = new ArrayList();
        treeAndRoofTiles.add(brædderForOgBag(length, width, height));
        treeAndRoofTiles.add(brædderSiderne(length, width, height));
        treeAndRoofTiles.add(oversternBrædderForenden(length, width, height));
        treeAndRoofTiles.add(oversternBrædderSiderne(length, width, height));
        treeAndRoofTiles.add(remISider(length, width, height));
        treeAndRoofTiles.add(spaer(length, width, height));
        treeAndRoofTiles.add(stolper(length, width, height));
        treeAndRoofTiles.add(vandbrætSide(length, width, height));
        treeAndRoofTiles.add(vandbrætFor(length, width, height));
        treeAndRoofTiles.add(tagPladeStor(length, width, height));
        treeAndRoofTiles.add(tagPladeLille(length, width, height));
        treeAndRoofTiles.add(tagPladeSkruer(length, width, height));
        treeAndRoofTiles.add(hulbaand(length, width, height));
        treeAndRoofTiles.add(universalBeslagHøjre(length, width, height));
        treeAndRoofTiles.add(universalBeslagVenstre(length, width, height));
        treeAndRoofTiles.add(skruerSternOgVandbræt(length, width, height));
        treeAndRoofTiles.add(universalOgHulbaandSkruer(length, width, height));
        treeAndRoofTiles.add(bræddebolt(length, width, height));
        treeAndRoofTiles.add(firkantskiver(length, width, height));
        return treeAndRoofTiles;
    }

}
