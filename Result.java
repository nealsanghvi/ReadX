
public class Result {

    String og;
    String ng;

    public Result(String originalword, String encoded) {
        og = originalword;
        ng = encoded;

    }

    public String getOG() {
        //System.out.println("originalWord: " + og);

        return og;
    }

    public String getEncoded() {
       // System.out.println("encoded: " + ng);

        return ng;
    }

}
