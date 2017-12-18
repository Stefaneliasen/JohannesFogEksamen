package PresentationLayer;

public class SVGUtil {

    public static String svgRemme(int length, int width, int height, int sLength) {
        return "<rect x=\"0\" y=\"30\" height=\"4.5\" width=\"" + length + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" /> \n"
                + "<rect x=\"0\" y=\"" + width + "\" height=\"4.5\" width=\"" + length + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\"/>";
    }

    public static String svgSpær(int length, int width, int height, int sLength) {
        String res = "<rect x=\"" + (length - 1.5) + "\" y=\"25\" height=\"" + (width - 15) + "\" width=\"1.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />"
                + "<rect x=\"0.75\" y=\"25\" height=\"" + (width - 15) + "\" width=\"1.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
        int amount = length / 55;
        int afstandSpær = length / (amount);
        double xPos = afstandSpær;
        for (int i = 0; i <= amount - 2; i++) {
            res += "<rect x=\"" + xPos + "\" y=\"25\" height=\"" + (width - 15) + "\" width=\"1.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
            xPos += afstandSpær;
        }
        return res;
    }

    public static String svgStolper(int length, int width, int height, int sLength) {
        String res = "<rect x=\"100\" y=\"27.5\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />"
                + "<rect x=\"" + (length - 30) + "\" y=\"27.5\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
        String res2 = "<rect x=\"100\" y=\"" + (width - 3) + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />"
                + "<rect x=\"" + (length - 30) + "\" y=\"" + (width - 3) + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
        if (sLength > 0) {
            //14.5 er stolpens længde plus udhænget på hver side
            res += "<rect x=\"" + (length - 30) + "\" y=\"" + ((width / 2) + 14.5) + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
            res += "<rect x=\"" + (length - 30 - sLength) + "\" y=\"" + ((width / 2) + 14.5) + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
            res += "<rect x=\"" + (length - 30 - sLength) + "\" y=\"" + 27.5 + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
            res += "<rect x=\"" + (length - 30 - sLength) + "\" y=\"" + (width - 3) + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
            // poles to support shed if needed
            double amount = Math.ceil((double) sLength / 310);
            System.out.println("sLength " + sLength);
            System.out.println("amount " + amount);
            double x = length - 30 - sLength;
            double xPos = (sLength / (amount + 1)) + x;
            //Der skal kun være ekstra stolper i skuret, hvis sLength er længere end 400.
            if (sLength > 400) {
                for (int i = 0; i <= amount; i++) {
                    res += "<rect x=\"" + xPos + "\" y=\"27.5\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
                    res2 += "<rect x=\"" + xPos + "\" y=\"" + (width - 3) + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
                    System.out.println("x" + xPos);
                    xPos += (sLength / (amount + 1));
                    System.out.println("i " + i);
                }
            }
            //poles to support rest of the carport
            double amount2 = Math.round((length - 139.5 - sLength) / 310);
            System.out.println("amount2 " + amount2);
            int currentPos2 = 100;
            double xPos2 = ((length - 139.5 - sLength) / (amount2 + 1)) + currentPos2;
            if (length - 30 - sLength > 400) {
                for (int i = 0; i < amount2; i++) {
                    res += "<rect x=\"" + xPos2 + "\" y=\"27.5\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
                    res2 += "<rect x=\"" + xPos2 + "\" y=\"" + (width - 3) + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
                    xPos2 += (length - 139.5 - sLength) / (amount2 + 1);
                    System.out.println("x2" + xPos2);
                }
            }
        } else {
            //FORKLAR 139.5
            double amount = Math.ceil((length - 139.5) / 310);
            double currentPos = 100;
            double xPos = (length - 139.5) / (amount+1) + currentPos;
            for (int i = 0; i < amount; i++) {
                res += "<rect x=\"" +  xPos + "\" y=\"27.5\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
                res2 += "<rect x=\"" +  xPos + "\" y=\"" + (width - 3) + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
                xPos += (length - 139.5) / (amount+1);
            }
        }
        return res + res2;
    }

    public static String svgKryds(int length, int width, int height, int sLength) {
        String line1 = "";
        String line2 = "";
        if (sLength > 0) {
            line1 = "<path stroke-dasharray=\"5.5\" d=\"M55 35 " + (length - 30 - sLength) + " " + width + "\"/>";
            line2 = "<path stroke-dasharray=\"5.5\" d=\"M55 " + width + " " + (length - 30 - sLength) + " 35\"/>";
        } else {
            // 30cm udhæng fra sidste stolpe, hulbånd går til sidste stolpe derfor siger vi length - 30
            line1 = "<path stroke-dasharray=\"5.5\" d=\"M55 35 " + (length - 30) + " " + width + "\"/>";
            line2 = "<path stroke-dasharray=\"5.5\" d=\"M55 " + width + " " + (length - 30) + " 35\"/>";
        }
        String fill = "<g fill=\"none\" stroke=\"green\" stroke-width=\"2\">";
        String endFill = "< / g >";
        return fill + line1 + line2 + endFill;
    }

    public static String svgMål(int length, int width, int height, int sLength) {
        String vertical = "<line x1=\"" + 0 + "\" y1=\"" + (width + 30) + "\" x2=\"" + length + "\" y2=\"" + (width + 30) + "\" style=\"stroke:rgb(0,0,0);stroke-width:2\"/>";
        String horizontal = "<line x1=\"" + (length + 20) + "\" y1=\"" + (width + 10) + "\" x2=\"" + (length + 20) + "\" y2=\"" + 25 + "\" style=\"stroke:rgb(0,0,0);stroke-width:2\"/>";
        String textLength = "<text x=\"" + (length / 2) + "\" y=\"" + (width + 50) + "\" fill=\"black\">" + length + "</text>";
        String textWidth = "<text x=\"" + (length + 40) + "\" y=\"" + ((width / 2) + 20) + "\" fill=\"black\">" + width + "</text>";

        return vertical + horizontal + textLength + textWidth;
    }

    public static String svgSkur(int length, int width, int height, int sLength) {
        String skur = "";
        if (sLength > 0) {
            skur = "<rect x=\"" + ((length - 30) - sLength) + "\" y=\"30\" height=\"" + (width - 25) + "\" width=\"" + (sLength + 9.5) + "\" style=\"stroke:rgb(255,255,255);fill:none;stroke-width:2;stroke:rgb(0,0,0);stroke-dasharray: 10 5;\" />";
        }
        return skur;
    }

    public static String svgCarport(int length, int width, int height, int sLength) {
        return svgSkur(length, width, height, sLength)
                + svgRemme(length, width, height, sLength)
                + svgSpær(length, width, height, sLength)
                + svgStolper(length, width, height, sLength)
                + svgKryds(length, width, height, sLength)
                + svgMål(length, width, height, sLength);
    }
}
