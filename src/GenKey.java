import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;

public class GenKey {

    public static String generator() throws NoSuchAlgorithmException {

        byte[] values = new byte[16];
        SecureRandom random = SecureRandom.getInstanceStrong();
        random.nextBytes(values);

        StringBuilder str = new StringBuilder();
        for (byte a : values) {
            str.append(String.format("%02x", a));
        }
        return str.toString();
    }

    public static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public static String calculateHMAC(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException {

        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA3-256");
        Mac mac = Mac.getInstance("HmacSHA3-256");
        mac.init(secretKeySpec);
        return toHexString(mac.doFinal(data.getBytes()));
    }
}
