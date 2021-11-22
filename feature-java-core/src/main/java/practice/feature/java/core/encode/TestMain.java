package practice.feature.java.core.encode;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TestMain {

    protected static final Base64.Decoder decoder = Base64.getDecoder();
    protected static final Base64.Encoder encoder = Base64.getEncoder();

    public static void main(String[] args) {

        String encode1 = new String(
            encoder.encode(
                encoder.encode("LTAI4FwoZ8t4BQyN7vJQbo7K==eZHCy4vg8fcLtVJlhzHF2iDFvni4Wr".getBytes(StandardCharsets.UTF_8))
            )
        );
        System.out.println(encode1);
        System.out.println("VEZSQlNXVXlhbmhLT1VZd2JFeElUejA5U2tObWFUSkVhME0zZEVob2RGbDRNVmh5UVZaU1VFUkRXRmx0YTFacA==");

        String accessIdReal = new String(decoder.decode(decoder
            .decode("VEZSQlNXVXlhbmhLT1VZd2JFeElUejA5U2tObWFUSkVhME0zZEVob2RGbDRNVmh5UVZaU1VFUkRXRmx0YTFacA==")));
        String[] accessKeyReal = accessIdReal.split("==");
        System.out.println(accessKeyReal[0]);
        System.out.println(accessKeyReal[1]);
    }
}

