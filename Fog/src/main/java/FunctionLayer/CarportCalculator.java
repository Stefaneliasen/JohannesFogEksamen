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
        cvasga.stk2(length, width, height);
        cvasga.stk1(length, width, height);
    }

    public Material stk1(int length, int width, int height) throws CarportException {
        // "25x200 mm. trykimp. Brædt"
        int l = width + 5;
        String pname = pm.getMaterialById(1).getPname();
        int price = pm.getMaterialById(1).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(l);
        mat.setAmount(4);
        mat.setLength(l);
        return mat;
    }

    public Material stk2(int length, int width, int height) throws CarportException {
        // "25x200 mm. trykimp. Brædt"
        String pname = pm.getMaterialById(1).getPname();
        int price = pm.getMaterialById(1).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(1);
        mat.setAmount(2);
        mat.setLength(length);
        return mat;
    }

    public Material stk3(int length, int width, int height) throws CarportException {
        // "25x125mm. trykimp. Brædt"
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

    public Material stk4(int length, int width, int height) throws CarportException {
        // "25x125mm. trykimp. Brædt"
        String pname = pm.getMaterialById(2).getPname();
        int price = pm.getMaterialById(2).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(2);
        mat.setAmount(4);
        mat.setLength(length);
        return mat;
    }

    public Material stk5(int length, int width, int height) throws CarportException {
        // 45x195 mm. spærtræ ubh.
        // der bruges 1 rem til hver ende af carporten.
        String pname = pm.getMaterialById(5).getPname();
        int price = pm.getMaterialById(5).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(5);
        mat.setAmount(2);
        mat.setLength(width);
        return mat;
    }

    public Material stk6(int length, int width, int height) throws CarportException {
        // "45x195 mm. spærtræ ubh."
        String pname = pm.getMaterialById(5).getPname();
        int price = pm.getMaterialById(5).getPrice();
        Material mat = new Material(pname, price);
        int amount = (int) Math.ceil(length / 55);
        mat.setId(5);
        mat.setAmount(amount);
        mat.setLength(width);
        return mat;
    }

    public Material stk7(int length, int width, int height) throws CarportException {
        // "97x97 mm. trykimp. Stolpe"
        // stolperne graves 90cm ned i jorden, så de skal være 90cm længere end højden
        String pname = pm.getMaterialById(6).getPname();
        int price = pm.getMaterialById(6).getPrice();
        Material mat = new Material(pname, price);
        int l = height + 90;
        mat.setId(6);
        mat.setLength(l);
        if (length <= 460) {
            mat.setAmount(4);
        } else if (length > 460 || length <= 780) {
            mat.setAmount(6);
        } else if (length > 780 || length < 1300) {
            mat.setAmount(8);
        }
        return mat;
    }

    public Material stk8(int length, int width, int height) throws CarportException {
        //"19x100 mm. trykimp. Brædt"
        String pname = pm.getMaterialById(7).getPname();
        int price = pm.getMaterialById(7).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(7);
        mat.setAmount(4);
        mat.setLength(length);
        return mat;
    }

    public Material stk9(int length, int width, int height) throws CarportException {
        // "19x100 mm. trykimp. Brædt"
        String pname = pm.getMaterialById(7).getPname();
        int price = pm.getMaterialById(7).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(7);
        mat.setAmount(2);
        mat.setLength(width);
        return mat;
    }

    public Material stk10(int length, int width, int height) throws CarportException {
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

    public Material stk11(int length, int width, int height) throws CarportException {
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

    public Material stk12(int length, int width, int height) throws CarportException {
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

    public Material stk13(int length, int width, int height) throws CarportException {
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

    public Material stk14(int length, int width, int height) throws CarportException {
        // "universal 190 mm højre"
        String pname = pm.getMaterialById(11).getPname();
        int price = pm.getMaterialById(11).getPrice();
        Material mat = new Material(pname, price);
        int amount = (int) Math.ceil(length / 55);
        mat.setAmount(amount);
        mat.setId(11);
        return mat;
    }

    public Material stk15(int length, int width, int height) throws CarportException {
        // "universal 190 mm højre"
        String pname = pm.getMaterialById(11).getPname();
        int price = pm.getMaterialById(11).getPrice();
        Material mat = new Material(pname, price);
        int amountOfMaterial = (int) Math.ceil(length / 55);
        mat.setAmount(amountOfMaterial);
        mat.setId(11);
        return mat;
    }

    public Material stk16(int length, int width, int height) throws CarportException {
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

    public Material stk17(int length, int width, int height) throws CarportException {
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

    public Material stk18(int length, int width, int height) throws CarportException {
        // "bræddebolt 10 x 120 mm."
        String pname = pm.getMaterialById(14).getPname();
        int price = pm.getMaterialById(14).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(14);
        int amount = stk7(length, width, height).getAmount() * 2;
        mat.setAmount(amount);
        return mat;
    }

    public Material stk19(int length, int width, int height) throws CarportException {
        // "firkantskiver 40x40x11mm"
        String pname = pm.getMaterialById(15).getPname();
        int price = pm.getMaterialById(15).getPrice();
        Material mat = new Material(pname, price);
        mat.setId(15);
        int amount = stk7(length, width, height).getAmount() * 2;
        mat.setAmount(amount);
        return mat;
    }

    public ArrayList<Material> flatRoofMaterial(int length, int width, int height) throws CarportException {
        ArrayList<Material> treeAndRoofTiles = new ArrayList();
        treeAndRoofTiles.add(stk1(length, width, height));
        treeAndRoofTiles.add(stk2(length, width, height));
        treeAndRoofTiles.add(stk3(length, width, height));
        treeAndRoofTiles.add(stk4(length, width, height));
        treeAndRoofTiles.add(stk5(length, width, height));
        treeAndRoofTiles.add(stk6(length, width, height));
        treeAndRoofTiles.add(stk7(length, width, height));
        treeAndRoofTiles.add(stk8(length, width, height));
        treeAndRoofTiles.add(stk9(length, width, height));
        treeAndRoofTiles.add(stk10(length, width, height));
        treeAndRoofTiles.add(stk11(length, width, height));
        treeAndRoofTiles.add(stk12(length, width, height));
        treeAndRoofTiles.add(stk13(length, width, height));
        treeAndRoofTiles.add(stk14(length, width, height));
        treeAndRoofTiles.add(stk15(length, width, height));
        treeAndRoofTiles.add(stk16(length, width, height));
        treeAndRoofTiles.add(stk17(length, width, height));
        treeAndRoofTiles.add(stk18(length, width, height));
        treeAndRoofTiles.add(stk19(length, width, height));

        return treeAndRoofTiles;
    }

}
