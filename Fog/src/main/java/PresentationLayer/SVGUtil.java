package PresentationLayer;

public class SVGUtil {

    public static String svgRemme(int length, int width, int height) {
        return "<rect x=\"0\" y=\"30\" height=\"4.5\" width=\"" + length + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" /> \n"
                + "<rect x=\"0\" y=\"" + width + "\" height=\"4.5\" width=\"" + length + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\"/>";
    }

    public static String svgSpær(int length, int width, int height) {
        String res = "<rect x=\"" + (length - 1.5) + "\" y=\"25\" height=\"" + (width - 15) + "\" width=\"1.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />"
                + "<rect x=\"0.75\" y=\"25\" height=\"" + (width - 15) + "\" width=\"1.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
        int amount = length / 55;
        int afstandSpær = length / (amount);
        System.out.println(afstandSpær);

        double xPos = afstandSpær;
        for (int i = 0; i <= amount - 2; i++) {
            res += "<rect x=\"" + xPos + "\" y=\"25\" height=\"" + (width - 15) + "\" width=\"1.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
            xPos += afstandSpær;
        }
        return res;
    }

    public static String svgStolper(int length, int width, int height) {
        String res = "<rect x=\"100\" y=\"27.5\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />"
                + "<rect x=\"" + (length - 30) + "\" y=\"27.5\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";

        String res2 = "<rect x=\"100\" y=\"" + (width - 3) + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />"
                + "<rect x=\"" + (length - 30) + "\" y=\"" + (width - 3) + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
        double amount = Math.round((length - 130) / 310);
        System.out.println("amount " + amount);
        System.out.println("length " + length);
        double afstandStolper = (length / amount) / 2;
        System.out.println(afstandStolper);
        System.out.println(afstandStolper);
        double xPos = afstandStolper;
        double currentPos = 100;
        if (length >= 440) {
            for (int i = 0; i <= amount - 1; i++) {
                res += "<rect x=\"" + (currentPos + xPos) + "\" y=\"27.5\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
                res2 += "<rect x=\"" + (currentPos + xPos) + "\" y=\"" + (width - 3) + "\" height=\"9.5\" width=\"9.5\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
                xPos += afstandStolper;
            }
        }
        return res + res2;
    }

    public static String svgKryds(int length, int width, int height) {
        String fill = "<g fill=\"none\" stroke=\"green\" stroke-width=\"2\">";
        // 30cm udhæng fra sidste stolpe, hulbånd går til sidste stolpe derfor siger vi length - 30
        String line1 = "<path stroke-dasharray=\"5.5\" d=\"M55 35 " + (length-30) + " " + width + "\"/>";
        String line2 = "<path stroke-dasharray=\"5.5\" d=\"M55 " + width + " " + (length - 30) + " 35\"/>";
        String endFill = "< / g >";
        return fill + line1 + line2 + endFill;
    }

    public static String svgCarport(int length, int width, int height) {
        return svgRemme(length, width, height)
                + svgSpær(length, width, height)
                + svgStolper(length, width, height)
                + svgKryds(length, width, height);
    }
}
