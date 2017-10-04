/**
 * Created by nealsanghvi on 6/25/16.
 */
public class Result {
    String og;
    String ng;

    public Result(String originalword, String encoded) {
        og = originalword;
        ng = encoded;
    }

    public String getOG() {
        return og;
    }

    public String getEncoded() {
        return ng;
    }
}
